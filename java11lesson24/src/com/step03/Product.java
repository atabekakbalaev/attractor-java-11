package com.step03;

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
    public void startSale() {}
    public void raisePrice(double amount) {
        this.price += amount;
    }
    public void withdraw() {}
    public void giveToTheWinner(){}

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
        if(state.equals("inStock")){
            this.productState = new InStockState();
        }else if(state.equals("forSale")){
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


//    public void fillState(){
//        if(state.equals("base")){
//            truckState = new OnBaseState();
//        }else if(state.equals("repair")){
//            truckState = new OnRepairState();
//        }else {
//            truckState = new OnRouteState();
//        }
//    }
//
//    public void changeDriver(){
//        try{
//            truckState.changeDriver(this);
//        }
//        catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//    public void startDriving(){
//        try{
//            truckState.startDriving(this);
//        }
//        catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//    public void startRepair(){
//        try{
//            truckState.startRepair(this);
//        }
//        catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }