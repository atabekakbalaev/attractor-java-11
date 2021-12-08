package homework24.step03;

import java.util.Random;

public class OnRepairState extends State {
    @Override
    public void changeDriver(Truck truck) throws Exception {
        throw new Exception(truck.getName() + " cannot change its driver, because it is being repaired");
    }

    @Override
    public void startDriving(Truck truck) throws Exception {
        if (new Random().nextInt(2) == 0) {
            truck.setState("route");
            truck.setTruckState(new OnRouteState());
            System.out.printf("%s is now on the route after being repaired");
        } else {
            truck.setState("base");
            truck.setTruckState(new OnBaseState());
            System.out.printf("%s is now in the base after being repaired");
        }
    }

    @Override
    public void startRepair(Truck truck) throws Exception {
        throw new Exception("Already in this process of repairing");
    }
}
