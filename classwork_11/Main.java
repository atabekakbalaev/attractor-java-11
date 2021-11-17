public class Main {
    public static void main(String[] args) {
        String hello = "Hello, I'm Java!";
        System.out.println(hello.length());
        String name = "";
        boolean isEmpty = name.isEmpty();
        if (isEmpty) {
            System.out.println("The name is empty");
        }
    }
}