package com.sabrysolutions.voyager.backend.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "authorities")
public class Authority /*implements GrantedAuthority */{

    @Id
    @GeneratedValue(
        strategy= GenerationType.AUTO,
        generator="native"
    )
    @GenericGenerator(
        name = "native",
        strategy = "native"
    )
    private Long id;
    private String authority;

    @ManyToOne
    private Profile profile;

}
