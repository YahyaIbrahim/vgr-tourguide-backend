package com.sabrysolutions.voyager.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sabrysolutions.voyager.backend.dto.TripsDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "trips")
@Transactional
public class Trip extends AuditModel {

    @Column(name = "tour_guide_id")
    private Long guideId;


    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private Profile profile;


    @Column(name = "tourist_id")
    private long touristId;

    @DateTimeFormat(pattern="yyyy-mm-dd")
    @JsonFormat(pattern="yyyy-mm-dd")
    @Column(name = "trip_date")
    private Date tripDate;

    @Column(name = "trip_location")
    private String tripLocation;

    @Column(name = "request_type")
    private String requestType;

    @Column(name = "status")
    private String status;

    @Column(name = "cost")
    private Float cost;


}