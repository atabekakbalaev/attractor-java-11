import java.util.Scanner;

public class BonusHomework11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the homework number(8, 9, 10, 11, 12): ");
        int option = scanner.nextInt();
        switch(option) {
            case 8:
                taskEight(scanner);
                break;
            case 9:
                taskNine(scanner);
                break;
            case 10:
                taskTen(scanner);
                break;
            case 11:
                taskEleven(scanner);
                break;
            case 12:
                taskTwelve(scanner);
                break;
            default:
                break;
        }
        scanner.close();
    }
    static void taskEight(Scanner scanner) {
        System.out.print("Enter minutes: ");
        int minutes = scanner.nextInt();
        minutes = minutes % 5;
        System.out.println(minutes);
        if (minutes >= 3) {
            System.out.println("Red light.");
        } else {
            System.out.println("Green light.");
        }
    }
    static void taskNine(Scanner scanner) {
        System.out.print("Enter months: ");
        int count = scanner.nextInt();
        if (count >= 1 && count <= 1188) {
            int years = (int) count / 12;
            int months = count % 12;
            String yearsWord = (years > 1) ? " years " : " year ";
            String monthsWord = (months > 1) ? " months " : " month ";
            System.out.println(years + yearsWord + "and " + months + monthsWord);
        } else {
            System.out.println("Enter a valid months number from 1 to 1188.");
        }
    }
    static void taskTen(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter firstname: ");
        String firstname = scanner.nextLine();
        firstname = firstname.strip();

        System.out.print("Enter lastname: ");
        String lastname = scanner.nextLine();
        lastname = lastname.strip();

        System.out.print("Enter country: ");
        String country = scanner.nextLine();
        country = country.strip();

        System.out.print("Enter birth year: ");
        int birthYear = scanner.nextInt();

        String f = "Your name is %S %S. And you are %d years old, and you are from %s";
        String output = String.format(f, firstname, lastname, (2019 - birthYear), country);
        System.out.println(output);
    }
    static void taskEleven(Scanner scanner) {
        System.out.print("Enter a value for k between 1 and 222: ");
        int k = scanner.nextInt();
        int sumOfDigits = 0;
        int digits = 0;
        if (k >= 1 && k <= 222) {
            for (int i = 1; i <= 110; i++) {
                digits = (int) (Math.log10(i) + 1);
                // sumOfDigits += digits;
                for(int j = 1; j <= digits; j++) {
                    sumOfDigits++;
                    if(sumOfDigits == k) {
                        System.out.println("The number is " + i / (int)Math.pow(10, digits - j) % 10);
                        break;
                    }
                }
            }
        } else {
            System.out.println("Enter a value between 1 and 222.");
        }
    }
    static void taskTwelve(Scanner scanner) {
        scanner.nextLine();
        System.out.println("List of operations");
        System.out.println("For addition: + or plus");
        System.out.println("For subtraction: - or minus");
        System.out.println("For multiplication: * or mul");
        System.out.println("For division: / or div");
        System.out.println("For remainder: % or mod");
        System.out.print("Choose the operation: ");
        String operation = scanner.nextLine();
        System.out.print("1st number: ");
        double first = scanner.nextDouble();
        System.out.print("2nd number: ");
        double second = scanner.nextDouble();
        double result = 0;
        String f = "Result: %.1f %s %.1f = %.2f";
        switch(operation) {
            case "+":
            case "plus":
                result = first + second;
                operation = "plus";
                break;
            case "-":
            case "minus":
                result = first - second;
                operation = "minus";
                break;
            case "*":
            case "mul":
                result = first * second;
                operation = "mul";
                break;
            case "/":
            case "div":
                result = first / second;
                operation = "div";
                break;
            case "%":
            case "mod":
                result = first % second;
                operation = "mod";
                break;
            default:
                System.out.println("No such operator!");
                first = 0;
                second = 0;
                operation = "###";
                result = 0;
        }
        System.out.println(String.format(f, first, operation, second, result));
    }
}
