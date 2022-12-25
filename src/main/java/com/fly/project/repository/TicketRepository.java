package com.fly.project.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fly.project.model.Ticket;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private List<Ticket> ticketList = new ArrayList<>();

    public List<Ticket> saveTicket(List<Ticket> ticketsListToAdd) {
        ticketList.addAll(ticketsListToAdd);
        return ticketsListToAdd;
    }

    public void saveToJsonfile(List<Ticket> ticketsListToJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        System.out.println("Writing Ticket to JSON file");
        System.out.println("-----------------------");
        mapper.writeValue(new File("src/main/resources/Ticket.json"), ticketsListToJson);
    }
}

