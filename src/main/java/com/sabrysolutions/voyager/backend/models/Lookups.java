package com.sabrysolutions.voyager.backend.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "lookups")
public class Lookups  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="group_name")
    private String groupName;

    @Column(name="english_name")
    private String englishName;
}
