package com.sabrysolutions.voyager.backend.controllers;


import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.models.Country;
import com.sabrysolutions.voyager.backend.services.CityService;
import com.sabrysolutions.voyager.backend.services.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Country", tags = {"Country Management"},
        description = "Country operations")
public class CountryController {
    @Autowired
    private CountryService countryService;


    @ApiOperation(value = "Loads all Countries")
    @GetMapping(path = "/countries",produces = "application/json")
    public SuccessList loadCountries(){
        return new SuccessList(200,true,countryService.loadCountries(),null);

    }

}
