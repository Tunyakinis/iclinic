package by.tunyakin.model.enums;

public enum Gender {

    FEMALE("FEMALE"),
    MALE("MALE");

    final String genderName;

    Gender(String genderName){
        this.genderName = genderName;
    }

    public String getGenderName() {
        return genderName;
    }
}

