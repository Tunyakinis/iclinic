package by.tunyakin.controller;

import by.tunyakin.model.User;
import by.tunyakin.service.api.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/signUp")
public class SignUpController {

    private final IUserService userService;

    public SignUpController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userSignUp(Model model){
        return "signUp";
    }

    @PostMapping
    public String registerUser(@RequestParam(name = "login") String login,
                               @RequestParam(name = "password") String password,
                               Model model){
        try{
            User user = userService.createUser(login, password);
        } catch (IllegalArgumentException e){
            model.addAttribute("error", "User with this login already exists");
            return "signUp";
        }
        return "index";
    }
}
