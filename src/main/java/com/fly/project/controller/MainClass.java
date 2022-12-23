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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;


public class MainClass {
    public static void main(String[] args) throws IOException, ParseException {

        FlightScheduleRepository flightScheduleRepository = new FlightScheduleRepository();
        FlightService flightService = new FlightService(flightScheduleRepository);
        TicketRepository ticketRepository = new TicketRepository();
        ReservationService reservationService = new ReservationService(ticketRepository);
// input data
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome! Please enter departure airport:");
        String departure = br.readLine();
        System.out.println("Please enter arrived airport:");
        String arrived = br.readLine();

        List<Flight> resultSet = flightService.searchFlight(departure, arrived, LocalDate.of(2022, 12, 31));
        if (!(resultSet.isEmpty())) {
            for (Flight flight : resultSet) {
                System.out.println(flight);
            }
        } else {
            System.out.println("We did not find flight for the date");
        }


        if (!(resultSet.isEmpty())) {
            List<Ticket> tickets = reservationService.makeReservation(resultSet.get(0), List.of(Adult.builder().fullName(new Person.FullName("a", "b")).build()));
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }


    }


}
