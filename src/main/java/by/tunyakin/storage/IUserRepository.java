package by.tunyakin.storage;

import by.tunyakin.model.User;
import by.tunyakin.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    User findByLogin(String login);

    User findByEmail(String email);

    List<User> findAllByRole(Role role);

    User getUserByLogin (String login);
}
