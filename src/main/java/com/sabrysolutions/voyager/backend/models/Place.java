package com.sabrysolutions.voyager.backend.models;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.PlaceSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "places")
@Embeddable
@JsonSerialize(using = PlaceSerializer.class)
@Proxy(lazy = false)

public class Place extends AuditModel implements Serializable {
    private String name;

    private String image;

    @ManyToOne(targetEntity = City.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "city_id", nullable = false)
    private City city;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "place", cascade = CascadeType.ALL)
    private Set<Activity> activities ;


}