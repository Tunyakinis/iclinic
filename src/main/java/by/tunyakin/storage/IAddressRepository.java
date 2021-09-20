package by.tunyakin.storage;

import by.tunyakin.model.Address;
import by.tunyakin.model.Passport;
import by.tunyakin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

    @Transactional
    void deleteByUser(User user);

    Passport findByUser(User user);
}
