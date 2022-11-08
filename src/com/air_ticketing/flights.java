package com.air_ticketing;

public enum flights {
    indigo("IND123", new String[]{"economy"},1500),
    airIndia("AIR123",new String[]{"economy", "business"},2500),
    spiceJet("SPI123",new String[]{"economy", "business"},3000),
    vistara("VIS123",new String[]{"economy","business"},3500);

    String flightId;
    int basePrice;
    String[] typeOfClass;

    flights(String flightId, String[] typeOfClass,int basicPrice) {
        this.flightId=flightId;
        this.basePrice=basicPrice;
        this.typeOfClass=typeOfClass;
    }
}
