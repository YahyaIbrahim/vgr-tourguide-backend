package com.sabrysolutions.voyager.backend.models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.TariffSchemaSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity(name = "tariff_schemas")
@JsonSerialize(using = TariffSchemaSerializer.class)
@Proxy(lazy = false)
public class TariffSchema extends AuditModel implements Serializable {


    @ManyToOne(targetEntity = Profile.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne(targetEntity = Tariff.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "tariff_id", nullable = false)
    private Tariff tariff;

    private float cost;

}