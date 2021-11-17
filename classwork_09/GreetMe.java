public class GreetMe {
    public static void main(String[] args) {
        System.out.println("hello, I'm Java");
        System.out.println("And you?");
        String name = System.console().readLine();
        System.out.println("Hello, " + name + "!");
    }
}