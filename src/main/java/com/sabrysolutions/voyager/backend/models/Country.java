package com.sabrysolutions.voyager.backend.models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.CountrySerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;

import java.util.Set;

@Getter
@Setter
@Entity(name = "countries")
@JsonSerialize(using = CountrySerializer.class)
@Proxy(lazy = false)
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Null
    @Column(name="country_code")
    private String countryCode;

    @Column(name="country_name")
    private String countryName;


    @Null
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> cities;

    private String image;
}