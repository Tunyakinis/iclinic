package by.tunyakin.service.api;

import by.tunyakin.model.Address;
import by.tunyakin.model.Department;
import by.tunyakin.model.Passport;
import by.tunyakin.model.User;
import by.tunyakin.model.enums.Role;
import by.tunyakin.service.dto.AddressDto;
import by.tunyakin.service.dto.PassportDto;

import java.util.List;

public interface IUserService {
    User getUserByLogin (String login);
    User updateUserRoleAndDepartment (Role role, String department, String login);
    User getUserById(Integer id);
    List<User> getAllUsers();
    List<User> getAllPatients();
    List<User> getAllDoctors();
    User createUser(String login, String password);
    User getByLogin(String login);
    User updateUser(User user, Integer id);
    Address createAddress(User user, AddressDto addressDTO);
    Address updateAddress(User user, AddressDto addressDTO);
    void deleteAddress(User user);
    Passport createPassport(User user, PassportDto passportDTO);
    Passport updatePassport(User user, PassportDto passportDTO);
    void deletePassport(User user);
}

