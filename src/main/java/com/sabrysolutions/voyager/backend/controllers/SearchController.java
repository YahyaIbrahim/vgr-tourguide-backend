package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.dto.SearchCriteria;
import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.models.Profile;
import com.sabrysolutions.voyager.backend.services.SearchService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Search APIs", tags = {"Search Management"},
        description = "Search operations")
public class SearchController {

	@Autowired
	private SearchService searchService;



	@PostMapping(path = "/search", produces = "application/json")
	public SuccessList search(@RequestBody SearchCriteria searchCriteria) {
		List <Profile> tourGuides =searchService.getTourGuides(searchCriteria);
		List<Profile>  availableTourguides=searchService.getAvailableTourguide(searchCriteria,tourGuides) ;
		return new SuccessList(200,true,availableTourguides,null);
	}
}
