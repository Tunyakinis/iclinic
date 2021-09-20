package by.tunyakin.service.dto;

import by.tunyakin.model.Diagnosis;
import by.tunyakin.model.enums.DiagnosisType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class DiagnosisDto {

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonProperty("diagnosis_type")
    private DiagnosisType diagnosisType;

    @JsonProperty("description")
    private String description;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("name")
    private String name;

    @JsonProperty("medical_card")
    private Integer medicalCardId;

    public DiagnosisDto() {
    }

    public DiagnosisDto(Diagnosis diagnosis){
        if (diagnosis != null){
            this.medicalCardId = diagnosis.getMedicalCard().getId();
            this.surname = diagnosis.getSurname();
            this.name = diagnosis.getName();
            this.date = diagnosis.getDate();
            this.diagnosisType = diagnosis.getDiagnosisType();
            this.description = diagnosis.getDescription();
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DiagnosisType getDiagnosisType() {
        return diagnosisType;
    }

    public void setDiagnosisType(DiagnosisType diagnosisType) {
        this.diagnosisType = diagnosisType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
