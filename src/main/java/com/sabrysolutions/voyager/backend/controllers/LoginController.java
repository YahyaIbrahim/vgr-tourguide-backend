package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.dto.LoginDTO;
import com.sabrysolutions.voyager.backend.exceptions.SuccessEntity;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.services.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Login APIs", tags = {"Login"},
        description = "Login operation")

public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "Login with Email , Password")
    @PostMapping(path = "/login", produces = "application/json")
    public SuccessEntity Login(@RequestBody LoginDTO profileDTO) {

        // String password = new BCryptPasswordEncoder().encode(profileDTO.getPassword());
        Profile profile = loginService.login(profileDTO.getEmail(),profileDTO.getPassword());
        if(profile != null)
            /*
            return profile;
        return null;
*/

            return new SuccessEntity(200,true, profile, null);
        return new SuccessEntity(400,false, null,"User Not Found");


    }

}