package by.tunyakin.service;

import by.tunyakin.model.Diagnosis;
import by.tunyakin.model.MedicalCard;
import by.tunyakin.service.api.IDiagnosisService;
import by.tunyakin.service.dto.DiagnosisDto;
import by.tunyakin.storage.IDiagnosisRepository;

import java.util.List;

public class DiagnosisService implements IDiagnosisService {

    private IDiagnosisRepository diagnosisRepository;

    public DiagnosisService (IDiagnosisRepository diagnosisRepository){
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public List <Diagnosis> getDiagnosisByMedicalCard(MedicalCard medicalCard) {
        return diagnosisRepository.findDiagnosisByMedicalCard(medicalCard);
    }

    @Override
    public List<Diagnosis> getAllDiagnosis() {
        return this.diagnosisRepository.findAll();
    }

    @Override
    public Diagnosis createDiagnosis(MedicalCard medicalCard, DiagnosisDto diagnosisDto) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setMedicalCard(medicalCard);
        diagnosis.setDate(diagnosisDto.getDate());
        diagnosis.setSurname(diagnosisDto.getSurname());
        diagnosis.setName(diagnosisDto.getName());
        diagnosis.setDiagnosisType(diagnosisDto.getDiagnosisType());
        diagnosis.setDescription(diagnosisDto.getDescription());
        diagnosisRepository.save(diagnosis);
        return diagnosis;
    }
}
