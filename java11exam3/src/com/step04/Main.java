package com.step04;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try{
            JsonSerializer jsonSerializer = new JsonSerializer("Products.json");
            Product[] products = jsonSerializer.getGoods();
            actionListMenu(scanner, products);

        } catch (IOException ie){
            System.out.println(ie.getMessage());
        }
        scanner.close();
    }
    public static void actionListMenu(Scanner scanner, Product[] products) {
        String f = "%3s |%6s| %-1s\n";
        int option = 1;
        while(true) {
            System.out.format(f, "#", "ID", "name");
            System.out.println("-".repeat(30));
            for (int i = 0; i < products.length; i++) {
                System.out.format(f, i + 1, products[i].getId(), products[i].getName());
            }
            option = CheckInput.getNumberOnly(scanner, "Choose a product (Enter in the order number): ");
            if (option > 0 && option < products.length + 1) {
                while(true) {
                    productListMenu(scanner, products, option - 1);
                }
            }
        }
    }

    public static void productListMenu(Scanner scanner, Product[] products, int i) {
        int option;
        System.out.println("=".repeat(50));
        String f = "%3s |%6s | %10s | %8s | %15s |\n";

        System.out.format(f, "ID", "name", "State", "Price", "Code");
        for(Product p : products) {
            System.out.format(f, p.getId(), p.getName(), p.getState(), p.getPrice(), p.getHonoraryCode());
        }

        System.out.println("=".repeat(50));
        System.out.format(f, "ID", "name", "State", "Price", "Code");
        System.out.format(f,products[i].getId(), products[i].getName(), products[i].getState(),
                            products[i].getPrice(), products[i].getHonoraryCode());

        System.out.print(
                "\n1. Put on an auction" +
                        "\n2. Raise the price" +
                        "\n3. Give it to the winner" +
                        "\n4. Withdraw from sale" +
                        "\n5. Show product information" +
                        "\n6. Get back to products list\n"
        );
        option = CheckInput.getNumberOnly(scanner, "Choose an option from the menu: ");
        if (option > 0 && option < 7) {
            switch (option) {
                case 1:
                    products[option - 1].startSale();
                    break;
                case 2:
                    products[option - 1].raisePrice();
                    break;
                case 3:
                    products[option - 1].giveToTheWinner();
                    break;
                case 4:
                    products[option - 1].withdraw();
                    break;
                case 5:
                    productListMenu(scanner, products, i);
                    break;
                case 6:
                    actionListMenu(scanner, products);
                    break;
            }
        }
    }
}
