package com.sabrysolutions.voyager.backend.services;


import com.sabrysolutions.voyager.backend.models.Place;
import com.sabrysolutions.voyager.backend.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {
    @Autowired
    PlaceRepository placeRepository;


    public List<Place> loadPlaces() {
        List<Place> All_places = placeRepository.findAll();

        List<Place> places =new ArrayList<>();
        for (Place p :All_places){

            places.add(p);
        }
        return places;
    }

    public List<Place> Places(String cityName){
        List<Place> All_places = placeRepository.findByCity_Name(cityName);

        List<Place> places =new ArrayList<>();
        for (Place place :All_places){

            places.add(place);
        }
        return places;
    }
}
