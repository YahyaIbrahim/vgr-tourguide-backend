package com.sabrysolutions.voyager.backend.exceptions;

import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.models.ProfileImage;
import lombok.Data;
@Data
public class SuccessPhoto {

        private final int code;
        private final Boolean success;
        private final ProfileImage message;
        private final String error;


    }
