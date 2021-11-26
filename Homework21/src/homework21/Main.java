package homework21;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        store = getFilledProducts(new Product[20], store);
        doInspection(store);
    }

    static Store getFilledProducts(Product[] products, Store store) {
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
            store.placeProduct(products[i]);
        }
        store.setProducts(products);
        return store;
    }

    static LocalDate getRandomDate() {
        int day = new Random().nextInt(200) + 1;
        return LocalDate.now().minusDays(day);
    }

    static void doInspection(Store store) {
        String divider = "-".repeat(8) + "+" + ("-".repeat(16) + "+").repeat(4);
        String productLineFormat = "%8s|%16s|%16s|%16s|%16s%n";
        System.out.format(productLineFormat, "Product", "Produced on", "Storage place", "S. life days", "Fresh");
        System.out.println(divider);

        for(Product p : store.getProducts()) {
            int duration;
            if (p.getStoragePlace() == StoragePlace.Icebox) {
                duration = p.getExpiryDateInFridgeDuration();
            } else {
                duration = p.getExpiryDateInShowcaseDuration();
            }

            String s = duration > 0 ? Integer.toString(duration) : "INF";
            System.out.format(productLineFormat, p.getClass().getSimpleName(),  DateTimeFormatter.ofLocalizedDate(
                    FormatStyle.MEDIUM).format(p.getProducedOn()),
                    p.getStoragePlace().toString(), s, p.isFresh());
        }
    }
}
