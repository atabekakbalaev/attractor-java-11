package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try{
            Truck[] trucks = JsonSerializer.getTrucks();
            trucks[0].startDriving();
            trucks[1].startDriving();
            JsonSerializer.writeTrucks(trucks);
        }catch (IOException ie){

        }
    }
}
