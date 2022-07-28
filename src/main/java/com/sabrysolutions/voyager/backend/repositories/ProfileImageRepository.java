package com.sabrysolutions.voyager.backend.repositories;

import com.sabrysolutions.voyager.backend.models.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {


    ProfileImage findTopByProfile_Id(Long profile_id);
}
