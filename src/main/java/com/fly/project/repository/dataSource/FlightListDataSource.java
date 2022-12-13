package com.fly.project.repository.dataSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fly.project.model.Flight;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FlightListDataSource {

    public static List<Flight> getFlightList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return Arrays.asList(mapper.readValue(Paths.get("src/main/resources/FlySchedule.json").toFile(), Flight[].class));
    }
}




