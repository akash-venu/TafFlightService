package com.teckarch.TafFlightService.Controller;

import com.teckarch.TafFlightService.DTO.FlightsDTO;
import com.teckarch.TafFlightService.Service.FlightsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightsServiceImpl flightsService;

    @GetMapping
    public ResponseEntity<List<FlightsDTO>> getAllFlights() {
        return ResponseEntity.ok(flightsService.getAllFlights());
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightsDTO> getFlightById(@PathVariable Long flightId) {
        FlightsDTO flight = flightsService.getFlightById(flightId);
        return flight != null ? ResponseEntity.ok(flight) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FlightsDTO> addFlight(@RequestBody FlightsDTO flight) {
        FlightsDTO addedFlight = flightsService.addFlight(flight);
        return ResponseEntity.ok(addedFlight);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<FlightsDTO> updateFlight(@PathVariable Long flightId ,@RequestBody FlightsDTO updatedFlight) {
        FlightsDTO updated = flightsService.updateFlight(flightId, updatedFlight);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long flightId) {
        flightsService.deleteFlight(flightId);
        String message = "Flight with id " + flightId + " has been deleted.";
        return ResponseEntity.ok(message);

    }


}
