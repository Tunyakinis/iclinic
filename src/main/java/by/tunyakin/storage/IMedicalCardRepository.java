package by.tunyakin.storage;

import by.tunyakin.model.MedicalCard;
import by.tunyakin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IMedicalCardRepository extends JpaRepository<MedicalCard, Integer> {

    MedicalCard findByUser(User user);
    MedicalCard findMedicalCardById(Integer id);
}
