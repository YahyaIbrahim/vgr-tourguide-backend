package com.sabrysolutions.voyager.backend.models;



import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.TariffSchemaSerializer;
import com.sabrysolutions.voyager.backend.Serializer.TariffSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "tariffs")
@JsonSerialize(using = TariffSerializer.class)
@Proxy(lazy = false)
public class Tariff extends AuditModel implements Serializable {
    private String name;
}