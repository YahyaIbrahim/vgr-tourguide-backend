package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.models.Activity;
import com.sabrysolutions.voyager.backend.services.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@Api(value = "Activity", tags = {"Activity Management"},
        description = "Activity operations")
public class ActivityController {
    @Autowired
    private ActivityService activityService;


    @ApiOperation(value = "Loads all Activities")
    @GetMapping(path = "/activities", produces = "application/json")
    public SuccessList loadCities() {
        return new SuccessList(200, true, activityService.loadActivities(), null);

    }

    @ApiOperation(value = "Loads all Activities")
    @PostMapping(path = "/{placeName}/activities", produces = "application/json")
    public SuccessList loadCitiesByCountry(@PathVariable String placeName) {
        List<Activity> activities = activityService.activities(placeName);
        return new SuccessList(200, true, activities, null);

    }
}
