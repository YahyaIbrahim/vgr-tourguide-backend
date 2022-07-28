package com.sabrysolutions.voyager.backend.exceptions;

import com.sabrysolutions.voyager.backend.models.Trip;
import lombok.Data;

@Data
public class SuccessTrip {
    private final int code;
    private final Trip message;
    private final String error;
}
