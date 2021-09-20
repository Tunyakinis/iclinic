package by.tunyakin.config;

import by.tunyakin.service.*;
import by.tunyakin.service.api.*;
import by.tunyakin.storage.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@ComponentScan("by.tunyakin.config")
public class RootConfig {

    @Bean
    public IUserService userService(IUserRepository userRepository, IAddressRepository addressRepository,
                                    IPassportRepository passportRepository, IMedicalCardRepository medicalCardRepository,
                                    IDepartmentRepository departmentRepository, PasswordEncoder passwordEncoder) {
        return new UserService(userRepository, addressRepository, passportRepository,
                medicalCardRepository, departmentRepository, passwordEncoder);
    }

    @Bean
    public AuthProvider authProvider(IUserService userService) {
        return new AuthProvider(userService);
    }

    @Bean
    public IDepartmentService departmentService(IDepartmentRepository departmentRepository) {
        return new DepartmentService(departmentRepository);
    }

    @Bean
    public IDiagnosisService diagnosisService (IDiagnosisRepository diagnosisRepository) {
        return new DiagnosisService(diagnosisRepository);
    }

    @Bean
    public IMedicalCardService medicalCardService (IMedicalCardRepository medicalCardRepository) {
        return new MedicalCardService(medicalCardRepository);
    }
}
