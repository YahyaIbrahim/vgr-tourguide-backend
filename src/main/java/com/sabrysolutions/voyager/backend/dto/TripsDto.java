package com.sabrysolutions.voyager.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel
@Getter
@Setter
public class TripsDto {



  private String tripLocation;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  @JsonFormat(pattern="yyyy-MM-dd")
  private Date tripDate;

  private String touristName;
  private String guideName;
  private Float cost;
  private String status;


}
