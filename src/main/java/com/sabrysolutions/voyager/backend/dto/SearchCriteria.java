package com.sabrysolutions.voyager.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class SearchCriteria {
    private String place;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date start;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //@JsonFormat(pattern = "yyyy-MM-dd")
    //private Date end;
    private String languages;

    private String userEmail;

}
