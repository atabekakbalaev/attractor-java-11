package homework24.step04;

import com.google.gson.Gson;

import java.io.*;

public class JsonSerializer {
    public static Truck[] getTrucks() throws IOException {
        Gson gson = new Gson();
        try(Reader reader = new FileReader("Trucks.json")) {
            Truck[] trucks = gson.fromJson(reader, Truck[].class);
            for (int i = 0; i < trucks.length; i++) {
                trucks[i].fillState();
            }
            return trucks;
        }
    }
    public static void writeTrucks(Truck[] trucks) throws IOException {
        Gson gson = new Gson();
        try(Writer writer = new FileWriter("Trucks.json")) {
            String json = gson.toJson(trucks);
            writer.write(json);
        }
    }

    public static Driver[] getDrivers() throws IOException {
        Gson gson = new Gson();
        try(Reader reader = new FileReader("Drivers.json")) {
            Driver[] drivers = gson.fromJson(reader, Driver[].class);
            return drivers;
        }
    }
    public static void writeDrivers(Driver[] drivers) throws IOException {
        Gson gson = new Gson();
        try(Writer writer = new FileWriter("Drivers.json")) {
            String json = gson.toJson(drivers);
            writer.write(json);
        }
    }
}
