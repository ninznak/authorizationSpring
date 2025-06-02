package ru.netology.springauthorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netology.springauthorization.authorities.Authorities;
import ru.netology.springauthorization.exceptions.InvalidData;
import ru.netology.springauthorization.exceptions.UnauthorizedUser;
import ru.netology.springauthorization.service.AuthorizationService;

import java.util.List;

@Controller
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showAuthForm() {
        return "auth";
    }

    @GetMapping("/authorize")
    public String getAuthorities(@RequestParam("user") String user,
                                 @RequestParam("password") String password,
                                 Model model) {
        try {
            List<Authorities> authorities = service.getAuthorities(user, password);
            model.addAttribute("authorities", authorities);
        } catch (InvalidData e) {
            model.addAttribute("error", "Неверные данные: " + e.getMessage());
        } catch (UnauthorizedUser e) {
            model.addAttribute("error", "Не авторизован: " + e.getMessage());
        }
        return "auth";
    }
}
