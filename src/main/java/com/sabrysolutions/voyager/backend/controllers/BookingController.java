package com.sabrysolutions.voyager.backend.controllers;


import com.sabrysolutions.voyager.backend.dtos.BookingRequestDTO;
import com.sabrysolutions.voyager.backend.exceptions.SuccessList;
import com.sabrysolutions.voyager.backend.exceptions.SuccessString;
import com.sabrysolutions.voyager.backend.models.Booking;
import com.sabrysolutions.voyager.backend.services.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@Api(value = "Booking APIs", tags = {"Booking Management"},
		description = "Booking operations")
public class BookingController {

	@Autowired
	private BookingService bookingService;


	@ApiOperation(value = "Do a booking for a tour guide")
	@PostMapping(path = "/booking",produces = "application/json")
	public SuccessString bookTrip(@RequestBody BookingRequestDTO requestDTO) {
		return bookingService.addBooking(requestDTO);
	}


	@ApiOperation(value = "Load all booking for a specific tour guide")
	@GetMapping(path = "/{email}/booking",produces = "application/json")
	public List<Booking> findBookingByProfileemail(@PathVariable String email) {
		return bookingService.loadBookings(email);
	}

}
