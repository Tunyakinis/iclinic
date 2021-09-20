package by.tunyakin.storage;

import by.tunyakin.model.Passport;
import by.tunyakin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IPassportRepository extends JpaRepository<Passport, Integer> {

    @Transactional
    void deleteByUser(User user);

    Passport getPassportByUser(User user);
}
