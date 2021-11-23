package step.two;

public class Tram extends GroundVehicle{
    private int numberOfSeats;
    private int routeNumber;

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public Tram(String name) {
        super(name);
    }
}
