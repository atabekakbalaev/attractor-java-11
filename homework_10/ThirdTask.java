import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int previous;
        int current;
        double amountDue;
        int amountUsed = 0;
        int numberOfResidents;
        double amountLeftInKw;

        double firstLevelTariff = 16.24;
        double secondLevelTariff = 21.8;
        double thirdLevelTariff = 25.6;

        double firstLevelRatio = 0.345;
        double secondLevelRatio = 0.225;
        double thirdLevelRatio = 0.43;

        double firstLevelAmountInKw, secondLevelAmountInKw, thirdLevelAmountInKw;
        double firstLevelAmountDue, secondLevelAmountDue, thirdLevelAmountDue;

        System.out.print("Enter the previous value of the reader: ");
        previous = scanner.nextInt();
        System.out.print("Enter the current value of the reader: ");
        current = scanner.nextInt();
        System.out.print("Enter the number of residents: ");
        numberOfResidents = scanner.nextInt();
        amountUsed = Math.abs(previous - current);

        firstLevelAmountInKw = numberOfResidents * 115;
        secondLevelAmountInKw = (amountUsed - firstLevelAmountInKw) * 1/3;
        thirdLevelAmountInKw = (amountUsed - firstLevelAmountInKw) * 2/3;

        firstLevelAmountDue = (double) Math.round(firstLevelTariff * firstLevelAmountInKw * 10.0) / 10;
        secondLevelAmountDue = (double) Math.round(secondLevelTariff * secondLevelAmountInKw * 10.0) / 10;
        thirdLevelAmountDue = (double) Math.round(thirdLevelTariff * thirdLevelAmountInKw * 10.0) / 10;

        amountDue = firstLevelAmountDue + secondLevelAmountDue + thirdLevelAmountDue;

        System.out.println("\nYou have used: ");
        System.out.println("First level: " + firstLevelAmountInKw + "kW");
        System.out.println("Second level: " + secondLevelAmountInKw + "kW");
        System.out.println("Third level: " + thirdLevelAmountInKw + "kW");

        System.out.println("\nTariff: " + firstLevelTariff + "kzt, " + secondLevelTariff + "kzt, " + thirdLevelTariff + "kzt");
        System.out.println("Amount due:");
        System.out.println("First level: " + firstLevelAmountDue + "kzt");
        System.out.println("Second level: " + secondLevelAmountDue + "kzt");
        System.out.println("Third level: " + thirdLevelAmountDue + "kzt");
        System.out.println("Total: " + amountDue + "kzt");

        scanner.close();
    }
}