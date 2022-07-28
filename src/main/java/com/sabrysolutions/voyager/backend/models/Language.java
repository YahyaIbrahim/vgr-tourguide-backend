package com.sabrysolutions.voyager.backend.models;



import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.LanguageSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "languages")
@JsonSerialize(using = LanguageSerializer.class)
@Proxy(lazy = false)
public class Language extends AuditModel implements Serializable {
    private String name;
    private String code;

}