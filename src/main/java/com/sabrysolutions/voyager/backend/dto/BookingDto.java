package com.sabrysolutions.voyager.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class BookingDto {

    @NotNull(message = "{required.profileId}")
    private Long tourGuideId;

    private Long touristId;



    private Long placeId;

  //  @NotNull
  @DateTimeFormat(pattern="yyyy-mm-dd")
  @JsonFormat(pattern="yyyy-mm-dd")
    private Date tripDate;

 //  @NotNull
 @DateTimeFormat(pattern="dd/MM/yyyy")
 @JsonFormat(pattern="dd/MM/yyyy")
    private Date reservationDate;


    private Long languageId;


    private int no_persons;
    private Float guidingCost;
    private Float totalCost;
    private List<BookingExtraServiceDto> extraService;


    @DateTimeFormat(pattern="yyyy-mm-dd")
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date tripEnd;

    private String event;



}


