package com.fly.project.repository;

import com.fly.project.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private List<Ticket> ticketList=new ArrayList<>();

    public List<Ticket> saveTicket(List<Ticket> ticketsListToAdd) {
        ticketList.addAll(ticketsListToAdd);
        return ticketsListToAdd;
    }
    public void saveToJsonfile(List<Ticket> ticketList){

    }
}
