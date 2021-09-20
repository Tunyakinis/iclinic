package by.tunyakin.service;

import by.tunyakin.model.*;
import by.tunyakin.model.enums.Role;
import by.tunyakin.service.api.IUserService;
import by.tunyakin.service.dto.AddressDto;
import by.tunyakin.service.dto.PassportDto;
import by.tunyakin.storage.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IAddressRepository addressRepository;
    private final IPassportRepository passportRepository;
    private final IMedicalCardRepository medicalCardRepository;
    private final IDepartmentRepository departmentRepository;


    private final PasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepository, IAddressRepository addressRepository, IPassportRepository passportRepository,
                       IMedicalCardRepository medicalCardRepository, IDepartmentRepository departmentRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passportRepository = passportRepository;
        this.medicalCardRepository = medicalCardRepository;
        this.departmentRepository = departmentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserByLogin(String login) {
        User user;
        try {
            user = this.userRepository.findByLogin(login);
        } catch (NoSuchElementException e) {
            return null;
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllPatients() {
        return userRepository.findAllByRole(Role.PATIENT);
    }

    @Override
    public List<User> getAllDoctors() {
        return userRepository.findAllByRole(Role.DOCTOR);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User createUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.USER);
        MedicalCard medicalCard = new MedicalCard();
        medicalCard.setUser(user);
        user.setMedicalCard(medicalCard);
        medicalCard.setUser(user);
        medicalCardRepository.save(medicalCard);
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user, Integer id) {
        User newUser = this.userRepository.findUserById(id);
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public User updateUserRoleAndDepartment(Role role, String department, String login ) {
        User user = this.userRepository.findByLogin(login);
        Department newDepartment = this.departmentRepository.getByName(department);
        user.setRole(role);
        user.setDepartment(newDepartment);
        userRepository.save(user);
        return user;
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public Address createAddress(User user, AddressDto addressDto) {
        userRepository.findUserById(user.getId());
        Address address = new Address();
        address.setUser(user);
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouse(addressDto.getHouse());
        address.setApartment(addressDto.getApartment());
        addressRepository.save(address);
        user.setAddress(address);
        userRepository.save(user);
        return address;
    }

    @Override
    public Address updateAddress(User user, AddressDto addressDto) {
        userRepository.findUserById(user.getId());
        Address address = user.getAddress();
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouse(addressDto.getHouse());
        address.setApartment(addressDto.getApartment());
        return userRepository.getById(user.getId()).getAddress();
    }

    @Transactional
    public void deleteAddress(User user) {
        addressRepository.deleteByUser(user);
    }

    @Override
    public Passport createPassport(User user, PassportDto passportDto) {
        userRepository.findUserById(user.getId());
        Passport passport = new Passport();
        passport.setUser(user);
        passport.setSurname(passportDto.getSurname());
        passport.setName(passportDto.getName());
        passport.setIdentificationNumber(passportDto.getIdentificationNumber());
        passport.setPassportNumber(passportDto.getPassportNumber());
        passport.setDateOfBirth(passportDto.getDateOfBirth());
        passport.setGender(passportDto.getGender());
        passport.setIssueDate(passportDto.getIssueDate());
        passport.setExpireDate(passportDto.getExpirationDate());
        passport.setNationality(passportDto.getNationality());
        passportRepository.save(passport);
        user.setPassport(passport);
        userRepository.save(user);
        return passport;
    }

    @Override
    public Passport updatePassport(User user, PassportDto passportDto) {
        userRepository.findUserById(user.getId());
        Passport passport = user.getPassport();
        passport.setSurname(passportDto.getSurname());
        passport.setName(passportDto.getName());
        passport.setIdentificationNumber(passportDto.getIdentificationNumber());
        passport.setPassportNumber(passportDto.getPassportNumber());
        passport.setDateOfBirth(passportDto.getDateOfBirth());
        passport.setGender(passportDto.getGender());
        passport.setIssueDate(passportDto.getIssueDate());
        passport.setExpireDate(passportDto.getExpirationDate());
        passport.setNationality(passportDto.getNationality());
        return userRepository.getById(user.getId()).getPassport();
    }

    @Override
    public void deletePassport(User user) {
        passportRepository.deleteByUser(user);
    }
}
