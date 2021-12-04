package com.step03;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        JsonSerializer jsonSerializer = new JsonSerializer("Products.json");
        try{
            Product[] products = jsonSerializer.getGoods();
            for (Product p : products) {
                System.out.println(p);
            }
        }catch (IOException ie){
        }
    }
}
