package by.tunyakin.service.api;

import by.tunyakin.model.Diagnosis;
import by.tunyakin.model.MedicalCard;
import by.tunyakin.model.User;

import java.util.List;

public interface IMedicalCardService {
    MedicalCard getMedicalCardByUser(User user);
    List<MedicalCard> getAllMedicalCards();
    MedicalCard getMedicalCardById(Integer id);
}
