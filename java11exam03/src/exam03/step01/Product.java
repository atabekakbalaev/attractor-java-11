package exam03.step01;

public class Product {
    private String id;
    private String name;
    private double price;
    private String honoraryCode;
    private State state;
    public Product(String id, String name, double price, String honoraryCode, State state) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.honoraryCode = honoraryCode;
        this.state = state;
    }
    public void startSale() {

    }
    public void raisePrice(double amount) {

    }
    public void withdraw() {}
    public void giveToTheWinner(){}
}
