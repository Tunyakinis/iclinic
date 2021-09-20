package by.tunyakin.service.dto;

import by.tunyakin.model.User;
import by.tunyakin.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class UserProfileDto {
    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("department")
    private String department;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("name")
    private String name;

    @JsonProperty("identification_number")
    private String identificationNumber;

    @JsonProperty("passport_number")
    private String passportNumber;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @JsonProperty("gender")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Gender gender;

    @JsonProperty("issue_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate issueDate;

    @JsonProperty("expiration_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    @JsonProperty("country")
    private String country;

    @JsonProperty("city")
    private String city;

    @JsonProperty("street")
    private String street;

    @JsonProperty("house")
    private String house;

    @JsonProperty("apartment")
    private String apartment;

    public UserProfileDto() {
    }

    public UserProfileDto(User user) {
        if (user != null) {
            this.email = user.getEmail();
            this.phone = user.getPhone();
            if (user.getDepartment() != null) {
                this.department = user.getDepartment().getName();
            }
             else{
                 this.department = null;
            }
                if (user.getPassport() != null) {
                    this.identificationNumber = user.getPassport().getIdentificationNumber();
                    this.name = user.getPassport().getName();
                    this.surname = user.getPassport().getSurname();
                    this.passportNumber = user.getPassport().getPassportNumber();
                    this.nationality = user.getPassport().getNationality();
                    this.dateOfBirth = user.getPassport().getDateOfBirth();
                    this.gender = user.getPassport().getGender();
                    this.issueDate = user.getPassport().getIssueDate();
                    this.expirationDate = user.getPassport().getExpireDate();
                    if (user.getAddress() != null) {
                        this.country = user.getAddress().getCountry();
                        this.city = user.getAddress().getCity();
                        this.street = user.getAddress().getStreet();
                        this.house = user.getAddress().getHouse();
                        this.apartment = user.getAddress().getApartment();
                    }
                }
            }
        }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
