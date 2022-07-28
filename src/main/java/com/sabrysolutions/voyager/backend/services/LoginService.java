package com.sabrysolutions.voyager.backend.services;

import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    ProfileService profileService;

    public Profile login(String email, String password){
       Profile profile =  profileRepository.findByEmailAndPassword(email, password);

        if (profile != null){
          return   profileService.loadProfile(profile.getId());
        }
      return null;
    }

}
