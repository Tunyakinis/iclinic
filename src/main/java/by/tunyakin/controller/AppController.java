package by.tunyakin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @GetMapping("/aboutUs")
    public String getAboutUsPage(){
        return "aboutUs";
    }

    @GetMapping("/contact")
    public String getContactPage(){
        return "contact";
    }

    @GetMapping("/editProfile")
    public String getEditProfilePage(){
        return "editProfile";
    }

    @GetMapping("/editProfile/passport")
    public String getEditPassportPage(){
        return "passport";
    }

    @GetMapping("/editProfile/address")
    public String getEditAddressPage(){
        return "address";
    }

    @GetMapping("/profile")
    public String getProfile(){
        return "profile";
    }

    @GetMapping("/medicalCard")
    public String getMedicalCard(){
        return "medicalCard";
    }

    @GetMapping("/createNewNote/{id}")
    public String getCreateNewNotePage(@PathVariable Integer id, Model model){
        model.addAttribute("medicalCardId", id);
        return "createNewNote";
    }
}
