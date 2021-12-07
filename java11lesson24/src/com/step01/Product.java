package com.step01;

public class Product {
    private String id;
    private String name;
    private double price;
    private String honoraryCode;
    private String state;
    private transient State productState;
    public Product(String id, String name, double price, String honoraryCode, String state) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.honoraryCode = honoraryCode;
        this.state = state;
        this.fillState();
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