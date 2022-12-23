package com.fly.project.controller;

import com.fly.project.model.Adult;
import com.fly.project.model.Flight;
import com.fly.project.model.Person;
import com.fly.project.model.Ticket;
import com.fly.project.repository.FlightScheduleRepository;
import com.fly.project.repository.TicketRepository;
import com.fly.project.service.FlightService;
import com.fly.project.service.ReservationService;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class MainClass {
    public static void main(String[] args) throws IOException, ParseException {

        FlightScheduleRepository flightScheduleRepository = new FlightScheduleRepository();
        FlightService flightService = new FlightService(flightScheduleRepository);
        TicketRepository ticketRepository = new TicketRepository();
        ReservationService reservationService = new ReservationService(ticketRepository);

        List<Flight> resultSet = flightService.searchFlight("Lytsk", "Lviv", LocalDate.of(2022, 12, 31));
        List<Ticket> tickets = reservationService.makeReservation(resultSet.get(0), List.of(Adult.builder().fullName(new Person.FullName("a", "b")).build()));
        for (Flight flight : resultSet) {
            System.out.println(flight);
        }
        for (Ticket ticket: tickets){
            System.out.println(ticket);
        }

    }


}
