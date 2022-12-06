package com.fly.project.application;

import com.fly.project.model.Flight;
import com.fly.project.repository.FlightScheduleRepository;
import com.fly.project.service.FlightService;

import java.time.LocalDateTime;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        FlightScheduleRepository flightScheduleRepository = new FlightScheduleRepository();
        FlightService flightService = new FlightService(flightScheduleRepository);

        List<Flight> resultSet = flightService.searchFlight("Lviv", "Kyiv", LocalDateTime.MAX.toLocalDate());
        for (Flight flight : resultSet) {
            System.out.println(flight);
        }
    }
}
