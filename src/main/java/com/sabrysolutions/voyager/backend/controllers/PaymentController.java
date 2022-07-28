package com.sabrysolutions.voyager.backend.controllers;

import com.sabrysolutions.voyager.backend.dto.BookingDto;
import com.sabrysolutions.voyager.backend.models.Booking;
import com.sabrysolutions.voyager.backend.services.BookingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Booking APIs", tags = {"Booking Management"},
		description = "Booking operations")
@RequestMapping("payments")
public class PaymentController {

}
