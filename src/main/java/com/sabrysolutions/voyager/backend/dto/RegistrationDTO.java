package com.sabrysolutions.voyager.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationDTO {

    String displayName;
    String password;
    String email;

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
     //   this.password = new BCryptPasswordEncoder().encode(password);
        this.password = password;
    }
}
