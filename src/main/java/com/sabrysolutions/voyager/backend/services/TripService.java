package com.sabrysolutions.voyager.backend.services;

import com.sabrysolutions.voyager.backend.dto.TripsDto;
import com.sabrysolutions.voyager.backend.models.Booking;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.models.Trip;
import com.sabrysolutions.voyager.backend.repositories.BookingRepository;
import com.sabrysolutions.voyager.backend.repositories.ProfileRepository;
import com.sabrysolutions.voyager.backend.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class TripService {

    @Autowired
    TripRepository tripRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    ProfileRepository profileRepository;

    public List<TripsDto> trips(String email){
        Profile profile = profileRepository.findByEmail(email);
        List<Trip> All_trips = null;
        if (profile.isTourguide())
            All_trips  = tripRepository.findByGuideId(profile.getId());
        else{
            All_trips =tripRepository.findByTouristId(profile.getId());
        }

        List<TripsDto> tripsDtos =new ArrayList<>();
        for (Trip p :All_trips){
            changeStatus(p);
            Profile Guide = profileRepository.findFirstById(p.getGuideId());
            Profile Tourist = profileRepository.findFirstById(p.getTouristId());
            TripsDto tripsDto = new TripsDto();
            tripsDto.setStatus(p.getStatus());
            tripsDto.setTripLocation(p.getTripLocation());
            tripsDto.setGuideName(Guide.getDisplayName());
            tripsDto.setCost(p.getCost());
            tripsDto.setTripDate(p.getTripDate());
            tripsDto.setTouristName(Tourist.getDisplayName());
            tripsDtos.add(tripsDto);

        }
        return tripsDtos;
    }

    void changeStatus(Trip trip){
        Calendar cal = Calendar.getInstance();
        Booking booking = bookingRepository.findBookingByTourGuideIdAndTouristIdAndTripDate(trip.getGuideId(),trip.getTouristId(),trip.getTripDate());
        if(booking.getTripDate().getTime()- cal.getTime().getTime() <= 0){
           trip.setStatus("In Progress");
            tripRepository.save(trip);
        }
        if(booking.getTripEnd().getTime()- cal.getTime().getTime() <= 0){
            trip.setStatus("Done");
            tripRepository.save(trip);
        }

    }

}
