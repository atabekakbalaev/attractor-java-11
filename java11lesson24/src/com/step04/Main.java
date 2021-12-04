package com.step04;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JsonSerializer jsonSerializer = new JsonSerializer("Products.json");
        Scanner scanner = new Scanner(System.in);
        try{
            Product[] products = jsonSerializer.getGoods();
            String f = "%3s |%6s| %-1s\n";
            System.out.format(f, "#", "ID", "name");
            System.out.println("-".repeat(30));
            for (int i = 0; i < products.length; i++) {
                System.out.format(f, i + 1, products[i].getId(), products[i].getName());
            }
//            int option =
        } catch (IOException ie){
            System.out.println(ie.getMessage());
        }
    }
}
