package com.company;

public class Truck {
    private int id;
    private String name;
    private Driver driver;
    private String state;
    private transient State truckState;

    public Truck(int id, String name, Driver driver, String state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
        fillState();
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTruckState(State truckState) {
        this.truckState = truckState;
    }

    public Driver getDriver() {
        return driver;
    }

    public void fillState(){
        if(state.equals("base")){
            truckState = new OnBaseState();
        }else if(state.equals("repair")){
            truckState = new OnRepairState();
        }else {
            truckState = new OnRouteState();
        }
    }

    public void changeDriver(){
        try{
            truckState.changeDriver(this);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void startDriving(){
        try{
            truckState.startDriving(this);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void startRepair(){
        try{
            truckState.startRepair(this);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
