package by.tunyakin.controller;

import by.tunyakin.service.api.IDiagnosisService;
import by.tunyakin.service.api.IMedicalCardService;
import by.tunyakin.service.api.IUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctorUserList")
public class DoctorController {

    private final IUserService userService;
    private final IMedicalCardService medicalCardService;
    private final IDiagnosisService diagnosisService;

    public DoctorController(IUserService userService, IMedicalCardService medicalCardService,
                            IDiagnosisService diagnosisService) {
        this.userService = userService;
        this.medicalCardService = medicalCardService;
        this.diagnosisService = diagnosisService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('DOCTOR')")
    public String getAllPatients(Model model) {
        model.addAttribute("doctorListOfPatients", userService.getAllPatients());
        return "doctorUserList";
    }
}