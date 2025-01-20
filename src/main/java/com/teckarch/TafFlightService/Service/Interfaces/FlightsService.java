package com.teckarch.TafFlightService.Service.Interfaces;

import com.teckarch.TafFlightService.DTO.FlightsDTO;

import java.util.List;

public interface FlightsService {
    FlightsDTO addFlight(FlightsDTO flights);
    List<FlightsDTO> getAllFlights();
    FlightsDTO getFlightById(Long flightId);
    FlightsDTO updateFlight(Long flights, FlightsDTO updatedFlights);
    void deleteFlight(Long flightId);
}
