package com.step04;

public class ForSaleState extends State {
    @Override
    public void raisePrice(Product product) throws Exception {
        product.setPrice(100);
        System.out.println("The price for the product has been increased successfully.");
    }

    @Override
    public void startSale(Product product) throws Exception {
        throw new Exception("Error. The product is already on sale now.");
    }

    @Override
    public void giveToTheWinner(Product product) throws Exception {
        if (product.getPrice() == 0) {
            throw new Exception("Error. The product cannot be given for free.");
        } else {
            product.setState("sold");
            product.setProductState(new SoldState());
        }
    }

    @Override
    public void withdraw(Product product) throws Exception {
        if (product.getPrice() == product.getPreviousPrice()) {
            product.setState("in_stock");
            product.setProductState(new InStockState());
        } else {
            throw new Exception("Error. The product is reserved, it should be handed in.");
        }
    }
}
