package com.sabrysolutions.voyager.backend.repositories;


import com.sabrysolutions.voyager.backend.models.GuideExtraService;
import com.sabrysolutions.voyager.backend.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideServiceRepo  extends JpaRepository<GuideExtraService,Long> {

     List<GuideExtraService> findByProfile(Profile profile);

}
