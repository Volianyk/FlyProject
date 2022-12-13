package com.fly.project.model;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlightDetails {
    private String departure;
    private String arrival;
    private int numberOfSeats;
    private int minutes;

}
