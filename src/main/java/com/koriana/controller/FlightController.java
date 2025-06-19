package com.koriana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koriana.domain.flightDTO;
import com.koriana.service.FlightService;

@RestController
@RequestMapping(value = "/flights")
public class FlightController {

	@Autowired
	private FlightService FlightService;

	@GetMapping(value= "/search")
	public List<flightDTO> searchFlights(
										@RequestParam(value = "departure") String departure,
										@RequestParam(value = "arrival") String arrival,
										@RequestParam(value = "departureTime") String departureTime,
										@RequestParam(value = "seatCode") String seatCode
										){
		
		
		return FlightService.searchFlights(departure, arrival, departureTime, seatCode);
	}
	
}
