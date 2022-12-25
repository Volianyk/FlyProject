package com.fly.project.model;

import lombok.Builder;

@Builder
public class Ticket {
    private Flight flight;
    private Person person;

    @Override
    public String toString() {
        return "Ticket: " +'\n'+ flight.toStringForTicket() + person;
    }
}
