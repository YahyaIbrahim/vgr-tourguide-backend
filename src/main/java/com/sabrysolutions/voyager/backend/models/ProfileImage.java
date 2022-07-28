package com.sabrysolutions.voyager.backend.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sabrysolutions.voyager.backend.Serializer.LanguageSerializer;
import com.sabrysolutions.voyager.backend.Serializer.ProfileImageSerializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "profile_image")
@JsonSerialize(using = ProfileImageSerializer.class)
@Proxy(lazy = false)
public class ProfileImage extends AuditModel implements Serializable {

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Profile profile;

    private String path;

}