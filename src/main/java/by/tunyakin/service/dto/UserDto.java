package by.tunyakin.service.dto;

import by.tunyakin.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    public UserDto() {
    }

    public UserDto(User user) {
        if (user != null) {
            this.email = user.getEmail();
            this.phone = user.getPhone();
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
}
