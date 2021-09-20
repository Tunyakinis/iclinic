package by.tunyakin.service.dto;

import by.tunyakin.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDto {

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

    public AddressDto() {
    }

    public AddressDto(Address address) {
        if (address != null) {
            this.setCountry(address.getCountry());
            this.setCity(address.getCity());
            this.setStreet(address.getStreet());
            this.setHouse(address.getHouse());
            this.setApartment(address.getApartment());
        }
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
