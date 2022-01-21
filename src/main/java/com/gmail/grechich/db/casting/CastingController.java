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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String casting(@RequestParam(required = false) String drawing,
                           Model model) {
        Casting casting = castingService.getCastingsByDrawing(drawing);
        model.addAttribute("casting", casting);
        model.addAttribute("admin", isAdmin(getCurrentUser()));
//        return "сastingPage";
        return "index";
//        return "redirect:/allCastings";
    }


    @GetMapping("/allCastings")
    public String showAllCastings(@RequestParam(required = false) String type,
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
    public String deleteCasting(@RequestParam Long id, Model model) {
        castingService.deleteCasting(id);
        model.addAttribute("admin", isAdmin(getCurrentUser()));
        return "redirect:/allCastings";
    }

    @GetMapping("/search")
    public String searchCasting(@RequestParam(required = false) String search, Model model) {
        if (search.equals(""))
            return "forward:/allCastings";
        List<Casting> castings = castingService.searchCastings(search);
        model.addAttribute("castings", castings);
        model.addAttribute("search", search);
        model.addAttribute("admin", isAdmin(getCurrentUser()));
        return "search";
    }

    @PostMapping("/update")
    public String update(@RequestParam String drawing,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) String castingWeight,
                          RedirectAttributes redirectAttributes) {
        Casting casting = castingService.getCastingsByDrawing(drawing);

        if (castingWeight != null) {
            try {
                casting.setCastingWeight(Double.parseDouble(castingWeight));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "forward:/allCastings";
            }
        }
        if (name != null) {
            casting.setName(name);
        }
        castingService.updateCasting(casting);
        redirectAttributes.addAttribute("drawing", drawing);
        return "forward:/castingPage";
    }

    @PostMapping("/addModel")
    public String addModel(@RequestParam String drawing,
                            RedirectAttributes redirectAttributes) {
        Casting casting = castingService.getCastingsByDrawing(drawing);
        casting.getModls().add(new ModelCasting(drawing, casting.getModls().size()));
        casting.getModls().get(casting.getModls().size() - 1).setCasting(casting);
        castingService.updateCasting(casting);
        redirectAttributes.addAttribute("drawing", drawing);
        return "forward:/castingPage";
    }


    private User getCurrentUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            throw new RuntimeException("Need to authorise");
        }
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    private boolean isAdmin(User user) {
        if (user != null) {
            Collection<GrantedAuthority> roles = user.getAuthorities();
            for (GrantedAuthority auth : roles) {
                if ("ROLE_ADMIN".equals(auth.getAuthority()))
                    return true;
            }
        }
        return false;
    }
}
