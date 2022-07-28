package com.sabrysolutions.voyager.backend.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "activities")
@Transactional
public class Activity extends AuditModel {

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "location")
    private String location;


    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="date")
    private Date date;

    @Column(name="image")
    private String image;

    @OneToMany(mappedBy = "activity", fetch = FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<ActivityImage> activity_image;

    @JsonIgnore
    @ManyToOne(targetEntity = Place.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;


}
