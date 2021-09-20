package by.tunyakin.controller.rest;

import by.tunyakin.model.MedicalCard;
import by.tunyakin.model.User;
import by.tunyakin.service.api.IDiagnosisService;
import by.tunyakin.service.api.IMedicalCardService;
import by.tunyakin.service.api.IUserService;
import by.tunyakin.service.dto.DiagnosisDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/createNewNote")
public class MedicalCardRestController {

    private final IDiagnosisService diagnosisService;
    private final IMedicalCardService medicalCardService;

    public MedicalCardRestController(IDiagnosisService diagnosisService,
                                     IMedicalCardService medicalCardService,
                                     IUserService userService) {
        this.diagnosisService = diagnosisService;
        this.medicalCardService = medicalCardService;
    }

    @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public ResponseEntity<Object> createNewNote(@RequestBody DiagnosisDto diagnosisDto,
                                                @PathVariable Integer id) {
        MedicalCard medicalCard = medicalCardService.getMedicalCardById(id);
        return new ResponseEntity<>(new DiagnosisDto(diagnosisService.createDiagnosis(medicalCard,
                diagnosisDto)), HttpStatus.OK);
    }
}
