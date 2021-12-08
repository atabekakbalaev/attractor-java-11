package homework24.step01;

public class Truck {
    private String id;
    private String name;
    private Driver driver;
    private String state;
    private transient State truckState;

    public Truck(String id, String name, Driver driver, String state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
        this.fillState();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTruckState(State truckState) {
        this.truckState = truckState;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }

    public void changeDriver() {
        try {
            this.truckState.changeDriver(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void startDriving() {
        try {
            this.truckState.startDriving(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void startRepair() {
        try {
            this.truckState.startRepair(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void fillState() {
        if (this.state.equals("base")) {
            this.truckState = new OnBaseState();
        } else if (this.state.equals("repair")) {
            this.truckState = new OnRepairState();
        } else {
            this.truckState = new OnRouteState();
        }
    }
}
