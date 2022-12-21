package com.fly.project.application;

import com.fly.project.model.Flight;
import com.fly.project.repository.FlightScheduleRepository;
import com.fly.project.service.FlightService;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws IOException, ParseException {
        FlightScheduleRepository flightScheduleRepository = new FlightScheduleRepository();
        FlightService flightService = new FlightService(flightScheduleRepository);

        List<Flight> resultSet = flightService.searchFlight("Lytsk", "Lviv", LocalDate.of(2022, 12,31));
        for (Flight flight : resultSet) {
            System.out.println(flight);
        }
    }
}
