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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


public class MainClass {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {

        FlightScheduleRepository flightScheduleRepository = new FlightScheduleRepository();
        FlightService flightService = new FlightService(flightScheduleRepository);
        TicketRepository ticketRepository = new TicketRepository();
        ReservationService reservationService = new ReservationService(ticketRepository);

// input data for search
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome! Please enter departure airport:");
        String departure = br.readLine();
        System.out.println("Please enter arrived airport:");
        String arrived = br.readLine();
        System.out.println("Please enter date in format dd-MM-yyyy:");
        Date departureDate = DATE_FORMAT.parse(br.readLine());
        LocalDate date = departureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

//result of the search
        List<Flight> resultSet = flightService.searchFlight(departure, arrived, date);
        if (!(resultSet.isEmpty())) {
            for (Flight flight : resultSet) {
                System.out.println(flight);
            }
        } else {
            System.out.println("We did not find flight for the date");
        }
        //create ticket

        System.out.println("Would you like to buy the ticket? ");


        if ((!(resultSet.isEmpty())) && isYesNo()) {

            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter first name:");
            String firstName = br2.readLine();
            System.out.println("Please enter last name:");
            String lastName = br2.readLine();
            System.out.println("Please enter your age");
            int age = Integer.parseInt(br2.readLine());

            List<Ticket> tickets = reservationService.makeReservation(resultSet.get(0), List.of(Adult.builder().fullName(new Person.FullName(firstName, lastName)).age(age).build()));
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
            ticketRepository.saveToJsonfile();
        }

    }

    public static boolean isYesNo() {

        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 'yes' or 'no': ");
        String yesNo = null;
        try {
            yesNo = br1.readLine();
        } catch (IOException e) {
            System.out.println("You enter incorrect value!");
        }
        return yesNo.equalsIgnoreCase("yes");
    }
}
