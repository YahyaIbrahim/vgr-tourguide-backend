package com.sabrysolutions.voyager.backend.services;

import com.sabrysolutions.voyager.backend.models.Language;
import com.sabrysolutions.voyager.backend.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    public List<Language> loadLanguages() {
        List<Language> All_Languages = languageRepository.findAll();

        List<Language> Languages =new ArrayList<>();
        for (Language p :All_Languages){
            Languages.add(p);
        }
        return Languages;
    }

}
