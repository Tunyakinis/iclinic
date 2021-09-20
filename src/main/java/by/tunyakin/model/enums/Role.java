package by.tunyakin.model.enums;

public enum Role  {
    USER("user"),
    ADMIN("admin"),
    DOCTOR("doctor"),
    PATIENT("patient");

    final String role;

    Role(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}