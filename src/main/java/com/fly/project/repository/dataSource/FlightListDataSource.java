package com.fly.project.repository.dataSource;

import com.fly.project.model.Flight;
import com.fly.project.model.FlightDetails;
import lombok.Getter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class FlightListDataSource {
private List<Flight> flightList=new ArrayList<>();

    public FlightListDataSource() {
        initialData();
    }
    public void initialData(){
        flightList=new ArrayList<>();
        Flight flight=new Flight();
        flight.setFlightDetails(FlightDetails.builder().departure("Lviv").arrival("Kyiv").minutes(60).build());
        flight.setDepartureTime(LocalDateTime.MAX);
        flightList.add(flight);
    }

    public static void main(String[] args) throws IOException, ParseException {
        initialDataFromJsonFile();
    }

    public static void initialDataFromJsonFile() throws IOException, ParseException {
        String path = "src/main/resources/FlySchedule.json";
        FileReader fileReader = new FileReader(path);
        JSONParser jsonParser = new JSONParser();
        JSONObject object = (JSONObject) jsonParser.parse(fileReader);
        JSONArray flights = (JSONArray) object.get("flights");
//        for (Object l : flights) {
//            System.out.println(l);
//        }
        for (int i=0; i<flights.size();i++){
            System.out.println(flights);
        }

    }
}
