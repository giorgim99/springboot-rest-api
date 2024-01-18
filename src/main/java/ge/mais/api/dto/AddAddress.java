package ge.mais.api.dto;

import ge.mais.api.entities.City;
import ge.mais.api.entities.Customer;

import java.util.Date;

public class AddAddress {
    public City city;
    private String address;
    private String postalCode;

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;

    }
}
