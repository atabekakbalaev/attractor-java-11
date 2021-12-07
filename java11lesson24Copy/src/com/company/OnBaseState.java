package com.company;

public class OnBaseState extends State{
    @Override
    public void changeDriver(Truck truck) throws Exception {

    }

    @Override
    public void startDriving(Truck truck) throws Exception {
        if(truck.getDriver() == null){
            throw new Exception("Грузовик не едет без водителя");
        }
        System.out.println("Грузовик успешно уехал в путь");
        truck.setState("route");
        truck.setTruckState(new OnRouteState());
    }

    @Override
    public void startRepair(Truck truck) throws Exception {

    }
}
