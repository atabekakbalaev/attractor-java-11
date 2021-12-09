package com.step04;

public class SoldState extends State {
    @Override
    public void raisePrice(Product product) throws Exception {
        throw new Exception("Error. The product price cannot raised because it is already sold.");
    }

    @Override
    public void startSale(Product product) throws Exception {
        throw new Exception("Error. The product cannot sold again because it is already sold.");
    }

    @Override
    public void giveToTheWinner(Product product) throws Exception {
        throw new Exception("Error. The product can not be handed in because it is already handed in to the buyer.");
    }

    @Override
    public void withdraw(Product product) throws Exception {
        throw new Exception("The product cannot withdraw because because it is already sold.");
    }
}
