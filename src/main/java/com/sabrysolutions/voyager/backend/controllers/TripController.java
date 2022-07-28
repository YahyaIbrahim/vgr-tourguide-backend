package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.dto.TripsDto;
import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.models.Booking;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.models.Trip;
import com.sabrysolutions.voyager.backend.services.ProfileService;
import com.sabrysolutions.voyager.backend.services.TripService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(value = "Trips APIs", tags = {"Trips Management"},
        description = "Trips operations")
public class TripController {

    @Autowired
    TripService tripService;

    @Autowired
    ProfileService profileService;


    @ApiOperation(value = "Load all Trips for a specific User")
    @GetMapping(path = "/{email}/trips",produces = MediaType.APPLICATION_JSON_VALUE)
    public SuccessList findTripByProfileEmail(@PathVariable String email) {
        try {
            List<TripsDto> trips = tripService.trips(email);

            return new SuccessList(200, true, trips, null);
        } catch (NullPointerException n) {
            return new SuccessList(400, false, null, "No Trips");
        }

    }
}
