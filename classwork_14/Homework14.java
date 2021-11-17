import java.util.Arrays;

public class Homework14 {
    enum Days {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
    public static void main(String[] args) {
        System.out.print("Enter an option for the homework(1-4): ");
        int option = Integer.parseInt(System.console().readLine());
        switch(option) {
            case 1:
                System.out.println(getMax(1, 10, -2));
                System.out.println(getMax(1.1, 10.3, -20.5));
                break;
            case 2:
                int[] array = {1, 5, 10, -7, 8, 11};
                System.out.println(Arrays.toString(array));
                System.out.println(Arrays.toString(taskTwo(array)));
                break;
            case 3:
                int n = 1;
                int i = 0;
                int sum = 0;
                System.out.println("Please enter the numbers. Enter 0 to stop.");
                while (n != 0) {
                    System.out.format("Number %s: ", ++i);
                    n = Integer.parseInt(System.console().readLine());
                    sum += n;
                }
                System.out.format("You have entered %d numbers.\n", i - 1);
                System.out.format("Their sum is %d\n", sum);
                System.out.format("Average of numbers is %.1f\n", (double)sum / (i - 1));
                break;
            case 4:
                String f = "%02d:%02d %s\n";
                System.out.print("Enter a day of the week (1-7): ");
                int day = Integer.parseInt(System.console().readLine());
                Days enumDay = Days.values()[day - 1];
                System.out.println(enumDay.toString().charAt(0) + enumDay.toString().substring(1, enumDay.toString().length()).toLowerCase() + ":");
                switch(enumDay) {
                    case MONDAY:
                        System.out.format(f, 12, 30, "Self study");
                        System.out.format(f, 17, 0, "Shopping");
                        System.out.format(f, 21, 30, "Go to bed");
                        break;
                    case TUESDAY:
                        System.out.format(f, 8, 30, "Work");
                        System.out.format(f, 12, 0, "Meeting");
                        System.out.format(f, 21, 30, "Go to bed");
                        break;
                    case WEDNESDAY:
                        System.out.format(f, 8, 30, "Office");
                        System.out.format(f, 16, 30, "Training");
                        break;
                    case THURSDAY:
                        System.out.format(f, 9, 0, "Library");
                        System.out.format(f, 12, 0, "Doctor's Meeting");
                        System.out.format(f, 20, 30, "Return from parent's");
                        break;
                    case FRIDAY:
                        System.out.format(f, 8, 30, "Office");
                        System.out.format(f, 12, 20, "Meeting");
                        System.out.format(f, 18, 30, "Training");
                        break;
                    case SATURDAY:
                        System.out.format(f, 10, 30, "Coffee shop");
                        System.out.format(f, 13, 0, "Sleep");
                        System.out.format(f, 18, 30, "Running");
                        break;
                    case SUNDAY:
                        System.out.format(f, 8, 30, "Go to gym");
                        System.out.format(f, 12, 0, "Preparation for work");
                        System.out.format(f, 20, 30, "Shower");
                        break;
                    default:
                        System.out.println("Enter a day between 1 to 7.");
                    
                }
                break;
            default:
                System.out.println("Enter a homework number between 1 and 5.");
        }
    }
    static int[] taskTwo(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copy.length; i++) {
            copy[i] = - copy[i];
        }
        return copy;
    }
    static int getMax(int a, int b, int c) {
        return max(max(a, b), c);
    }
    static double getMax(double a, double b, double c) {
        return max(max(a, b), c);
    }
    static double max(double a, double b) {
        return a > b ? a : b;
    }
    static int max(int a, int b) {
        return a > b ? a : b;
    }
}