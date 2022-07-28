package com.sabrysolutions.voyager.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.ExtraServiceSerializer;
import com.sabrysolutions.voyager.backend.Serializer.GuideExtraServiceSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "extra_services")
@Getter
@Setter
@JsonSerialize(using = ExtraServiceSerializer.class)
@Proxy(lazy = false)
public class ExtraService extends AuditModel {


    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "serviceId")
    private Collection<BookingExtraService> bookingExtraservicesCollection;

    @JsonIgnore
    @OneToMany(mappedBy = "extraService")
    private Collection<GuideExtraService> guidingServices;

}
