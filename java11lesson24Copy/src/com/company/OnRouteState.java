package com.company;

public class OnRouteState extends State{
    @Override
    public void changeDriver(Truck truck) throws Exception {
        throw new Exception("Водителю на ходу из кабины выпрыгивать?!");
    }

    @Override
    public void startDriving(Truck truck) throws Exception {
        throw new Exception("Грузовик уже в пути, что ты ещё хочешь?");
    }

    @Override
    public void startRepair(Truck truck) throws Exception {
        System.out.println("Грузовик успешно уехал на ремонт");
        truck.setState("repair");
        truck.setTruckState(new OnRepairState());
    }
}
