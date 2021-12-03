package step01;

import java.util.Calendar;
import java.util.Scanner;

public class EmployeeRunner {
    public static void main(String[] args) {
        Employee employee;
        Scanner scanner = new Scanner(System.in);
        try {
            String firstname = getTextOnly(scanner,"Enter the firstname: ");
            String lastname = getTextOnly(scanner, "Enter the lastname: ");
            int birthYear = getNumberOnly(scanner, "Enter year of birth: ");
            int yearJoined = getNumberOnly(scanner, "Enter year joined: ");


            int year = Calendar.getInstance().get(Calendar.YEAR);
            if (year < birthYear || year < yearJoined || birthYear > yearJoined) {
                throw new InvalidYearException("The date cannot be earlier than ");
            }
            if (yearJoined - birthYear < 18) {
                throw new InvalidYearException("The employee should be 18 years old to start working.");
            }
            employee = new Employee(firstname, lastname, birthYear, yearJoined);
            System.out.println(employee.getFullInfo());
        } catch (InvalidYearException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
    public static int getNumberOnly(Scanner scanner, String txt) {
        String n = "";
        try {
            System.out.print(txt);
            n = scanner.nextLine();
            if (n.equals("")) {
                throw new NullOrEmptyTextException("Enter a number, not an empty text.");
            }
            if (!isNumeric(n)) {
                throw new NumberFormatException("Enter a numeric value, not text");
            } else {
                return Integer.parseInt(n);
            }
        } catch (NullOrEmptyTextException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // should not reach this line
    }

    public static String getTextOnly(Scanner scanner, String txt) {
        String str = "";
        try {
            System.out.print(txt);
            str = scanner.nextLine();
            if (str.equals(null) || str.equals("")) {
                throw new NullOrEmptyTextException("The input should not be empty or null.");
            }
            if (isNumeric(str)) {
                throw new NumberFormatException("The input should be a text.");
            }
            return str;
        } catch (NullOrEmptyTextException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
