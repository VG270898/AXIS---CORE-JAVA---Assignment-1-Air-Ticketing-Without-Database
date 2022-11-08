package com.air_ticketing;

public class Payment {
    double calculatePayment(String flightId,int age){
        double price = 0;
        for(flights fl:flights.values()){
            if(fl.flightId.equals(flightId)){
                price = fl.basePrice;
            }
        }

        if(age<=12 || age>=60 ){
            price=price-(price*0.3);
        }
        else {
            price=price-(price*0.1);
        }

        return price;
    }

    //using payment api gateway
}
