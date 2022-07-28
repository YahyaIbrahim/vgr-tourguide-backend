package com.sabrysolutions.voyager.backend.dto;


import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel
@Getter
@Setter
public class ProfileDTO {

    @Pattern(regexp = "[\\w\\s]+")
    private String displayName;


    //    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
    @Email(message = "Please enter a valid email address")
    private String email;


    @Size(min = 8, max = 30, message = "Password should be from 8 to 30 characters")
    private String password;

    private String mobile;

    private String address;

    private String city;

    private String country;

    private String biography;

    private boolean tourGuide;

    private boolean tourist;

    private boolean enabled;

    private String nativeLanguage;

    private String spokenLanguages;

    private String guideServices;

    private String workPlaces;

    private Float costPerHour;

    private int totalReviews;

    private int totalTrips;

    private float guideServiceTariff;




}
