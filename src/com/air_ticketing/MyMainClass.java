package com.air_ticketing;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MyMainClass {
    public static void main(String[] args) {
        String source;
        String destination;
        String dateOfFlight;
        String classOfJourney;
        String bookAgain="yes";
        int log=0;
        boolean loginStatus=false;
        Scanner scanner=new Scanner(System.in);
        Login login = new Login();

        while (true){
            if(loginStatus){
                System.out.println("Logged in successfully...!\n");
                System.out.println("\t\t\t**** Welcome to Smart Air Ticket Booking System ****");
                System.out.println("Please Enter details to search flight : ");
                log=1;
                while(bookAgain.equals("yes")) {
                    System.out.print("Enter Source of Flight : ");
                    source = scanner.nextLine();
                    System.out.print("Enter Destination of Flight : ");
                    destination = scanner.nextLine();
                    System.out.print("Enter Date of Flight in (YYYY/MM/DD) format : ");
                    dateOfFlight = scanner.nextLine();
                    System.out.print("Enter class of journey : ");
                    classOfJourney = scanner.nextLine();
                    FlightDetails flightDetails = new FlightDetails(source, dateOfFlight, destination, classOfJourney);
                    try {
                        ArrayList<ArrayList> flDetails = flightDetails.findFlights();
                        if (flDetails.isEmpty()) {
                            System.out.println("Enter Valid details");
                            continue;
                        } else {
                            System.out.println("Flight Details are : ");
                            System.out.println("___________________________________________________________");
                            for (int i = 0; i < flDetails.size(); i++) {
                                System.out.println("Flight " + i+1 +" : ");
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("Flight Id is " + flDetails.get(i).get(0));
                                System.out.println("Flight Name is " + flDetails.get(i).get(1));
                                System.out.println("Class type is " + flDetails.get(i).get(2));
                                System.out.println("Price is " + flDetails.get(i).get(3));
                                System.out.println("___________________________________________________________");
                            }

                            System.out.println("Enter flight Id you want : ");
                            String flId = scanner.nextLine();
                            for (ArrayList flDetail : flDetails) {
                                if (flDetail.get(0).equals(flId)) {
                                    System.out.print("Do you really want go with Flight ID " + flId + " yes/no : ");
                                    String st = scanner.nextLine();
                                    if (Objects.equals(st, "yes") || Objects.equals(st, "Yes")) {
                                        PassengerDetails passengerDetails = new PassengerDetails();
                                        System.out.print("Enter your name : ");
                                        passengerDetails.passengerName = scanner.nextLine();
                                        System.out.print("Enter your age : ");
                                        passengerDetails.age = scanner.nextInt();
                                        System.out.print("Enter your mobile no : ");
                                        passengerDetails.mobileNo= scanner.nextLong();
                                        System.out.print("Enter your Address : ");
                                        passengerDetails.passengerAddress = scanner.nextLine();
                                        passengerDetails.details.add(passengerDetails.passengerName);
                                        passengerDetails.details.add(passengerDetails.age);
                                        passengerDetails.details.add(passengerDetails.mobileNo);
                                        passengerDetails.details.add(passengerDetails.passengerAddress);

                                        ConfirmFlight confirmFlight = new ConfirmFlight(flId,passengerDetails.age);
                                        System.out.println("Successfully Booked!, Thank You!");
                                        System.out.println("");
                                        System.out.println("********************************************************");
                                        System.out.println("Your Flight Details are : ");
                                        System.out.println("********************************************************");
                                        System.out.println("Your Name : " + passengerDetails.passengerName);
                                        System.out.println("Your Age : " + passengerDetails.age);
                                        System.out.println("Your Mobile No : " + passengerDetails.mobileNo);
                                        System.out.println("Your Address : " + passengerDetails.passengerAddress);
                                        System.out.println("Flight Id is " + flDetail.get(0));
                                        System.out.println("Flight Name is " + flDetail.get(1));
                                        System.out.println("Class type is " + flDetail.get(2));
                                        System.out.println("Source : " + source);
                                        System.out.println("Destination : " + destination);
                                        System.out.println("Date of Journey : " + dateOfFlight);
                                        System.out.println("Class Type : " + classOfJourney);
                                        System.out.println("Total price after discount : " + confirmFlight.price);
                                        System.out.println("********************************************************");
                                        System.out.println();
                                        System.out.println("Do you want to Book Again? (yes/no) : ");
                                        bookAgain = scanner.nextLine();
                                        break;
                                    } else {
                                        System.out.println("Redirecting to Home Page...");
                                    }
                                }
                            }
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                }
                System.out.println("************ Visit Again! ************");
                break;
            }else loginStatus=login.isAuthenticate();
        }

    }
}
