package com.gmail.grechich.db.casting;

import com.gmail.grechich.db.documentation.Documentation;
import com.gmail.grechich.db.enums.*;
import com.gmail.grechich.db.model.ModelCasting;
import com.gmail.grechich.db.model.ModelService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class CastingController {

    private CastingService castingService;

    public CastingController(CastingService castingService, ModelService modelService) {
        this.castingService = castingService;
    }

    @PostMapping("/saveCasting")
    public String saveCasting(@RequestParam String name,
                              @RequestParam String drawingNumber,
                              @RequestParam(required = false) double castingWeight,
                              @RequestParam(required = false) String steelGrade,
                              @RequestParam(required = false) String castingTypeEnum,
                              @RequestParam(required = false) String castingRailEnum,
                              @RequestParam(required = false) String castingShopEnum,
                              Model model
    ) {
        List<ModelCasting> models = new ArrayList<>();
        ModelCasting modelCasting = new ModelCasting(drawingNumber, 1);
        models.add(modelCasting);
        Documentation documentation = new Documentation(drawingNumber);
        Casting casting = new Casting(name, drawingNumber, castingWeight, SteelGrade.valueOf(steelGrade),
                CastingType.valueOf(castingTypeEnum), Rail.valueOf(castingRailEnum), Shop.valueOf(castingShopEnum),
                models, documentation);
        casting.getModls().get(0).setCasting(casting);
        boolean saved = castingService.addCasting(casting);
        model.addAttribute("saved", saved);
        model.addAttribute("admin", isAdmin(getCurrentUser()));
        return "saveCasting";
    }

    @PostMapping("/addCasting")
    public String addCasting(Model model) {
        model.addAttribute("admin", isAdmin(getCurrentUser()));
        return "addCasting";
    }

    @PostMapping("/castingPage")
    public String casting(@RequestParam String drawing,
                          Model model) {
        Casting casting = castingService.getCastingsByDrawing(drawing);
        String castingDrawingUrl = casting.getDocumentation().getCastingDrawing();
        String detailDrawingUrl = casting.getDocumentation().getDetailDrawing();
        String model3dUrl = casting.getModls().get(0).getModelDrawing3D();
        model.addAttribute("casting", casting);
        model.addAttribute("castingDrawing", castingDrawingUrl);
        model.addAttribute("detailDrawing", detailDrawingUrl);
        model.addAttribute("model3d", model3dUrl);
        model.addAttribute("admin", isAdmin(getCurrentUser()));
        return "сastingPage";
    }


    @GetMapping("/allCastings")
    private String showAllCastings(@RequestParam(required = false) String type,
                                   @RequestParam(required = false) String shop,
                                   Model model) {
        List<Casting> castings;
        if (shop != null) {
            castings = castingService.getCastingsByShop(shop);

        } else {
            castings = castingService.getAllCastings();
        }
        model.addAttribute("castings", castings);
        model.addAttribute("type", type);
        model.addAttribute("admin", isAdmin(getCurrentUser()));
        if (type == null)
            return "allCastings";

        return "castings";
    }

    @PostMapping("/deleteCasting")
    private String deleteCasting(@RequestParam Long id, Model model) {
        castingService.deleteCasting(id);
        model.addAttribute("admin", isAdmin(getCurrentUser()));
        return "redirect:/allCastings";
    }

    @GetMapping("/search")
    private String searchCasting(@RequestParam(required = false) String search, Model model) {
        if (search.equals(""))
            return "redirect:/allCastings";
        List<Casting> castings = castingService.searchCastings(search);
//        List<Casting> castings = castingService.getCastingsBySearch(search);
        model.addAttribute("castings", castings);
        model.addAttribute("search", search);
        model.addAttribute("admin", isAdmin(getCurrentUser()));
        return "search";
    }


    @PostMapping("/update")
    public String update(@RequestParam String drawing, Model model) {
        model.addAttribute("casting", castingService.getCastingsByDrawing(drawing));

                Casting casting = castingService.getCastingsByDrawing(drawing);
        model.addAttribute("castingWeight", casting.getCastingWeight());
        model.addAttribute("steelGrade", casting.getSteelGrade());
        model.addAttribute("castingTypeEnum", casting.getCastingTypeEnum());
        model.addAttribute("castingRailEnum", casting.getCastingRailEnum());
        model.addAttribute("castingShopEnum", casting.getCastingShopEnum());
        model.addAttribute("modls", casting.getModls());
        model.addAttribute("admin", isAdmin(getCurrentUser()));
        return "update";
    }


    private User getCurrentUser() {
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    static boolean isAdmin(User user) {
        Collection<GrantedAuthority> roles = user.getAuthorities();
        for (GrantedAuthority auth : roles) {
            if ("ROLE_ADMIN".equals(auth.getAuthority()))
                return true;
        }
        return false;
    }
}
