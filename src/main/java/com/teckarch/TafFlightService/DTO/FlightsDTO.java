package com.teckarch.TafFlightService.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FlightsDTO {

    private Long flightId;
    private String flightNumber;
    private String departure;
    private String arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    private Integer availableSeats;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
