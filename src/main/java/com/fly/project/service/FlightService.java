package com.fly.project.service;

import com.fly.project.model.Flight;
import com.fly.project.repository.FlightScheduleRepository;
import lombok.AllArgsConstructor;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class FlightService {
    private FlightScheduleRepository flightScheduleRepository;


    public List<Flight> searchFlight(String from, String to, LocalDate date) throws IOException, ParseException {
        return flightScheduleRepository.searchFlight(from, to, date);
    }
}
