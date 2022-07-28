package com.sabrysolutions.voyager.backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "messages")
public class Messages {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="messge_title")
    private String messageTitle;

    @Column(name="message_body")
    private String messageBody;

    @Column(name="trip_cost")
    private Float tripCost;

    @Column(name = "sent_time")
    private Date sentTime;

    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @ManyToOne
    private Profile profile;

}
