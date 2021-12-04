package com.step02;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try{
            Product[] products = JsonSerializer.getProducts();
            for (Product p : products) {
                System.out.println(p);
            }
        }catch (IOException ie){
        }
    }
}
