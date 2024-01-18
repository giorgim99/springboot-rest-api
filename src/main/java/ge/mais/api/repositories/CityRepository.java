package ge.mais.api.repositories;

import ge.mais.api.entities.Address;
import ge.mais.api.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    City findOneByCity(String city);

}
