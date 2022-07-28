package com.sabrysolutions.voyager.backend.exceptions;

import com.sabrysolutions.voyager.backend.models.Profile;
import lombok.Data;

@Data
public class SuccessEntity {
    private final int code;
    private final Boolean success;
    private final Profile message;
    private final String error;


}