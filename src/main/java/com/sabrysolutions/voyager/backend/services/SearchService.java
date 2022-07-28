package com.sabrysolutions.voyager.backend.services;

import com.sabrysolutions.voyager.backend.dto.SearchCriteria;
import com.sabrysolutions.voyager.backend.dto.TourGuideSpecs;
import com.sabrysolutions.voyager.backend.models.*;
import com.sabrysolutions.voyager.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.util.*;

@Service
@Transactional
public class SearchService {


    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    private LanguageRepository  languageRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PlaceRepository PlaceRepository;




    public List<Profile> getTourGuides(SearchCriteria searchCriteria) {

        try {
            Language language = languageRepository.findByName(searchCriteria.getLanguages());
            Place place = PlaceRepository.findByName(searchCriteria.getPlace());

            List<Profile> profiles =  profileRepository.findBySpokenLanguagesAndWorkPlaces_place_id(language,place.getId());
            return profiles;
        } catch (NullPointerException e) {
            return Collections.emptyList();
        }


    }
    public List<Profile> getAvailableTourguide(SearchCriteria searchCriteria, List<Profile> tourGuides) {

        Profile userProfile = profileRepository.findByEmail(searchCriteria.getUserEmail());
        List<Profile> avaliableTourguides = new ArrayList<>();
        if (searchCriteria.getStart() == null)
            return tourGuides;


        for (Profile tourguide : tourGuides) {
            if (!userProfile.getId().equals(tourguide.getId()) && tourguide.isTourguide()) {

                if (bookingRepository.findBookingByTourGuideId(tourguide.getId()) == null) {
                    avaliableTourguides.add(tourguide);
                }else {
                    List<Booking> bookingList = null;
                    bookingList = bookingRepository.search(tourguide.getId(), searchCriteria.getStart());
                    if (bookingList.size() == 0)
                        avaliableTourguides.add(tourguide);
                }
                }
            }

        return avaliableTourguides;
    }
}
