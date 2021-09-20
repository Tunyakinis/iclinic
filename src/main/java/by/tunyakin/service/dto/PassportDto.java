package by.tunyakin.service.dto;

import by.tunyakin.model.Passport;
import by.tunyakin.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class PassportDto {

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

    @JsonProperty("gender_name")
    private String genderName;

    @JsonProperty("issue_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate issueDate;

    @JsonProperty("expire_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    public PassportDto() {
    }

    public PassportDto(Passport passport){
        if (passport != null) {
            this.setSurname(passport.getSurname());
            this.setName(passport.getName());
            this.setIdentificationNumber(passport.getIdentificationNumber());
            this.setPassportNumber(passport.getPassportNumber());
            this.setNationality(passport.getNationality());
            this.setDateOfBirth(passport.getDateOfBirth());
            this.setGender(passport.getGender());
            this.setIssueDate(passport.getIssueDate());
            this.setExpirationDate(passport.getExpireDate());
        }
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
        this.genderName = gender.getGenderName();
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

}
