package com.step04;

import java.util.Scanner;

public class CheckInput {
    public static int getNumberOnly(Scanner scanner, String txt) {
        String n = "";
        try {
            System.out.print(txt);
            n = scanner.nextLine();
            if (n.equals("")) {
                throw new Exception("Enter a number, not an empty text.");
            }
            if (!isNumeric(n)) {
                throw new NumberFormatException("Enter a numeric value, not text");
            } else {
                int number = Integer.parseInt(n);
                if (number < 0) {
                    throw new Exception("Number should be positive.");
                }
                return number;
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0; // should not reach this line
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
