package com.sabrysolutions.voyager.backend.dto;

import lombok.Data;

@Data
public class BookingExtraServiceDto {

    private Long extraServiceId;
    private Long bookingId;
    private int serviceCost;

    
}
