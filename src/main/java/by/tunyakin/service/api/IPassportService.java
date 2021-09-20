package by.tunyakin.service.api;

import by.tunyakin.model.Passport;
import by.tunyakin.model.User;
import by.tunyakin.service.dto.PassportDto;

public interface IPassportService {
    Passport createPassport(User user, PassportDto passportDto);
    Passport updatePassport(User user, PassportDto passportDto);
    void deletePassport(User user);
}
