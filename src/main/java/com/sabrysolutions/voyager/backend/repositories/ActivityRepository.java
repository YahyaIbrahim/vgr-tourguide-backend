package com.sabrysolutions.voyager.backend.repositories;


import com.sabrysolutions.voyager.backend.models.Activity;
import com.sabrysolutions.voyager.backend.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByPlaceName(String name);




}
