package com.koriana.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.koriana.domain.flightDTO;

@Mapper
public interface FlightMapper {
	public List<flightDTO> searchFlights(@Param("departure") String departure,
										 @Param("arrival")String arrvial,
										 @Param("date")String date,
										 @Param("seatCode") String seatCode);
}
