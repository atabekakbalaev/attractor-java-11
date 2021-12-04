package com.step04;

public class Product {
    private String id;
    private String name;
    private double price;
    private transient double previousPrice;
    private String honoraryCode;
    private String state;
    private transient State productState;

    public Product(String id, String name, double price, String honoraryCode, String state) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.previousPrice = price;
        this.honoraryCode = honoraryCode;
        this.state = state;
        this.fillState();
    }
    public String getState() {
        return this.state;
    }
    public void startSale() {
        try {
            this.productState.startSale(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void raisePrice() {
        try {
            this.productState.raisePrice(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void withdraw() {
        try {
            this.productState.withdraw(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void giveToTheWinner(){
        try {
            this.productState.giveToTheWinner(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPreviousPrice() {
        return this.previousPrice;
    }
    public String getHonoraryCode() {
        return honoraryCode;
    }

    public void setHonoraryCode(String honoraryCode) {
        this.honoraryCode = honoraryCode;
    }

    public void fillState(){
        if(this.state.equals("in_stock")){
            this.productState = new InStockState();
        }else if(this.state.equals("for_sale")){
            this.productState = new ForSaleState();
        }else {
            this.productState = new SoldState();
        }
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setProductState(State productState) {
        this.productState = productState;
    }

    @Override
    public String toString() {
        return "Product:" +
                "\nid=" + id +
                "\nname=" + name +
                "\nprice=" + price +
                "\nhonoraryCode=" + honoraryCode;
    }
}