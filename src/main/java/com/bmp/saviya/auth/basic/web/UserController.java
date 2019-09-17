package com.bmp.saviya.auth.basic.web;

import com.bmp.saviya.auth.basic.model.User;
import com.bmp.saviya.auth.basic.service.SecurityService;
import com.bmp.saviya.auth.basic.service.UserService;
import com.bmp.saviya.auth.basic.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(
    value = "/reg",
    method = RequestMethod.POST)
    public void process(@RequestBody Map<String, Object> payload)
        throws Exception {

        System.out.println(payload);
        String name = payload.get("name").toString();
        String password = payload.get("password").toString();
        System.out.println(name);
        System.out.println(password);
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        userService.save(user);
        securityService.autoLogin(name, password);

    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}
