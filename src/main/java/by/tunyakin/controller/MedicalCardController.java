package by.tunyakin.controller;

import by.tunyakin.model.User;
import by.tunyakin.service.api.IUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicalCard")
public class MedicalCardController {

    private final IUserService userService;

    public MedicalCardController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyAuthority('PATIENT', 'DOCTOR')")
    public String GetUserMedicalCardByUserId(@PathVariable Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("medCardId", user.getMedicalCard().getId());
        model.addAttribute("medicalCardList", user.getMedicalCard().getDiagnosis());
        return "medicalCard";
    }
}
