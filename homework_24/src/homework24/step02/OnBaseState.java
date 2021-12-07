package homework24.step02;

public class OnBaseState extends State {
    @Override
    public void changeDriver(Truck truck) throws Exception {

    }

    @Override
    public void startDriving(Truck truck) throws Exception {
        if (truck.getDriver() == null) {
            throw new Exception("Truck cannot be driven without the driver");
        }
        System.out.println("Truck is on the way");
        truck.setState("route");
        truck.setTruckState(new OnRouteState());
    }

    @Override
    public void startRepair(Truck truck) throws Exception {

    }
}
