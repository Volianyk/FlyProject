package com.fly.project.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class FlightDetails {
    private String departure;
    private String arrival;
    private int numberOfSeats;
    private int minutes;

}
