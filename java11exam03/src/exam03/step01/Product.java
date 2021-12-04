package exam03.step01;

public class Product {
    private String id;
    private String name;
    private double price;
    private String honoraryCode;
    private String state;
    private transient State productState;
    public Product(String id, String name, double price, String honoraryCode, String state) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.honoraryCode = honoraryCode;
        this.state = state;
        this.fillState();
    }
    public void startSale() {}
    public void raisePrice(double amount) {
        this.price += amount;
    }
    public void withdraw() {}
    public void giveToTheWinner(){}

    public void fillState(){
        if(state.equals("inStock")){
            this.productState = new InStock();
        }else if(state.equals("forSale")){
            this.productState = new ForSale();
        }else {
            this.productState = new Sold();
        }
    }
}
