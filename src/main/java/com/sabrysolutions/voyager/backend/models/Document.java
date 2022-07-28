package com.sabrysolutions.voyager.backend.models;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity(name = "documents")
public class Document extends AuditModel {


    @ManyToOne(targetEntity = Profile.class, optional = false, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile tourGuide;

    @Column(name = "link_urk")
    private String urlLink;

    private String type;

}