package com.step01;

import com.google.gson.Gson;

import java.io.*;

public class JsonSerializer {
    public static Product[] getProducts() throws IOException {
        Gson gson = new Gson();
        try(Reader reader = new FileReader("Products.json")){
            Product[] products = gson.fromJson(reader,Product[].class);
            for(int i = 0; i < products.length; i++){
                products[i].fillState();
            }
            return products;
        }
    }
//    public static void writeTrucks(Product[] trucks) throws IOException {
//        Gson gson = new Gson();
//        try(Writer writer = new FileWriter("Products.json")){
//            String json = gson.toJson(trucks);
//            writer.write(json);
//        }
//    }
//    public static Driver[] getDrivers() throws IOException {
//        Gson gson = new Gson();
//        try(Reader reader = new FileReader("Drivers.json")){
//            Driver[] drivers = gson.fromJson(reader,Driver[].class);
//            return drivers;
//        }
//    }
//    public static void writeDrivers(Driver[] drivers) throws IOException {
//        Gson gson = new Gson();
//        try(Writer writer = new FileWriter("Drivers.json")){
//            String json = gson.toJson(drivers);
//            writer.write(json);
//        }
//    }
}
