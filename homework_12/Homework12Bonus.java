import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Homework12Bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the homework number(from 8 to 11): ");
        int option = scanner.nextInt();
        switch(option) {
            case 8:
                taskEight(scanner);
                break;
            case 9:
                taskNine();
                break;
            case 10:
                taskTen();
                break;
            case 11:
                taskEleven(scanner);
                break;
            default:
                break;
        }
        scanner.close();
    }
    static void taskEight(Scanner scanner){
        int cartLength = 18, availableSpots = 20;
        int[][] carts = new int[cartLength][availableSpots];
        Random random = new Random();
        int cartNumber;
        String[] emptySpotText = new String[20];
        int emptySpots = 0;
        String col = " %02d";
        String row = " %2s";
        for (int i = 0; i < cartLength; i++) {
            for (int j = 0; j < availableSpots; j++) {
                carts[i][j] = random.nextInt(2);
            }
        }
        System.out.print("  ");
        for (int i = 0; i < availableSpots; i++) {
            System.out.print(String.format(col, i + 1));
        }
        System.out.println();
        for (int i = 0; i < cartLength; i++) {
            System.out.print(String.format("%2s", i + 1));
            for (int j = 0; j < availableSpots; j++) {
                if ( carts[i][j] == 1)
                    System.out.print(String.format(row, "*"));
                else
                    System.out.print(String.format(row, " "));

            }
            System.out.println();
        }
        System.out.print("Enter cart number: ");
        cartNumber = scanner.nextInt();
        while (cartNumber <= 0 || cartNumber > 18) {
            System.out.println("Enter a cart number between 1 and 18.");
            System.out.print("Enter cart number: ");
            cartNumber = scanner.nextInt();
        }
        System.out.print("  ");
        for (int i = 0; i < availableSpots; i++) {
            System.out.print(String.format(col, i + 1));
        }
        System.out.println();
        System.out.print(String.format("%2s", cartNumber));
        for (int j = 0; j < availableSpots; j++) {
            if ( carts[cartNumber - 1][j] == 1) {
                System.out.print(String.format(row, "*"));
            } else {
                System.out.print(String.format(row, " "));
                emptySpotText[emptySpots] = String.format("%02d", j + 1);
                emptySpots++;
            }

        }
        String[] spotArray = Arrays.copyOfRange(emptySpotText, 0, emptySpots);
        System.out.println();
        System.out.println("Vacant berth count: " + emptySpots);
        System.out.println("Vacant berth: " + String.join(", ", spotArray));

    }
    static void taskNine() {
        int length = 10;
        Random random = new Random();
        String divider = "+----";
        String numbersFormat = "%4s ";
        int[] temperatures = new int[length];
        int[] precipitations = new int[length];
        int precipitationAsSnow = 0;
        int precipitationAsRain = 0;
        for (int i = 0; i < length; i++) {
            temperatures[i] = random.nextInt(41) - 15;
            precipitations[i] = random.nextInt(20) + 5;
        }
        System.out.print(String.format(numbersFormat, ""));
        for (int i = 0; i < length; i++) {
            System.out.print(String.format(numbersFormat, i + 1));
        }
        System.out.println();
        for (int i = 0; i < length + 1; i++) {
            System.out.print(divider);
        }
        System.out.println();
        System.out.print(String.format(numbersFormat, "mm"));
        for (int i = 0; i < length; i++) {
            System.out.print(String.format(numbersFormat, precipitations[i]));
        }
        System.out.println();
        System.out.print(String.format(numbersFormat, "tC"));
        for (int i = 0; i < length; i++) {
            System.out.print(String.format(numbersFormat, temperatures[i]));
        }
        System.out.println();
        System.out.print(String.format(numbersFormat, ""));
        for (int i = 0; i < length; i++) {
            if (temperatures[i] > 0) {
                System.out.print(String.format(numbersFormat, ""));
                precipitationAsRain += precipitations[i];
            } else {
                System.out.print(String.format(numbersFormat, "*"));
                precipitationAsSnow += precipitations[i];
            }
        }
        System.out.println();
        String f = "%s %d mm";
        System.out.println(String.format(f, "Precipitation as rain ", precipitationAsRain));
        System.out.println(String.format(f, "Precipitation as snow ", precipitationAsSnow));

    }
    static void taskTen() {
        int number = 9;
        String divider = "+----";
        String numberDivider = "|%3d ";
        
        for (int i = 1; i <= number; i++) {
            for (int k = 0; k < number; k++) {
                System.out.print(divider);
            }
            System.out.println("+");
            for (int j = 1; j <= number; j++) {
                System.out.print(String.format(numberDivider, j * i));
            }
            System.out.println("|");
        }
    } 
    static void taskEleven(Scanner scanner) {
        String f = "In the metric system: %.2f %s";
        System.out.print("Enter a quantity: ");
        double quantity = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter the measurement unit(in, ft, yd, mi, oz, lb): ");
        String unit = scanner.nextLine();
        switch(unit) {
            case "in":
                System.out.println(String.format(f, quantity * 2.54, "cm"));
                break;
            case "ft":
                System.out.println(String.format(f, quantity * 0.3048, "m"));
                break;
            case "yd":
                System.out.println(String.format(f, quantity * 0.9144, "m"));
                break;
            case "mi":
                System.out.println(String.format(f, quantity * 1.60934, "km"));
                break;
            case "oz":
                System.out.println(String.format(f, quantity * 0.0295735, "lt"));
                break;
            case "lb":
                System.out.println(String.format(f, quantity * 0.453592, "kg"));
                break;
            default:
                System.out.println("Cannot convert from " + unit);
                break;
        }

    }    

}
