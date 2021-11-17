import java.util.Arrays;
import java.util.Scanner;


public class Labwork13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an option for the labwork from 1 to 7: ");
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                firstTask(scanner);
                break;
            case 2:
                secondTask(scanner);
                break;
            case 3:
                thirdTask(scanner);
                break;
            case 4:
                fourthTask(scanner);
                break;
            case 5:
                fifthTask(scanner);
                break;
            case 6:
                sixthTask(scanner);
                break;
            case 7:
                seventhTask(scanner);
                break;
            default:
                System.out.println("Enter option between 1 to 7.");
                break;
        }

        scanner.close();
    }
    static void fifthTask(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter 2 pairs of coordinates: ");
        String[] values = scanner.nextLine().split(" ");
        if (values.length != 4) {
            System.out.println("Enter 4 values seperated by spaces.");
        } else {
            int x1 = Integer.parseInt(values[0]);
            int y1 = Integer.parseInt(values[1]);
            int x2 = Integer.parseInt(values[2]);
            int y2 = Integer.parseInt(values[3]);
            System.out.println("x1: " + x1);
            System.out.println("y1: " + y1);
            System.out.println("x2: " + x2);
            System.out.println("y2: " + y2);

            String output;
            if (x1 == x2 && y1 == y2) {
                output = "Your home is at the origin.";
            } else if ((x1 == x2 && y1 != y2) || (x1 != x2 && y1 == y2)) {
                output = "Your home is at the border.";
            } else {
                if(x1 > x2 && y1 > y2) {
                    output = "Your house is in Northeast.";
                } else if (x1 > x2 && y1 < y2) {
                    output = "Your house is in Southeast.";
                } else if (x1 < x2 && y1 > y2) {
                    output = "Your house is in Northwest.";
                } else {
                    output = "Your house is in Southwest.";
                }
            }
            System.out.println(output);
        }
    }
    static void thirdTask(Scanner scanner) {
        System.out.print("Enter the height of the tower between 0 and 12: ");
        int height = scanner.nextInt();
        System.out.print("Enter the floor number between 0 and 12: ");
        int floor = scanner.nextInt();
        String floorSymbol = "#";
        for (int i = 0; i < height; i++) {
            String f = "|%" + (height + 2) + "s" + "\n";
            floorSymbol = "#".repeat(i + 2);
            if (floor == i + 1) {
                floorSymbol = "@" + floorSymbol;
            }
            System.out.format(f, floorSymbol);
        }
        System.out.println("-".repeat(height + 3));
    }
    static void sixthTask(Scanner scanner) {
        int length = 10;
        int[] arrayA = new int[length];
        int[] arrayB = new int[length];
        int[] arrayC = new int[length];
        scanner.nextLine();
        System.out.print("Enter 10 elements for the first array:");
        String[] firstArray = scanner.nextLine().strip().split(" ");
        System.out.print("Enter 10 elements for the second array:");
        String[] secondArray = scanner.nextLine().strip().split(" ");
        if (firstArray.length != secondArray.length || firstArray.length != 10) {
            System.out.println("Enter 10 numbers for the first and second arrays.");
        } else {
            for(int i = 0; i < length; i++) {
                arrayA[i] = Integer.parseInt(firstArray[i]);
                arrayB[i] = Integer.parseInt(secondArray[i]);
                arrayC[i] = arrayA[i] + arrayB[i];
            }
            System.out.println(Arrays.toString(arrayA));
            System.out.println(Arrays.toString(arrayB));
            System.out.println(Arrays.toString(arrayC));
            int max = arrayC[0];
            for (int i = 1; i < length; i++) {
                if (max < arrayC[i]) max = arrayC[i];
            }
            String f = "%s %d\n";
            System.out.format(f, "Maximum number in the array C = ", max);
            System.out.format(f, "Maximum number in the last three items in array C = ", 
                max(max(arrayC[length - 1], arrayC[length - 2]), arrayC[length - 3]));
        }

    }
    static void seventhTask(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter the first 9 digits of an ISBN number: ");
        String input = scanner.nextLine();
        int length = input.length();
        if (length != 9) {
            System.out.println("Enter 9 digits without spaces.");
        } else {
            int[] isbn = new int[length + 1];
            int sum = 0;
            for (int i = 0; i < length; i++) {
                isbn[i] = Character.getNumericValue(input.charAt(i));
                sum += isbn[i] * (length + 1 - i);
            }
            System.out.format("%s-%d\n", input, 11 - sum % 11);
        }
    }
    static void secondTask(Scanner scanner) {
        System.out.print("Enter the number of guests(0 to 1000): ");
        String f = "There are minimum of %d cuts by %s.\n";
        int number = scanner.nextInt();
        if (number < 0 && number > 1000) {
            System.out.println("Enter a number between 0 to 1000.");
        } else {
            number++;
            if (number % 2 == 0) {
                System.out.format(f, (int) number / 2, "diameter");
            } else {
                System.out.format(f, number, "radius");
            }
        }
    }
    static void firstTask(Scanner scanner) {
        int[] salaries = new int[3];
        String f = "%s %,d som\n";
        System.out.print("Enter the salary of the first employee: ");
        salaries[0] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the salary of the second employee: ");
        salaries[1] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the salary of the third employee: ");
        salaries[2] = scanner.nextInt();
        scanner.nextLine();

        System.out.format(f, "The heighest salary: ", max(max(salaries[0], salaries[1]), salaries[2]));
        System.out.format(f, "The minimum salary: ", min(min(salaries[0], salaries[1]), salaries[2]));
    }
    static void fourthTask(Scanner scanner) {
        System.out.print("Your age in days: ");
        String f = "%s: %d; ";
        int allDays = scanner.nextInt();
        int days;
        int months;
        int years;
        if (allDays < 0) {
            System.out.println("Enter days >0");
        } else {
            years = (int) allDays / 365;
            months = (int) (allDays % 365) / 30;
            days = (allDays % 365) % 30;
            System.out.format(f, "Years", years);
            System.out.format(f, "Months", months);
            System.out.format(f, "Days", days);
            System.out.println();

        }
    }
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}