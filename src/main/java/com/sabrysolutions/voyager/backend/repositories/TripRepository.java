package com.sabrysolutions.voyager.backend.repositories;


import com.sabrysolutions.voyager.backend.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Long> {

    List<Trip> findByTouristId(long touristId);

    List<Trip> findByGuideId(Long profile_id);
}
