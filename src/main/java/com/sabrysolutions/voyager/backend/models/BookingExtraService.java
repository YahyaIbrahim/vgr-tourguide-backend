package com.sabrysolutions.voyager.backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.BookingExtraServiceSerializer;
import com.sabrysolutions.voyager.backend.Serializer.CitySerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "booking_extra_services")
@JsonSerialize(using = BookingExtraServiceSerializer.class)
@Proxy(lazy = false)
public class BookingExtraService implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    @ManyToOne
    private ExtraService serviceId;

    @Column(name = "cost")
    private Float serviceCost;

    @JsonIgnore
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Booking booking;
}
