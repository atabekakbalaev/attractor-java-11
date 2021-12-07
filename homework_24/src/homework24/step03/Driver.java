package homework24.step03;

public class Driver {
    private String id;
    private String name;
    private boolean isFree;

    public Driver(String id, String name, boolean isFree) {
        this.id = id;
        this.name = name;
        this.isFree = isFree;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isFree() {
        return isFree;
    }
}
