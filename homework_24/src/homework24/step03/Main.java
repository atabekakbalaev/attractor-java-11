package homework24.step03;

import homework24.step04.CheckInput;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Truck[] trucks;
        Driver[] drivers;
        try {
              trucks = JsonSerializer.getTrucks();
              drivers = JsonSerializer.getDrivers();
              printTrucks(trucks);
              printDrivers(drivers, trucks);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printTrucks(Truck[] trucks) {
        System.out.println("-".repeat(19) + "Trucks" + "-".repeat(19));
        String divider = ".".repeat(3) + "+" + "-".repeat(18) + "+" + "-".repeat(10) + "+" + ".".repeat(10);
        String placeholder = "%-3s|%-18s|%10s|%10s\n";
        System.out.format(placeholder,"#", "Bus", "Driver", "State");
        System.out.println(divider);
        for(Truck t : trucks) {
            System.out.format(placeholder, t.getId(), t.getName(), t.getDriver() == null ? "" : t.getDriver(),
                    t.getState());
        }
    }
    public static void printDrivers(Driver[] drivers, Truck[] trucks) {
        System.out.println("-".repeat(19) + "Drivers" + "-".repeat(19));
        String divider = ".".repeat(6) + "+" + "-".repeat(12) + "+" + "-".repeat(10);
        String placeholder = "%-6s|%-12s|%10s\n";
        System.out.format(placeholder,"#", "Driver", "Bus");
        System.out.println(divider);
        for(Driver d : drivers) {
            Truck t = getTheTruckOfTheDriver(d, trucks);
            System.out.format(placeholder, d.getId(), d.getName(),
                    t == null ? "" : t.getName());
        }
    }
    public static Truck getTheTruckOfTheDriver(Driver d, Truck[] trucks) {
        for(Truck t: trucks) {
            if (t.getDriver() == d) {
                return t;
            }
        }
        return null;
    }
}
