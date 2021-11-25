package homework21;

import java.time.LocalDate;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Product[] products = getFilledProducts(new Product[20]);
        doInspection(products);
    }

    static Product[] getFilledProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            int choice = new Random().nextInt(5);
            Product p = null;
            switch (choice) {
                case 0:
                    p = new Milk(Milk.class.getSimpleName(), 60, getRandomDate());
                    break;
                case 1:
                    p = new Salt(Salt.class.getSimpleName(), 0, getRandomDate());
                    break;
                case 2:
                    p = new Fish(Fish.class.getSimpleName(), 20, getRandomDate());
                    break;
                case 3:
                    p = new Corn(Corn.class.getSimpleName(), 150, getRandomDate());
                    break;
                case 4:
                    p = new Stew(Stew.class.getSimpleName(), 180, getRandomDate());
                    break;
            }
            products[i] = p;
        }
        return products;
    }

    static LocalDate getRandomDate() {
        int day = new Random().nextInt(200) + 1;
        LocalDate producedOn = LocalDate.now().minusDays(day);
        return producedOn;
    }

    static void doInspection(Product[] products) {
        for(Product p : products) {
            System.out.println(p);
        }
        System.out.printf("There are %d products in the store\n", products.length);
    }
}
