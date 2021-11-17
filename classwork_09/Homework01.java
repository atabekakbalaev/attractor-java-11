public class Homework01 {
    public static void main(String[] args) {
        System.out.print("hello, I'm Java");
        System.out.print(" And\nyou? I'm ");
        String name = System.console().readLine();
        System.out.print("And I'm, ");
        String age = System.console().readLine();
        System.out.println("Hello, " + name + ", who is " + age + " years old!");
    }
}