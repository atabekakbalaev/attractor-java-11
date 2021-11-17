import java.util.Random;
import java.util.Arrays;

public class Homework15 {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.print("Enter an option for the homework(0-5): ");
        int option = Integer.parseInt(System.console().readLine());
        switch(option) {
            case 0:
                int a = random.nextInt(10) + 1;
                System.out.println("Side a: " + a);
                int b = random.nextInt(10) + 1;
                System.out.println("Side b: " + b);
                int c = random.nextInt(10) + 1;
                System.out.println("Side c: " + c);
                int x = random.nextInt(10) + 1;
                System.out.println("Side x: " + x);
                int y = random.nextInt(10) + 1;
                System.out.println("Side y: " + y);
                boolean status = willFit(a, b, c, x, y) || willFit(a, c, b, x, y) || willFit(b, a, c, x, y) || willFit(b, c, a, x, y) || willFit(c, a, b, x, y) || willFit(c, b, a, x, y);
                String result = status ? "Will fit" : "Will not fit";
                System.out.println(result);
                break;
            case 1:
                a = 47;
                b = 43;
                for (int i = 100; i <= 999; i++) {
                    if (i % a == b) {
                        System.out.printf("When %d is divided by %d, the remainder is %d\n", i, a, b);
                    }
                    if (i % b == a) {
                        System.out.printf("When %d is divided by %d, the remainder is %d\n", i, a, b);
                    }
                }
                break;
            case 2:
                int length = 10;
                int[] numbers = new int[length];
                int sum = 0;
                String output = "[ ";
                String[] sumText = new String[length/2];
                for (int i = 0; i < length; i++) {
                    numbers[i] = random.nextInt(90) + 10;
                    if(i % 2 == 0) {
                        output += numbers[i] + "; ";
                        sum += numbers[i];
                        sumText[i/2] = Integer.toString(numbers[i]);
                    }
                }
                output += "]";
                System.out.println(output);
                System.out.println(String.join(" + ", sumText) + " = " + sum);
                break;
            case 3:
                int n = random.nextInt(300) + 1;
                System.out.printf("Factors till %d:\n", n);
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                    int count = factors(i);
                    for (int j = 0; j < count; j++) {
                        System.out.print("+");
                    }
                    System.out.println();
                }
                break;
            case 4:
                System.out.print("Enter the direction(N, E, W, S): ");
                String direction = System.console().readLine();
                System.out.print("Enter the commands(-1, 0, 1): ");
                String text = System.console().readLine();
                String[] textCommands = text.split(" ");
                int[] commands = new int[textCommands.length];
                for (int i = 0; i < textCommands.length; i++) {
                    commands[i] = Integer.parseInt(textCommands[i]);
                }

                break;
            case 5:
                int size = random.nextInt(9) + 2;
                int[][] array = new int[size][size];
                for (int i = 0; i < size; i++) {
                    array[i][0] = 1;
                    array[0][i] = 1;
                }
                for (int i = 1; i < size; i++) {
                    for (int j = 1; j < size; j++) {
                        array[i][j] = array[i - 1][j] + array[i][j - 1];
                    }
                }
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.format("%6d", array[i][j]);
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Please enter option between 0 and 5 inclusive.");
        }
    }
    static boolean willFit(int a, int b, int c, int x, int y) {
        return a <= x && b <= y;
    }
    static int factors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }
}