package com.teckarch.TafFlightService.Service;

import com.teckarch.TafFlightService.DTO.FlightsDTO;
import com.teckarch.TafFlightService.Service.Interfaces.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightsServiceImpl implements FlightsService {


    private final RestTemplate restTemplate;
    private final String datastoreServiceUrl;

    public FlightsServiceImpl(RestTemplate restTemplate, @Value("${datastore.service.url}") String datastoreServiceUrl) {
        this.restTemplate = restTemplate;
        this.datastoreServiceUrl = datastoreServiceUrl;
    }

    @Override
    public FlightsDTO addFlight(FlightsDTO flights) {
        return restTemplate.postForObject(datastoreServiceUrl, flights, FlightsDTO.class);
    }

    @Override
    public List<FlightsDTO> getAllFlights() {
        FlightsDTO[] flightsArray = restTemplate.getForObject(datastoreServiceUrl, FlightsDTO[].class);
        return Arrays.asList(flightsArray);
    }

    @Override
    public FlightsDTO getFlightById(Long flightId) {
        return restTemplate.getForObject(datastoreServiceUrl + "/" + flightId, FlightsDTO.class);
    }

    @Override
    public FlightsDTO updateFlight(Long flights, FlightsDTO updatedFlights) {
        restTemplate.put(datastoreServiceUrl + "/" + flights, updatedFlights);
        return updatedFlights;
    }

    @Override
    public void deleteFlight(Long flightId) {
        restTemplate.delete(datastoreServiceUrl + "/" + flightId);
    }
}
