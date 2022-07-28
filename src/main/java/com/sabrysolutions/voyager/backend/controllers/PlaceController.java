package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.models.Place;
import com.sabrysolutions.voyager.backend.services.PlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Place", tags = {"Place Management"},
        description = "Place operations")
public class PlaceController {

    @Autowired
    private PlaceService placeService;


    @ApiOperation(value = "Loads all Places")
    @GetMapping(path = "/places",produces = "application/json")
    public SuccessList loadPlaces(){
        return new SuccessList(200,true, placeService.loadPlaces(),null);
    }

    @ApiOperation(value = "Loads all Cities")
    @GetMapping(path = "/{cityName}/places",produces = "application/json")
    public SuccessList loadPlacesByCity(@PathVariable String cityName){

        List<Place> places  = placeService.Places(cityName);
        return new SuccessList(200,true, places,null);



    }

}
