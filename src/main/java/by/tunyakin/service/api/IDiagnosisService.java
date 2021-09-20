package by.tunyakin.service.api;

import by.tunyakin.model.Diagnosis;
import by.tunyakin.model.MedicalCard;
import by.tunyakin.service.dto.DiagnosisDto;

import java.util.List;

public interface IDiagnosisService {
    List <Diagnosis> getDiagnosisByMedicalCard(MedicalCard medicalCard);
    List<Diagnosis> getAllDiagnosis ();
    Diagnosis createDiagnosis(MedicalCard medicalCard, DiagnosisDto diagnosisDto);
}
