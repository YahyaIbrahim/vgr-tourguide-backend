package com.sabrysolutions.voyager.backend.repositories;


import com.sabrysolutions.voyager.backend.models.City;
import com.sabrysolutions.voyager.backend.models.Language;
import com.sabrysolutions.voyager.backend.models.Place;
import com.sabrysolutions.voyager.backend.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
    public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findFirstById(Long tourguideId);

    Profile findByEmailAndPassword(String email,String password);

    Profile findByEmail(String email);



    List<Profile> findBySpokenLanguagesAndWorkPlaces_place_id(Language spokenLanguages, long place);





}
