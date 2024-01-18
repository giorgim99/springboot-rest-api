package ge.mais.api.dto;

import ge.mais.api.entities.City;

public class AddCity {

    private Long city_id;
    private String city;

    public AddCity(Long city_id, String city) {
        this.city_id = city_id;
        this.city = city;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
