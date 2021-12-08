package homework24.step01;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Truck[] trucks;
        try {
              trucks = JsonSerializer.getTrucks();
              printTrucks(trucks);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void printTrucks(Truck[] trucks) {
        String divider = ".".repeat(3) + "+" + "-".repeat(18) + "+" + "-".repeat(10) + "+" + ".".repeat(10);
        String placeholder = "%-3s|%-18s|%10s|%10s\n";
        System.out.format(placeholder,"#", "Bus", "Driver", "State");
        System.out.println(divider);
        for(Truck t : trucks) {
            System.out.format(placeholder, t.getId(), t.getName(), t.getDriver() == null ? "" : t.getDriver(),
                    t.getState());
        }

    }
}
