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
            Product p = switch (choice) {
                case 0 -> new Milk(Milk.class.getSimpleName(), 60, getRandomDate());
                case 1 -> new Salt(Salt.class.getSimpleName(), 0, getRandomDate());
                case 2 -> new Fish(Fish.class.getSimpleName(), 20, getRandomDate());
                case 3 -> new Corn(Corn.class.getSimpleName(), 150, getRandomDate());
                case 4 -> new Stew(Stew.class.getSimpleName(), 180, getRandomDate());
                default -> null;
            };
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
