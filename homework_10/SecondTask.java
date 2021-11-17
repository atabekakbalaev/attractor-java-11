import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        double discriminant, x1, x2;

        System.out.println("We are solving ax2 + bx + c = 0:");
        System.out.print("Enter a value for a: ");
        a = scanner.nextInt();
        System.out.print("Enter a value for b: ");
        b = scanner.nextInt();
        System.out.print("Enter a value for c: ");
        c = scanner.nextInt();
        
        discriminant = b*b - 4*a*c;
        if (discriminant >= 0) {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("First root: " + x1);
            System.out.println("Second root: " + x2);
        } else {
            System.out.println("There are no real roots.");
        }

        scanner.close();
    }
}