package com.sabrysolutions.voyager.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "reviews")
public class Review extends AuditModel{


    @Column(name = "tourguide_id")
    private Long tourguideId;

    @Column(name = "tourist_id")
    private Long touristId;

    @Column(name = "trip_id")
    private Long trip_id;

    @Column(name = "review_body")
    private String reviewBody;
}