package ge.mais.api.services;

import ge.mais.api.entities.City;
import ge.mais.api.repositories.CityRepository;

import java.util.List;

public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAll(){
        return cityRepository.findAll();
    }


}
