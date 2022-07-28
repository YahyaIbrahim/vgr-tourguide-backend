package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.exceptions.SuccessEntity;
import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.services.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value = "Profile APIs", tags = {"Profile Management"},
        description = "Profile's CRUD operations")
@RequestMapping(path = "/profiles",produces = "application/json")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @ApiOperation(value = "Loads all Profiles who are enabled")
    @GetMapping(produces = "application/json")
    public List<Profile> loadProfiles(){
        return profileService.loadProfiles();
    }

    @ApiOperation(value = "Loads profileId by profileId")
    @GetMapping(path = "/{profileId}",produces = "application/json")
    public Profile loadProfile(@PathVariable Long profileId) {
        return profileService.loadProfile(profileId);
    }


    @ApiOperation(value = "Updates profile.",produces = "application/json")
    @PostMapping(path = "/edit/{email}")
    public SuccessEntity editByEmail(@PathVariable("email") String email, @RequestBody Profile profile) {
        return profileService.editByEmail(email, profile);
    }


    @ApiOperation(value = "Deletes profile.")
    @DeleteMapping(path = "/{email}/delete",produces = "application/json")
    public void deleteProfile(@PathVariable("email") String email) {
        Profile profile = profileService.loadByEmail(email);
        profileService.deleteProfile(profile.getId());
    }

    @ApiOperation(value = "Turn profile to TourGuide.")
    @PutMapping(path = "/{email}/tourguide",produces = "application/json")
    public void ToTourGuide(@PathVariable("email") String email) {
        Profile profile = profileService.loadByEmail(email);
        profileService.turnToTourGuide(profile.getId());
    }



    @ApiOperation(value = "Loads profileId by tourguides")
    @GetMapping(path = "/tourguides",produces = "application/json")
    public SuccessList loadAllTourGuide() {
        return profileService.loadAllTourGuide();
    }


    @ApiOperation(value = "Loads Extra service ")
    @GetMapping(path = "/{email}/extra",produces = "application/json")
    public SuccessList Extra(@PathVariable("email") String email) {
        Profile profile = profileService.loadByEmail(email);
        return profileService.extra(profile);
    }






}
