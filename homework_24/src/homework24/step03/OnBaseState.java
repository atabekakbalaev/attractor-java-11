package homework24.step03;

public class OnBaseState extends State {
    @Override
    public void changeDriver(Truck truck) throws Exception {
        Driver[] drivers = JsonSerializer.getDrivers();
        boolean aNewDriverIsSet = false;
        for (Driver d : drivers) {
            if (d.isFree()) {
                truck.setDriver(d);
                System.out.printf("Now %s is driving %s.\n", d.getName(), truck.getName());
                aNewDriverIsSet = true;
                break;
            }
        }
        if (!aNewDriverIsSet) throw new Exception("There are no free drivers.");
    }

    @Override
    public void startDriving(Truck truck) throws Exception {
        if (truck.getDriver() == null) {
            throw new Exception("Truck cannot be driven without the driver");
        }
        System.out.println("Truck successfully is on its the way");
        truck.setState("route");
        truck.setTruckState(new OnRouteState());
    }

    @Override
    public void startRepair(Truck truck) throws Exception {
        truck.setState("repair");
        truck.setTruckState(new OnRepairState());
        System.out.printf("%s is now in the repairing process\n", truck.getName());
    }
}
