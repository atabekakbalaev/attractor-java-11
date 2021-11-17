import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int previous;
        int current;
        int pricePerKw = 21;
        int amountDue = 0;
        int amountUsed = 0;

        System.out.print("Enter the previous value of the reader: ");
        previous = scanner.nextInt();

        System.out.print("Enter the current value of the reader: ");
        current = scanner.nextInt();

        amountUsed = Math.abs(previous - current);

        System.out.println("You have used: " + amountUsed + "kW");
        System.out.println("Tariff: " + pricePerKw + "tg");
        
        amountDue = pricePerKw * amountUsed;
        System.out.println("Amount due: " + amountDue + "tg");
        scanner.close();
    }
}