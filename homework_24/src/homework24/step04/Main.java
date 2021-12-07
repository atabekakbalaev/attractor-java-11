package homework24.step04;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Truck[] trucks;
        Driver[] drivers;
        Scanner scanner = new Scanner(System.in);

        try {
//            JsonSerializer.writeTrucks(trucks);
//            JsonSerializer.writeDrivers(drivers);
              trucks = JsonSerializer.getTrucks();
              drivers = JsonSerializer.getDrivers();
              printTrucks(trucks);
              printDrivers(drivers, trucks);

              boolean truckIsFound = false;
              int tries = 0;
              while(tries++ < 2) {
                  int n = CheckInput.getNumberOnly(scanner, "Enter a truck number: ");
                  for (Truck truck: trucks) {
                      if (Integer.parseInt(truck.getId()) == n) {
                          printTruck(truck);
                          truckIsFound = true;
                      }
                  }
                  if (!truckIsFound) {
                      System.out.println("There is no truck with this id. Try again.");
                      continue;
                  } else {
                      String options = "1. Change the driver\n" +
                              "2. Set to the route\n" + "3. Send for repairing\n";
                      System.out.println("=".repeat(40));
                      System.out.println(options);
                      int m = CheckInput.getNumberOnly(scanner, "Enter your choice: ");
                      int truckIndex = getTruckIndexById(trucks, Integer.toString(n));
                      switch(m) {
                          case 1:
                              trucks[truckIndex].changeDriver();
                              break;
                          case 2:
                              trucks[truckIndex].startDriving();
                              break;
                          case 3:
                              trucks[truckIndex].startRepair();
                              break;
                          default:
                              System.out.println("There is no such option. Rerun the program to try again.");
                      }
                      JsonSerializer.writeTrucks(trucks);
                      JsonSerializer.writeDrivers(drivers);
                  }
              }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static int getTruckIndexById(Truck[] trucks, String id) {
        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    public static void printTruck(Truck truck) {
        System.out.println("N        : " + truck.getId() + "\n" +
                "Bus      : " + truck.getName() + "\n" +
                "Driver   : " + (truck.getDriver() == null ? "" : truck.getDriver().getName()) + "\n" +
                "Bus state: " + truck.getState()
        );
    }
    public static void printTrucks(Truck[] trucks) {
        System.out.println("-".repeat(19) + "Trucks" + "-".repeat(19));
        String divider = ".".repeat(3) + "+" + "-".repeat(18) + "+" + "-".repeat(10) + "+" + ".".repeat(10);
        String placeholder = "%-3s|%-18s|%10s|%10s\n";
        System.out.format(placeholder,"#", "Bus", "Driver", "State");
        System.out.println(divider);
        for(Truck t : trucks) {
            System.out.format(placeholder, t.getId(), t.getName(), t.getDriver() == null ? "" : t.getDriver().getName(),
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
