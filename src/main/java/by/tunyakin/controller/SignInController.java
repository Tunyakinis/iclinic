package by.tunyakin.controller;

import by.tunyakin.service.api.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/signIn")
public class SignInController {

    private final IUserService userService;

    public SignInController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userSignIn(){
        return "signIn";
    }
}
