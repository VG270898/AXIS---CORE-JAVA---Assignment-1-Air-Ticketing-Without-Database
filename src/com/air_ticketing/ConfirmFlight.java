package com.air_ticketing;

public class ConfirmFlight {
    String  flightId;
    double price;

    ConfirmFlight(String flightId,int age){
        this.flightId=flightId;

        System.out.println("Redirecting to Payment...");
        Payment payment = new Payment();
        price=payment.calculatePayment(flightId,age);
    }


}
