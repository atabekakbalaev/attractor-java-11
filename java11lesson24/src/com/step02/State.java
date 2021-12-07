package com.step02;

public abstract class State {
    public abstract void raisePrice(Product product) throws Exception;
    public abstract void startSale(Product product) throws Exception;
    public abstract void giveToTheWinner(Product product) throws Exception;
    public abstract void withdraw(Product product) throws Exception;
}
