package com.sabrysolutions.voyager.backend.services;

import com.sabrysolutions.voyager.backend.models.Country;
import com.sabrysolutions.voyager.backend.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> loadCountries() {
        List<Country> All_Countries = countryRepository.findAll();

        List<Country> Countries =new ArrayList<>();
        for (Country country :All_Countries){

            Countries.add(country);
        }
        return Countries;
    }



}
