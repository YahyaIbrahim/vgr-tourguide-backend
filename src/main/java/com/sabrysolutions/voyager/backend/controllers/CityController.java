package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.models.City;
import com.sabrysolutions.voyager.backend.models.Country;
import com.sabrysolutions.voyager.backend.models.Place;
import com.sabrysolutions.voyager.backend.repositories.CityRepository;
import com.sabrysolutions.voyager.backend.services.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "City", tags = {"City Management"},
        description = "City operations")
public class CityController {
    @Autowired
    private CityService cityService;


    @ApiOperation(value = "Loads all Cities")
    @GetMapping(path = "/cities",produces = "application/json")
    public SuccessList loadCities(){
        return new SuccessList(200,true,cityService.loadCites(),null);

    }

    @ApiOperation(value = "Loads all Cities")
    @PostMapping(path = "/{countryName}/cities",produces = "application/json")
    public SuccessList loadCitiesByCountry(@PathVariable String countryName){
       List<City> cities =  cityService.cities(countryName);
        return new SuccessList(200,true,cities,null);

    }






}

