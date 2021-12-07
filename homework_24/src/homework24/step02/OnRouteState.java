package homework24.step02;

public class OnRouteState extends State {
    @Override
    public void changeDriver(Truck truck) throws Exception {
        throw new Exception("Driver cannot be changed when the truck is on the way");
    }

    @Override
    public void startDriving(Truck truck) throws Exception {
        throw new Exception("Truck is already on the way, what else do you want?");
    }

    @Override
    public void startRepair(Truck truck) throws Exception {
        System.out.println("The truck is successfully on the way to repair");
        truck.setState("repair");
        truck.setTruckState(new OnRepairState());
    }
}
