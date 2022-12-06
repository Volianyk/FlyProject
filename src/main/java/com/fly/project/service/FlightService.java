package com.fly.project.service;

import com.fly.project.model.Flight;
import com.fly.project.repository.FlightScheduleRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class FlightService {
    private FlightScheduleRepository flightScheduleRepository;


    public List<Flight> searchFlight(String from, String to, LocalDate date) {
        return flightScheduleRepository.searchFlight(from, to, date);
    }
}
