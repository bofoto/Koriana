package com.koriana.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koriana.domain.flightDTO;
import com.koriana.service.FlightService;

@RequestMapping
public class FlightController {

	private FlightService FlightService;
	
	public List<flightDTO> searchFlights(
										@RequestParam String departure,
										@RequestParam String arrival,
										@RequestParam String date,
										@RequestParam String seatCode
										){
		return FlightService.searchFlights(departure, arrival, date, seatCode);
	}
	
	
}
