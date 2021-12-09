package com.step05;

public class InStockState extends State {
    @Override
    public void raisePrice(Product product) throws Exception {
        throw new Exception("Error. The price for this product can not be raised, its not for sale now.");
    }

    @Override
    public void startSale(Product product) throws Exception {
        product.setState("for_sale");
        product.setProductState(new ForSaleState());
        System.out.println("The product - " + product.getName() + " is successfully FOR SALE now.");
    }

    @Override
    public void giveToTheWinner(Product product) throws Exception {
        throw new Exception("Error. This product can not be sold because it is in stock now.");
    }

    @Override
    public void withdraw(Product product) throws Exception {
        throw new Exception("Error. This product can not be withdrawn because it is already in stock now.");
    }
}