package com.fly.project.repository;

import com.fly.project.model.Flight;
import com.fly.project.repository.dataSource.FlightListDataSource;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightScheduleRepository {

    private boolean isSameDay(LocalDateTime localDateTime, LocalDate localDate) {
        return localDateTime.getYear() == localDate.getYear() && localDateTime.getDayOfYear() == localDate.getDayOfYear();
    }
    public List<Flight> searchFlight(String from, String to, LocalDate date) throws IOException {

        return FlightListDataSource.getFlightList().stream().filter(flight -> isSameDay(flight.getDepartureTime(), date))
                .filter(flight -> flight.getFlightDetails().getDeparture().equals(from)
                        && flight.getFlightDetails().getArrival().equals(to)).collect(Collectors.toList());
    }
}
