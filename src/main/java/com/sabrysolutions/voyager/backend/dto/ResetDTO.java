package com.sabrysolutions.voyager.backend.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@ApiModel
@Getter
@Setter
public class ResetDTO {

    @Email(message = "Please enter a valid email address")
    private String email;

}
