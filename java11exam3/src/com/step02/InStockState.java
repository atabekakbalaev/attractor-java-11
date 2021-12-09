package com.step02;

public class InStockState extends State{
    @Override
    public void raisePrice(Product product) throws CustomException {
        throw new CustomException("The price for this product con not be raised, its not for sale now.");
    }

    @Override
    public void startSale(Product product) throws Exception {
        product.startSale();
        product.setState("for_sale");
        product.setProductState(new ForSaleState());
        System.out.println(
                product + "FOR SALE"
        );
    }

    @Override
    public void giveToTheWinner(Product product) throws Exception {
        throw new CustomException("This product con not be sold because it is in stock now.");
    }

    @Override
    public void withdraw(Product product) throws Exception {
        throw new CustomException("This product con not be withdrawn because it is already in stock now.");
    }
}