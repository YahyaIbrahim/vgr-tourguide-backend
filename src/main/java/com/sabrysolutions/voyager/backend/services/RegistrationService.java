package com.sabrysolutions.voyager.backend.services;

import com.sabrysolutions.voyager.backend.dto.RegistrationDTO;
import com.sabrysolutions.voyager.backend.exceptions.SuccessEntity;
import com.sabrysolutions.voyager.backend.models.PasswordResetToken;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.models.VerificationToken;
import com.sabrysolutions.voyager.backend.repositories.PasswordTokenRepository;
import com.sabrysolutions.voyager.backend.repositories.ProfileRepository;
import com.sabrysolutions.voyager.backend.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    VerificationTokenRepository verificationToken;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    PasswordTokenRepository passwordTokenRepository;




    private static final String SUCCESSFUL_REGISTRATION = "Registration completed successfully!";
    private static final String FAILED_REGISTRATION = "Email is already registered please use another one!";


    public SuccessEntity register(RegistrationDTO registrationDTO) {

        // COMPLETED check if email exist
        boolean exists = emailExist(registrationDTO.getEmail());


        // TODO return verfication code and should send an email
        if (!exists) {

            Profile profile = new Profile(registrationDTO);

            profile = profileRepository.save(profile);

            confirmRegistration(profile.getId());
            return new SuccessEntity(200,true, profile, null);

        }
        return new SuccessEntity(400,false, null,FAILED_REGISTRATION);
    }

    private boolean emailExist(String email) {
        Profile profile = profileRepository.findByEmail(email);

        if (profile != null) {
            return true;
        }
        return false;
    }

    private void confirmRegistration(Long userid) {
        Profile user = profileRepository.findFirstById(userid);
        String token = UUID.randomUUID().toString();
        VerificationToken myToken = new VerificationToken(token, user);
        verificationToken.save(myToken);

        String path = httpServletRequest.getServerName();

        String recipientAddress = user.getEmail();
        String subject = "Voyager - Tour Guide Registration Confirmation";
        String confirmationUrl = "/registrationConfirm?token=" + token;
        String message = "Thank you for creating account with Voyager Ventures, " + user.getDisplayName() +
                "\n\nWelcome to Voyager!\n" +
                "Please activate your account!\n\n" +
                "This link will be available for 24 hours only ";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + path + confirmationUrl);
        mailSender.send(email);
    }


    public void RestPassword(String Email) {
        Profile user = profileRepository.findByEmail(Email);
        String token = UUID.randomUUID().toString();
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(myToken);

        String path = httpServletRequest.getServerName();

        String recipientAddress = user.getEmail();
        String subject = "Voyager - Password assistance";
        String confirmationUrl = "/resetPassword?token=" + token;
        String message = "Hello" + user.getDisplayName() +
                "\n It looks like you need a little assistance with your password. We're on it!\n" +
                "\n" +
                "To reset your password, click the link  \n \n" +
                "This link will be available for 24 hours only ";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + path + confirmationUrl);
        mailSender.send(email);
    }

}
