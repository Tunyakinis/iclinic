package by.tunyakin.storage;

import by.tunyakin.model.Diagnosis;
import by.tunyakin.model.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
    List<Diagnosis> findByMedicalCardId(Integer id);
    List <Diagnosis> findDiagnosisByMedicalCard(MedicalCard medicalCard);
}
