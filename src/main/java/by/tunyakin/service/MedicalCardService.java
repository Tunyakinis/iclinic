package by.tunyakin.service;

import by.tunyakin.model.MedicalCard;
import by.tunyakin.model.User;
import by.tunyakin.service.api.IMedicalCardService;
import by.tunyakin.storage.IMedicalCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCardService implements IMedicalCardService {

    private final IMedicalCardRepository medicalCardRepository;

    public MedicalCardService(IMedicalCardRepository medicalCardRepository) {
        this.medicalCardRepository = medicalCardRepository;
    }

    @Override
    public List<MedicalCard> getAllMedicalCards() {
        final List<MedicalCard> medicalCardList = this.medicalCardRepository.findAll();
        return medicalCardList;
    }

    @Override
    public MedicalCard getMedicalCardById(Integer id) {
        return medicalCardRepository.findMedicalCardById(id);
    }

    @Override
    public MedicalCard getMedicalCardByUser(User user) {
        return medicalCardRepository.findByUser(user);
    }
}
