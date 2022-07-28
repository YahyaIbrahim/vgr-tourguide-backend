package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.services.LanguageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Language", tags = {"Language Management"},
        description = "Language operations")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @ApiOperation(value = "Loads all languages")
    @GetMapping(path = "/languages",produces = "application/json")
    public SuccessList loadLanguages(){
        return new SuccessList(200,true, languageService.loadLanguages(),null);
    }


}
