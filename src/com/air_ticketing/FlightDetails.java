package com.air_ticketing;

import java.util.ArrayList;
import java.util.Arrays;

public class FlightDetails {
    String source;
    String destination;
    String dateOfFlight;
    String classOfJourney;

    ArrayList places = new ArrayList();
    ArrayList typeOfClass = new ArrayList();

    FlightDetails(String source,String dateOfFlight,String destination,String classOfJourney){

        this.dateOfFlight=dateOfFlight;
        this.destination=destination;
        this.classOfJourney=classOfJourney;
        this.source=source;
        places.add("delhi");
        places.add("kolkata");
        places.add("bangalore");
        places.add("mumbai");
        places.add("jaipur");
        places.add("varanasi");
        places.add("chennai");

        typeOfClass.add("economy");
        typeOfClass.add("business");
    }

    ArrayList<ArrayList> findFlights() throws Exception {
        int flag = 0;
        ArrayList availableFlights = new ArrayList();
        while (flag == 0) {
            if (!places.contains(source)) {
                throw new  Exception("Source not found!");
            }
            if (!places.contains(destination)) {
                throw new  Exception("Destination not found!");

            }
            if (source.equals(destination)) {
                throw new  Exception("Source and Destination cannot be same!");
            }
            if(!typeOfClass.contains(classOfJourney)){
                throw new  Exception("Enter Correct type of class \"economy\" or \"business\"");
            }

            for(flights fl:flights.values()){
                if(Arrays.asList(fl.typeOfClass).contains(classOfJourney)){
                    ArrayList arr = new ArrayList<>();
                    arr.add(fl.flightId);
                    arr.add(fl);
                    arr.add(classOfJourney);
                    arr.add(fl.basePrice);
                    availableFlights.add(arr);
                }
            }
            flag=1;

        }
        return availableFlights;
    }


}
