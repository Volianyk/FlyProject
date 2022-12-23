package com.fly.project.model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Ticket {
    private Flight flight;
    private Person person;

}
