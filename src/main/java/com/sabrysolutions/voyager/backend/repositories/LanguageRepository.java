package com.sabrysolutions.voyager.backend.repositories;

import com.sabrysolutions.voyager.backend.dto.ProfileDTO;
import com.sabrysolutions.voyager.backend.models.Language;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.models.SpokenLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {


    Language findByName(String languageName);
}
