package com.sabrysolutions.voyager.backend.repositories;

import com.sabrysolutions.voyager.backend.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findByCity_Name(String name);

    Place findByName(String place);

}
