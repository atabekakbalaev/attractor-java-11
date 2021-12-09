package com.example;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Fifi", 5);
        System.out.println("Original name: " + dog.getName());
        changeName(dog);
        System.out.println("Changed name: " + dog.getName());

    }
    public static void changeName(Dog d) {
        d.setName("DD");
        d.setAge(8);
    }
}
