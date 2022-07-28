package com.sabrysolutions.voyager.backend.services;

import com.sabrysolutions.voyager.backend.models.City;
import com.sabrysolutions.voyager.backend.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CityService {
    @Autowired
    CityRepository cityRepository;


    public List<City> loadCites() {
        List<City> All_cities = cityRepository.findAll();

        List<City> cities =new ArrayList<>();
        for (City city :All_cities){

            cities.add(city);
        }
        return cities;
    }

    public List<City> cities(String countyName){
        List<City> All_Cities = cityRepository.findByCountryCountryName(countyName);

        List<City> cities =new ArrayList<>();
        for (City city :All_Cities){

            cities.add(city);
        }
        return cities;
    }

}
