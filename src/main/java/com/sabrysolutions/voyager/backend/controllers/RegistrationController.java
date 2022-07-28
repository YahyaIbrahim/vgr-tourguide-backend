package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.dto.ProfileDTO;
import com.sabrysolutions.voyager.backend.dto.RegistrationDTO;
import com.sabrysolutions.voyager.backend.dto.ResetDTO;
import com.sabrysolutions.voyager.backend.exceptions.GenericResponse;
import com.sabrysolutions.voyager.backend.exceptions.SuccessEntity;
import com.sabrysolutions.voyager.backend.models.PasswordResetToken;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.models.VerificationToken;

import com.sabrysolutions.voyager.backend.repositories.PasswordTokenRepository;
import com.sabrysolutions.voyager.backend.repositories.VerificationTokenRepository;
import com.sabrysolutions.voyager.backend.services.ProfileService;
import com.sabrysolutions.voyager.backend.services.RegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.UUID;


@Api(value = "Registration APIs", tags = {"Registration Management"},
        description = "Registration operations")
@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    VerificationTokenRepository tokenRepository;

    @Autowired
    PasswordTokenRepository passwordTokenRepository;


    @Autowired
    ProfileService profileService;

    @PostMapping(path = "/signup")
    public SuccessEntity register(@RequestBody RegistrationDTO registrationDTO) {

        return registrationService.register(registrationDTO);
    }

    @ApiOperation(value = "registrationConfirm")
    @GetMapping(path = "/registrationConfirm")
    public String confirmRegistration
            (@RequestParam("token") String token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null) {
            String message = "Invalid token";
            return message;
        }
        Profile user = verificationToken.getProfile();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = "Verification link expired!";
            return messageValue;

        }
        if(user.isEnabled()){
            return "This User has active this account before";

        }

        user.setEnabled(true);
        profileService.save(user);

        return "Success SignUp";

    }
    @PostMapping(value = "/resetPassword", produces = "application/json")
    public GenericResponse resetPassword(@RequestBody ResetDTO resetDTO ) {
        try {
            Profile user = profileService.loadByEmail(resetDTO.getEmail());
            registrationService.RestPassword(resetDTO.getEmail());
            return new GenericResponse(200,"Please check your Email...");
        }catch (NullPointerException c){
            return new GenericResponse(400,null,"User Not Found");
        }
    }

    @ApiOperation(value = "resetPassword")
    @GetMapping(path = "/changePassword",produces = "application/json")
    public GenericResponse ChangePassword
            (@RequestParam("token") String token, @RequestBody ProfileDTO profileDTO) {
        PasswordResetToken passwordResetToken = passwordTokenRepository.findByToken(token);
        if (passwordResetToken == null) {
            return new GenericResponse(400,null,"invalidToken");
        }
        Calendar cal = Calendar.getInstance();
        if ((passwordResetToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
           return new GenericResponse(400,null,"Link expired");
        }
        Profile profile = passwordResetToken.getProfile();
        profile.setPassword(profileDTO.getPassword());
        return new GenericResponse(200,"resetPasswordSuccess");

    }


}


