package com.sabrysolutions.voyager.backend.models;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;



@Getter
@Setter
@Entity(name = "spoken_languages")
public class SpokenLanguage extends AuditModel {


    @ManyToOne(targetEntity = Language.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;


    @ManyToOne(targetEntity = Profile.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;


}