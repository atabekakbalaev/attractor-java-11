package step02;

import step01.CheckInput;

import java.util.Scanner;

public class ShapeRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape s;
        System.out.print(
                "1. Parallelepiped\n" +
                "2. Sphere\n" +
                "3. Cylinder\n" +
                "4. Cone\n"
        );
        try {
            int option = CheckInput.getNumberOnly(scanner, "Choose an option(1-4): ");
            if (option < 0 || option > 4) {
                throw new InvalidOptionException("Choose a proper option.");
            }
            switch (option) {
                case 1:
                    int l1 = CheckInput.getNumberOnly(scanner, "Enter length: ");
                    int w1 = CheckInput.getNumberOnly(scanner, "Enter width: ");
                    int h1 = CheckInput.getNumberOnly(scanner, "Enter height: ");
                    s = new Parallelepiped(l1, w1, h1);
                    s.printInfo();
                    break;
                case 2:
                    int r2 = CheckInput.getNumberOnly(scanner, "Enter radius: ");
                    s = new Sphere(r2);
                    s.printInfo();
                    break;
                case 3:
                    int r3 = CheckInput.getNumberOnly(scanner, "Enter radius: ");
                    int h3 = CheckInput.getNumberOnly(scanner, "Enter height: ");
                    s = new Cylinder(r3, h3);
                    s.printInfo();
                case 4:
                    int r4 = CheckInput.getNumberOnly(scanner, "Enter radius: ");
                    int h4 = CheckInput.getNumberOnly(scanner, "Enter height: ");
                    s = new Cone(r4, h4);
                    s.printInfo();
                    break;
            }
        } catch (InvalidOptionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
