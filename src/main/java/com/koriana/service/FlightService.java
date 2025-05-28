package com.koriana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koriana.domain.flightDTO;
import com.koriana.mapper.FlightMapper;

@Service
public class FlightService {
	
	@Autowired
	private FlightMapper FlightMapper;
	
	public List<flightDTO> searchFlights(String departure, String arrival, String date, String seatCode){
		return FlightMapper.searchFlights(departure, arrival, date, seatCode);
	}
}
