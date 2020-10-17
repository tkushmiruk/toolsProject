package ua.taras.kushmyruk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.taras.kushmyruk.service.RegistrationService;

@Controller
public class RegistrationController {
    RegistrationService registrationService;


    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping("registration")
    public String registrationPage() {
        System.out.println("get method");
        return "registration";
    }

    @PostMapping("registration")
    public String registrate(@RequestParam String username, @RequestParam String password) {
        boolean isRegistered = registrationService.registrate(username, password);
        System.out.println(isRegistered);
        if (isRegistered) {
            return "greeting";
        }
        return "registration";
    }
}
