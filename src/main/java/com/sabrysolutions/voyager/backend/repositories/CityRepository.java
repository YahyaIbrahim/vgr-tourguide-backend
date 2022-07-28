package com.sabrysolutions.voyager.backend.repositories;


import com.sabrysolutions.voyager.backend.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("select city from City city where city.name = ?1")
    City findFirstByName(String name);

    City findByName(String name);

    List<City> findByCountryCountryName(String name);

}
