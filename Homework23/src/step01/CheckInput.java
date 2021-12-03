package step01;

import java.util.Scanner;

public class CheckInput {
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
                int number = Integer.parseInt(n);
                if (number < 0) {
                    throw new NegativeNumberException("Number should be positive.");
                }
                return number;
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
