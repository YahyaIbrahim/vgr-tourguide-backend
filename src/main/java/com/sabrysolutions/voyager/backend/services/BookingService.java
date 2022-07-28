package com.sabrysolutions.voyager.backend.services;


import com.sabrysolutions.voyager.backend.dto.BookingDto;
import com.sabrysolutions.voyager.backend.dto.BookingExtraServiceDto;
import com.sabrysolutions.voyager.backend.dto.TripsDto;
import com.sabrysolutions.voyager.backend.dtos.BookingRequestDTO;
import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.exceptions.SuccessString;
import com.sabrysolutions.voyager.backend.exceptions.SuccessTrip;
import com.sabrysolutions.voyager.backend.models.*;
import com.sabrysolutions.voyager.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {


    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    BookingExtraServiceRepository bookingExtraServiceRepo;

    @Autowired
    ExtraServiceRepository extraServiceRepo;

    @Autowired
    GuideServiceRepo guideServiceRepo;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    TripRepository tripRepository;


    /**
     * save booking trip
     *
     * @param
     */

    public SuccessString addBooking(BookingRequestDTO requestDTO) {
        try {
            Profile tourist = profileRepository.findByEmail(requestDTO.getTouristEmail());
            Profile Tourguide = profileRepository.findByEmail(requestDTO.getGuideEmail());
            Place place = placeRepository.findByName(requestDTO.getPlaceName());
            List<Booking> booking =  bookingRepository.search(Tourguide.getId(),requestDTO.getStartDate());
            Language language = null;

            if(booking.size() > 0 )
                return new SuccessString(400, null,  "This TourGuide is in a tour now");

            if (requestDTO.getLanguageName() != null)
                language = languageRepository.findByName(requestDTO.getLanguageName());
            if (requestDTO.getLanguageName() == null)
                return new SuccessString(400, null,  "Please enter a Language");
            if (requestDTO.getPlaceName() == null)
                return new SuccessString(400, null,  "Please enter a Place");
            if (requestDTO.getNo_persons() == 0 || String.valueOf(requestDTO.getNo_persons()) == null)
                return new SuccessString(400, null,  "Please enter No of Person");
            if (requestDTO.getStartDate() == null)
                return new SuccessString(400, null,  "Please enter Start Date");
            if (requestDTO.getEndDate() == null)
                return new SuccessString(400, null,  "Please enter End Date");
            Calendar cal = Calendar.getInstance();
            if (requestDTO.getStartDate().getTime() == cal.getTime().getTime())
                return new SuccessString(400, null,  "Sorry you can't book this tourGuide in the same day, Please try anther day  ");



            Booking bookingDto = new Booking();
            bookingDto.setTouristId(tourist.getId());
            bookingDto.setTourGuideId(Tourguide.getId());
            bookingDto.setPlaceId(place.getId());
            bookingDto.setLanguageId(language.getId());
            bookingDto.setTripDate(requestDTO.getStartDate());
            bookingDto.setReservationDate(new Date());
            bookingDto.setNo_persons(requestDTO.getNo_persons());
            bookingDto.setTripEnd(requestDTO.getEndDate());

            float guidingCost = Tourguide.getTariff();
            if (bookingDto.getNo_persons() != 0) {
                bookingDto.setGuidingCost(guidingCost);
                guidingCost = guidingCost * bookingDto.getNo_persons();
            }

            Booking bookDone = bookingRepository.save(bookingDto);



            Float totalCost = guidingCost;
            bookDone.setTotalCost(totalCost);


            bookingRepository.save(bookDone);


            bookTrip(bookDone.getId());
            return new SuccessString(200, "Booking Done", null);


        }catch (Exception ex){
                return new SuccessString(400, null,  "Something wrong with booking, please try again");
        }
    }


    public List<Booking> loadBookings(String email) {
        Profile profile = profileRepository.findByEmail(email);
        List<Booking> All_bookings = null;
        if (profile.isTourguide())
            All_bookings  = bookingRepository.findBookingByTourGuideId(profile.getId());
        else{
            All_bookings =bookingRepository.findBookingByTouristId(profile.getId());
        }

        List<Booking> bookings =new ArrayList<>();
        for (Booking p :All_bookings)
            bookings.add(p);

        return bookings;
    }


    public SuccessTrip bookTrip(Long bookingId){
        try{
        Booking booking=bookingRepository.findFirstById(bookingId);

        Trip tripsDto =new Trip();
        tripsDto.setCost(booking.getTotalCost());
        tripsDto.setTripDate(booking.getTripDate());
        tripsDto.setGuideId(booking.getTourGuideId());
        tripsDto.setProfile(profileRepository.findFirstById(booking.getTouristId()));
        tripsDto.setTouristId(profileRepository.findFirstById(booking.getTouristId()).getId());
        tripsDto.setTripLocation(placeRepository.findById(booking.getPlaceId()).get().getName());
        tripsDto.setStatus("Coming");

        Trip trip = tripRepository.save(tripsDto);


            return new SuccessTrip(200, trip,  null);

        }catch (NullPointerException e){
            return new SuccessTrip(400, null,  "TripBadRequestException");
        }



    }

}