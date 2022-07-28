package com.sabrysolutions.voyager.backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.CitySerializer;
import com.sabrysolutions.voyager.backend.Serializer.WorkPlacesSerializer;
import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity(name = "work_places")
@JsonSerialize(using = WorkPlacesSerializer.class)
@Proxy(lazy = false)
public class WorkPlace extends AuditModel implements Serializable {


    @ManyToOne(targetEntity = Profile.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "profile_id", nullable = false)
    @JsonIgnore
    private Profile profile;


    @ManyToOne(targetEntity = Place.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

}