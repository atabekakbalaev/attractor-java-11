package step01;

import java.util.Calendar;
import java.util.Scanner;

public class EmployeeRunner {
    public static void main(String[] args) {
        Employee employee;
        Scanner scanner = new Scanner(System.in);
        try {
            String firstname = CheckInput.getTextOnly(scanner,"Enter the firstname: ");
            String lastname = CheckInput.getTextOnly(scanner, "Enter the lastname: ");
            int birthYear = CheckInput.getNumberOnly(scanner, "Enter year of birth: ");
            int yearJoined = CheckInput.getNumberOnly(scanner, "Enter year joined: ");


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
}
