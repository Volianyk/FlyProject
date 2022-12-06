package com.fly.project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Flight {
    private FlightDetails flightDetails;
    private LocalDateTime departureTime;

}
