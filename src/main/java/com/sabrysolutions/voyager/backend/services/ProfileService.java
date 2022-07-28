package com.sabrysolutions.voyager.backend.services;


import com.sabrysolutions.voyager.backend.exceptions.SuccessEntity;
import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.models.GuideExtraService;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.models.ProfileImage;
import com.sabrysolutions.voyager.backend.repositories.CityRepository;
import com.sabrysolutions.voyager.backend.repositories.GuideServiceRepo;
import com.sabrysolutions.voyager.backend.repositories.ProfileImageRepository;
import com.sabrysolutions.voyager.backend.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ProfileImageRepository profileImageRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    GuideServiceRepo guideServiceRepo;


    public List<Profile> loadProfiles() {
        List<Profile> All_profiles = profileRepository.findAll();

        List<Profile> profiles =new ArrayList<>();
        for (Profile p :All_profiles){
            if(p.isEnabled())
                profiles.add(p);

        }
        return profiles;
    }

    public Profile loadProfile(Long profileId) {
        // TODO loading profile data

        Profile user = profileRepository.findFirstById(profileId);
        if(user.isEnabled()){
            return user;
        }
        return null;
    }

    public Profile loadByEmail(String Email){
        return profileRepository.findByEmail(Email);
    }

    public SuccessList loadAllTourGuide() {
        List<Profile> All_profiles = profileRepository.findAll();

        List<Profile> profiles =new ArrayList<>();
        for (Profile p :All_profiles){
            if(p.isTourguide())
                profiles.add(p);
        }
        return new SuccessList(200,true, profiles,null);
    }


    public SuccessEntity updateProfile(Long profileId, Profile profileDTO) {
        // TODO updating profile information

        Profile updatedUser = profileRepository.findFirstById(profileId);

        if(profileDTO.getDisplayName() != null)
            updatedUser.setDisplayName(profileDTO.getDisplayName());

        if(profileDTO.getPassword() != null)
            updatedUser.setPassword(profileDTO.getPassword());

        if(profileDTO.getAddress() != null)
            updatedUser.setAddress(profileDTO.getAddress());

        if(profileDTO.getCity() != null)
            updatedUser.setCity(profileDTO.getCity());

        if(profileDTO.getCountry() != null)
            updatedUser.setCountry(profileDTO.getCountry());

        if(profileDTO.getBiography() != null)
            updatedUser.setBiography(profileDTO.getBiography());


        if(profileDTO.getTariff() != 0.0)
            updatedUser.setTariff(profileDTO.getTariff());

        if(profileDTO.getGuideServiceTariff() != 0.0)
            updatedUser.setGuideServiceTariff(profileDTO.getGuideServiceTariff());


        if(profileDTO.getNativeLanguage() != null)
            updatedUser.setNativeLanguage(profileDTO.getNativeLanguage());

        if(profileDTO.getMobile() != null)
            updatedUser.setMobile(profileDTO.getMobile());

        if(profileDTO.getCurrency() !=null)
            updatedUser.setCurrency(profileDTO.getCurrency());


        updatedUser.setUpdateTime(new Date());
        Profile profile = profileRepository.save(updatedUser);

        return new SuccessEntity(200,true, profile, null);

    }
    public SuccessEntity editByEmail(String email, Profile profileDTO) {

        Profile updatedUser = profileRepository.findByEmail(email);

        if(profileDTO.getDisplayName() != null)
            updatedUser.setDisplayName(profileDTO.getDisplayName());

        if(profileDTO.getPassword() != null)
            updatedUser.setPassword(profileDTO.getPassword());

        if(profileDTO.getAddress() != null)
            updatedUser.setAddress(profileDTO.getAddress());

        if(profileDTO.getCity() != null)
            updatedUser.setCity(profileDTO.getCity());

        if(profileDTO.getCountry() != null)
            updatedUser.setCountry(profileDTO.getCountry());

        if(profileDTO.getBiography() != null)
            updatedUser.setBiography(profileDTO.getBiography());

        if(profileDTO.getTariff() != 0.0)
            updatedUser.setTariff(profileDTO.getTariff());

        if(profileDTO.getGuideServiceTariff() != 0.0)
            updatedUser.setGuideServiceTariff(profileDTO.getGuideServiceTariff());

        if(profileDTO.getNativeLanguage() != null)
            updatedUser.setNativeLanguage(profileDTO.getNativeLanguage());

        if(profileDTO.getMobile() != null)
            updatedUser.setMobile(profileDTO.getMobile());

        if(profileDTO.getCurrency() !=null)
            updatedUser.setCurrency(profileDTO.getCurrency());

        updatedUser.setUpdateTime(new Date());
        Profile profile = profileRepository.save(updatedUser);

        return new SuccessEntity(200,true, profile, null);

    }
    public SuccessEntity turnToTourGuide(Long profileId) {
        Profile updatedUser = profileRepository.findFirstById(profileId);
        updatedUser.setTourist(false);
        updatedUser.setTourguide(true);

        updatedUser.setUpdateTime(new Date());
        Profile profile = profileRepository.save(updatedUser);

        return new SuccessEntity(200,true, profile, null);

    }

    public void deleteProfile(Long profileId) {
        // TODO disable profile, never delete anything from the database
        Profile user = profileRepository.findFirstById(profileId);
        user.setEnabled(false);
        profileRepository.save(user);

    }

    public void save(Profile profile){
        profileRepository.save(profile);
    }

    public void saveImage(ProfileImage profileImage){
        profileImageRepository.save(profileImage);
    }

    public ProfileImage loadProfileImage(Profile profile){

        return profileImageRepository.findTopByProfile_Id(profile.getId());



    }


    public SuccessList extra(Profile profile){
        try {
            List<GuideExtraService> guideExtraServices = guideServiceRepo.findByProfile(profile);
            return new SuccessList(200,true,guideExtraServices,null);
        }catch (NullPointerException e) {
            return new SuccessList(400,false,null,"No extra Service");

        }
    }
}
