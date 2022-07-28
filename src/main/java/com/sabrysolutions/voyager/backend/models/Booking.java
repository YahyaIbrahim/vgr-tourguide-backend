package com.sabrysolutions.voyager.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "bookings")
@Proxy(lazy = false)
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(name = "tour_guide_id")
    private Long tourGuideId;

    @Column(name = "tourist_id")
    private Long touristId;



   @Column(name = "place_id ")
    private Long placeId;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
   @Column(name="trip_date")
   @Temporal(TemporalType.DATE)
   private Date tripDate;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name ="reservation_date")
    private Date reservationDate;

   @Column(name = "language_id")
   private Long languageId;

   @Column(name = "no_persons")
   private int no_persons;

   @Column(name = "guiding_cost")
   private Float guidingCost;

   @Column(name = "total_cost")
   private Float totalCost;


   @OneToMany(mappedBy = "booking",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   private Set<BookingExtraService> extraServices;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="trip_end")
    private Date tripEnd;

    @Column(name = "event")
    private String event;


}
