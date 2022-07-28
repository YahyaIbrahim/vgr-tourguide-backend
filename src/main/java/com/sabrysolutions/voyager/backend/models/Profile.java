package com.sabrysolutions.voyager.backend.models;


import com.sabrysolutions.voyager.backend.dto.RegistrationDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "profiles")
@Proxy(lazy = false)
@Transactional
public class Profile extends AuditModel  {

    @Column(name = "enabled")
    private boolean enabled;

    @NotNull
    @Column(name = "display_name")
    @Pattern(regexp = "[\\w\\s]+")
    private String displayName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "profile")
    private Set<Authority> authorities = new HashSet<>();

    @NotNull
    @Column(name = "email_address")
//    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
    @Email(message = "(Error: Please enter a valid email address)")
    private String email;


    @NotNull
    //@Size(min = 8, max = 60, message = "(Error: Password should be from 12 to 30 characters)")
    @Column(name = "password")
    private String password;



    //@Size(min = 8, max = 60, message = "(Error: Password should be from 12 to 30 characters)")
    @Column(name = "mobile")
    private String mobile;



    //@Size(min = 8, max = 60, message = "(Error: Password should be from 12 to 30 characters)")
    @Column(name = "biography")
    private String biography;

    @Column(name = "native_language")
    private String nativeLanguage;

    @Column(name="currency")
    private String currency;

    @Column(name="locale")
    private String Locale;


    //@Size(min = 8, max = 60, message = "(Error: Password should be from 12 to 30 characters)")
    @Column(name = "city")
    private String city;



    //@Size(min = 8, max = 60, message = "(Error: Password should be from 12 to 30 characters)")
    @Column(name = "country")
    private String country;


    //@Size(min = 8, max = 60, message = "(Error: Password should be from 12 to 30 characters)")
    @Column(name = "address")
    private String address;


    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Messages> messages;

    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<PaymentInfo> paymentMethods;


    @ManyToMany(fetch=FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "spoken_languages",
            joinColumns = @JoinColumn(name = "profile_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName="id")
    )
    private Set<Language> spokenLanguages;


    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "work_places",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private Set<WorkPlace> workPlaces;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profile",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<TariffSchema> tariffSchemas;
    private float tariff;


    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<GuideExtraService> guideExtraServices;

    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Image> images;

    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Video> videos;

    @Column(name="is_tour_guide")
    private boolean isTourguide;

    @Column (name="is_tourist")
    private boolean isTourist;


    @Column (name="guideServiceTariff")
    private float guideServiceTariff;

    @Column(name = "total_reviews")
    private Long totalReviews;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_image_id", referencedColumnName = "id")
    private ProfileImage profileImage;

    public Profile(){
    }

    public Profile(RegistrationDTO registrationDTO) {
        this.displayName = registrationDTO.getDisplayName();
        this.email = registrationDTO.getEmail();
        this.password = registrationDTO.getPassword();
        this.enabled=false;
        this.isTourguide =false;
        this.isTourist =true;
    }
}
