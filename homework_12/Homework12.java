import java.util.Random;
import java.util.Scanner;

public class Homework12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the homework number(from 1 to 7): ");
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                taskOne();
                break;
            case 2:
                taskTwo(scanner);
                break;
            case 3:
                taskThree();
                break;
            case 4:
                taskFour();
                break;
            case 5:
                taskFive();
                break;
            case 6:
                taskSix();
                break;
            case 7:
                taskSeven();
                break;
            default:
                break;
        }
        scanner.close();
    }
    static void taskSeven() {
        Random random = new Random();
        int length = 25;
        int[] people = new int[length];
        int fatPeopleLength = random.nextInt(10) + 1;
        int normPeopleLength = 25 - fatPeopleLength;
        double sumOfFatPeople = 0;
        double sumOfNormPeople = 0;
        String f = "people[%d] = %d";
        for (int i = 0; i < fatPeopleLength; i++) {
            people[i] = random.nextInt(50) + 101;
            System.out.println(String.format(f, i, people[i]));
        }
        for (int i = fatPeopleLength; i < length; i++ ) {
            people[i] = random.nextInt(50) + 50;
            System.out.println(String.format(f, i, people[i]));
        }
        for (int i = 0; i < length; i++) {
            if (people[i] > 100) {
                sumOfFatPeople += people[i];
            } else {
                sumOfNormPeople += people[i];
            }
        }
        f = "%s people's average weight is %.2fkg";
        System.out.println(String.format(f, "Overweight", (double)sumOfFatPeople/fatPeopleLength));
        System.out.println(String.format(f, "Normal", (double)sumOfNormPeople/normPeopleLength));

    }
    static void taskSix(){
        Random random = new Random();
        int length = 10;
        int[] numbers = new int[length];
        String f = "numbers[%d] = %d";
        System.out.println("1. Array contents:");
        for (int i = 0; i < length; i++) {
            numbers[i] = random.nextInt(21) - 10;
            System.out.println(String.format(f, i, numbers[i]));
        }
        System.out.println("\n2.1 Positive numbers in the array:");
        for (int i = 0; i < length; i++) {
            if (numbers[i] > 0) {
                System.out.println(String.format(f, i, numbers[i]));
            }
        }
        System.out.println("2.2 Negative numbers in the array:");
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0) {
                System.out.println(String.format(f, i, numbers[i]));
            }
        }
        System.out.println("\n3.1 Even index numbers in the array:");
        for (int i = 0; i < length; i+=2) {
            System.out.println(String.format(f, i, numbers[i]));
        }
        System.out.println("3.2 Odd index numbers in the array:");
        for (int i = 1; i < length; i+=2) {
            System.out.println(String.format(f, i, numbers[i]));
        }
        System.out.println("4. Positive and negative numbers in the array:");
        int positive = 0;
        int negative = 0;
        int zeros = 0;
        f = "%s: %d";
        for (int i = 0; i < length; i++) {
            if (numbers[i] > 0) {
                positive++;
            }
            else if (numbers[i] < 0) {
                negative++;
            } else {
                zeros++;
            }
        }
        System.out.println(String.format(f, "Positive", positive));
        System.out.println(String.format(f, "Negative", negative));
        System.out.println(String.format(f, "Zeroes", zeros));

    }
    static void taskFive() {
        int dataLength = 15;
        int[] readings = new int[dataLength];
        int sum = 0;
        Random random = new Random();
        for (int i = 0; i < dataLength; i++) {
            readings[i] = random.nextInt(51);
            sum += readings[i];
        }
        String f = "The average precipitation of %d readings is %.2fmm";
        System.out.println(String.format(f, dataLength, (double)sum/dataLength));
    }
    static void taskFour() {
        int length = 15;
        int[] fiboArray = new int[length];
        String f = "fibonacci(%2d) = %d";
        fiboArray[0] = 1;
        fiboArray[1] = 1;
        for (int i = 2; i < length; i++) {
            fiboArray[i] = fiboArray[i - 1] + fiboArray[i - 2];
        }
        System.out.println("Fibonacci series in ascending order:");
        for (int i = 0; i < length; i++) {
            System.out.println(String.format(f, i + 1, fiboArray[i]));
        }
        System.out.println("\nFibonacci series in descending order:");
        for (int i = length - 1; i >= 0; i--) {
            System.out.println(String.format(f, i + 1, fiboArray[i]));
        }
    }
    static void taskThree() {
        Random random = new Random();
        String f = "The height of the building %2d = %d.";
        int[] heightOfBuildings = new int[15];
        for(int i = 0; i < heightOfBuildings.length; i++) {
            heightOfBuildings[i] = random.nextInt(560) + 275;
            System.out.println(String.format(f, i + 1, heightOfBuildings[i]));
        }
        // Bubble sort
        boolean swapped = false;
        int top = heightOfBuildings.length - 1;
        while( top > 0 || !swapped) {
            for (int j = 0; j < top; j++) {
                if (heightOfBuildings[j] > heightOfBuildings[j + 1]) {
                    swapped = true;
                    int temp = heightOfBuildings[j];
                    heightOfBuildings[j] = heightOfBuildings[j + 1];
                    heightOfBuildings[j + 1] = temp;
                }
            }
            top -= 1;
        }
        System.out.println("\nHeight of buildings in the sorted format:");
        for(int i = 0; i < heightOfBuildings.length; i++) {
            System.out.println(String.format(f, i + 1, heightOfBuildings[i]));
        }
    }
    static void taskTwo(Scanner scanner) {
        System.out.print("Enter a number for the multiple table from 1 to 9: ");
        int n = scanner.nextInt();
        String f = "%d * %d = %d";
        for(int i = 1; i < 10; i++) {
            System.out.println(String.format(f, n, i, n * i));
        }
    }
    static void taskOne() {
        String[] words = {", kid.", "That's where", "and corners", "Doors", "you", "they get"};
        String f = "%s %s%s %s %s %s.";
        System.out.println(String.format(f, words[3], words[2], words[0], words[1], words[5], words[4]));
    }
}