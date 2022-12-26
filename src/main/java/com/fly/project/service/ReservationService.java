package com.fly.project.service;

import com.fly.project.model.Flight;
import com.fly.project.model.Person;
import com.fly.project.model.Ticket;
import com.fly.project.repository.TicketRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ReservationService {
    private TicketRepository ticketRepository;

    public List<Ticket> makeReservation(Flight flight, List<Person> personList) {
        List<Ticket> ticketList = personList.stream().map(p -> Ticket.builder().flight(flight).person(p).build()).toList();
        return ticketRepository.saveTicket(ticketList);
    }
}
