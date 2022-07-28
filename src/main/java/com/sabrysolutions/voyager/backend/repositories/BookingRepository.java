package com.sabrysolutions.voyager.backend.repositories;


import com.sabrysolutions.voyager.backend.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface    BookingRepository extends JpaRepository<Booking,Long> {

    Booking findFirstById(Long id);

  //  public List<Booking> findByTripStartGreaterThanEqualAndTripEndLessThanEqual(Date tripStart, Date tripEnd);


    public List<Booking> findByTourGuideIdAndTripDate(Long tourguideId, Date start);

    public List<Booking> findByTourGuideIdAndTripDateBetweenAndTripDateIsLessThanEqualAndTripEndIsGreaterThan(Long tourguideId, Date start,Date Start,Date tripStart,Date tripEnd);

    List<Booking> findBookingByTourGuideId(Long ProfileId);

    List<Booking> findBookingByTouristId(Long ProfileId);

    Booking findBookingByTourGuideIdAndTouristIdAndTripDate(Long Id, Long id2 , Date date);


    @Query("select booking from Booking booking where booking.tourGuideId = :ID and booking.tripDate <= :start and booking.tripEnd >= :start")
    List<Booking> search(@Param("ID") Long ID, @Param("start") Date start);

}
