import java.util.Scanner;
import java.text.DecimalFormat;

public class Homework11 {
    public static void main(String[] args) {
        int option;
        System.out.print("Enter a homework number(1, 2, 3, 4, 5, 6, or 7): ");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();

        switch(option) {
            case 1:
                taskOne(scanner);
                break;
            case 2:
                taskTwo(scanner);
                break;
            case 3:
                taskThree(scanner);
                break;
            case 4:
                taskFour(scanner);
                break;
            case 5:
                taskFive(scanner);
                break;
            case 6:
                taskSix(scanner);
                break;
            case 7:
                taskSeven(scanner);
                break;
            default:
                // code block
            }
        scanner.close();
    }
    static void taskOne(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter club name: ");
        String clubName = scanner.nextLine();
        System.out.println("Length of the clubname: " + clubName.length());
        System.out.println("The clubname in uppercase: " + clubName.toUpperCase());
        System.out.println("The clubname: " + clubName);
    }
    static void taskTwo(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter the first lastname: ");
        String firstLastname = scanner.nextLine();
        System.out.print("Enter the second lastname: ");
        String secondLastname = scanner.nextLine();
        int firstLastnameLength = firstLastname.length();
        int secondLastnameLength = secondLastname.length();
        String f = "|%20s|%20s";
        System.out.println(String.format(f, "Last Names", "Length of the last names"));
        System.out.println(String.format(f, firstLastname, firstLastnameLength));
        System.out.println(String.format(f, secondLastname, secondLastnameLength));
        String lengthStatus = (firstLastnameLength > secondLastnameLength) ? firstLastname + " is longer than " + secondLastname : secondLastname + " is longer than " + firstLastname;
        System.out.println(lengthStatus);
    }
    static void taskThree(Scanner scanner) {
        System.out.print("Enter x: ");
        double x = scanner.nextDouble();
        if (x > 0) {
            System.out.println("y = sin^2(x): " + Math.pow(Math.sin(x), 2));
        } else {
            System.out.println("y = 1 - sin(x^2): " + (1 - Math.sin(x*x)));
        }
    }
    static void taskFour(Scanner scanner) {
        System.out.print("Enter first speed in km/h: ");
        double speedOne = scanner.nextDouble();
        System.out.print("Enter second speed in m/s: ");
        double speedTwo = scanner.nextDouble();
        double speedOneInMpS = speedOne * 1000/3600;
        if (speedOneInMpS > speedTwo) {
            System.out.println(speedOne + " km/h is greater than " + speedTwo + " m/s");
        } else {
            System.out.println(speedTwo + " m/s is greater than " + speedOne + " km/h");
        }
    }
    static void taskFive(Scanner scanner) {
        System.out.print("Enter the radius of a circle: ");
        double radius = scanner.nextDouble();
        System.out.print("Enter second speed in m/s: ");
        double side = scanner.nextDouble();
        double circleArea = Math.PI * radius * radius;
        double squareArea = side * side;
        DecimalFormat df1 = new DecimalFormat("#.##");
        System.out.println("The area of the circle is: " + df1.format(circleArea));
        System.out.println("The area of the square is: " + df1.format(squareArea));
        if (circleArea > squareArea) {
            System.out.println("The area of the square is less.");
        } else {
            System.out.println("The area of the circle is less.");
        }
    }
    static void taskSix(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String eToI = sentence.replace("e", "i");
        String dToT = eToI.replace("d", "t");
        System.out.println("Original sentence: " + sentence);
        System.out.println("Second sentence: " + eToI);
        System.out.println("Third sentence: " + dToT);
    }
    static void taskSeven(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter a sentence: ");
        String lineOfText = scanner.nextLine();
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        int index = lineOfText.indexOf(word);
        if (index < 0) {
            System.out.println(word + " could not be found in the line of text.");
        } else {
            System.out.println(word + " is found at the index of " + index);
        }
    }
}