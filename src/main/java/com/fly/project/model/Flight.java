package com.fly.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private int number;
    private FlightDetails flightDetails;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureTime;

    @Override
    public String toString() {
        return "Flight number: " + number + '\n' +
                flightDetails +
                "DepartureTime: " + departureTime + '\n';
    }

    public String toStringForTicket() {
        return "Flight number: " + number + '\n' +
                flightDetails.toStringForTicket() +
                "DepartureTime: " + departureTime + '\n';
    }
}
