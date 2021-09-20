package by.tunyakin.model.enums;

public enum DiagnosisType {

    VACCINATION("vacation"),
    ADDITIONAL_EXAMINATION("additional_examination"),
    REFERRAL_FOR_BLOOD_TEST("referral_for_blood_test"),
    COMPLETELY_RECOVERED("completely_recovered"),
    COMPLETELY_HEALTHY("completely_healthy");

    final String diagnosisType;

    DiagnosisType(String diagnosisType){
        this.diagnosisType = diagnosisType;
    }

    public String getDiagnosisType() {
        return diagnosisType;
    }
}
