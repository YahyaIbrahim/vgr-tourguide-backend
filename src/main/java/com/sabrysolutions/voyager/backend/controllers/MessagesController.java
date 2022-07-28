package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.models.Messages;
import com.sabrysolutions.voyager.backend.services.BookingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Messages APIs", tags = {"Messages Management"},
		description = "Messages operations")
@RequestMapping("messages")
public class MessagesController {

	@Autowired
	BookingService bookingService;

	@GetMapping("{/profileId}")
	public List<Messages> loadAllMessagesByProfileId(){
		return null;
	}

}
