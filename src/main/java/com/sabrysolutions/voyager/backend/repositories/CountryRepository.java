package com.sabrysolutions.voyager.backend.repositories;


import com.sabrysolutions.voyager.backend.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByCountryName(String name);
}
