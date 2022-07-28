package com.sabrysolutions.voyager.backend.models;




import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.CitySerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cities")
@JsonSerialize(using = CitySerializer.class)
@Proxy(lazy = false)
@Transactional
public class City extends AuditModel implements Serializable {
    @Column(name="name")
    private String name;

    @Column(name="image")
    private String image;


    @ManyToOne(targetEntity = Country.class, optional = false,fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Place> places ;

}