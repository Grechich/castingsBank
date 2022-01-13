package com.gmail.grechich.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
public class MyController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public MyController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String index(Model model){
        User user = getCurrentUser();
        String login = user.getUsername();
        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());
        model.addAttribute("admin", isAdmin(user));
        return "index";
    }

    @GetMapping(value = "/allUsers")
    public String update(Model model) {
        List<CustomUser> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping(value = "/newuser")
    public String update(@RequestParam String login,
                         @RequestParam String password,
                         Model model) {
        String passHash = passwordEncoder.encode(password);
        if ( ! userService.addUser(login, passHash, UserRole.USER)) {
            model.addAttribute("exists", true);
            model.addAttribute("login", login);
            System.out.println("User exist");
            return "register";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("admin", isAdmin(getCurrentUser()));
        return "redirect:/allUsers";
        }

    private User getCurrentUser() {
        return (User)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    private boolean isAdmin(User user) {
        Collection<GrantedAuthority> roles = user.getAuthorities();
        for (GrantedAuthority auth : roles) {
            if ("ROLE_ADMIN".equals(auth.getAuthority()))
                return true;
        }
        return false;
    }
}
