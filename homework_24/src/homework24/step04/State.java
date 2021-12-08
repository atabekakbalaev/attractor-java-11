package homework24.step04;

public abstract class State {
    public abstract void changeDriver(Truck truck) throws Exception;
    public abstract void startDriving(Truck truck) throws Exception;
    public abstract void startRepair(Truck truck) throws Exception;
}
