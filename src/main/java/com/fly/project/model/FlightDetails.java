package com.fly.project.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDetails {
    private String departure;
    private String arrival;
    private int numberOfSeats;
    private int duration;

    @Override
    public String toString() {
        return "From / To: " + departure + "-" + arrival + '\n' +
                "Seats available: " + numberOfSeats + '\n' +
                "Duration: " + duration + '\n';
    }

    public String toStringForTicket() {
        return "From / To: " + departure + "-" + arrival + '\n' +
                "Duration: " + duration + '\n';
    }
}
