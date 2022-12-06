package com.fly.project.repository;

import com.fly.project.model.Flight;
import com.fly.project.model.FlightDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightScheduleRepository {
    private List<Flight> flightList;

    public FlightScheduleRepository() {
       flightList=new ArrayList<>();
       Flight flight=new Flight();
       flight.setFlightDetails(FlightDetails.builder().departure("Lviv").arrival("Kyiv").minutes(60).build());
       flight.setDepartureTime(LocalDateTime.MAX);
       flightList.add(flight);
    }

    private boolean isSameDay(LocalDateTime localDateTime, LocalDate localDate) {
        return localDateTime.getYear() == localDate.getYear() && localDateTime.getDayOfYear() == localDate.getDayOfYear();
    }

    public List<Flight> searchFlight(String from, String to, LocalDate date) {
        return flightList.stream().filter(flight -> isSameDay(flight.getDepartureTime(), date))
                .filter(flight -> flight.getFlightDetails().getDeparture().equals(from)
                        && flight.getFlightDetails().getArrival().equals(to)).collect(Collectors.toList());
    }
}
