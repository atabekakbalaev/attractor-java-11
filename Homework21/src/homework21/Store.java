package homework21;

import java.util.Random;

public class Store {
    private Product[] products;

    public void setProducts(Product[] products) {
        this.products = products;
    }
    public Product[] getProducts() {
        return this.products;
    }
    public void placeProduct(Product product) {
        StoragePlace storagePlace = new Random().nextInt(2) == 0 ?
                StoragePlace.Icebox : StoragePlace.Showcase;
        product.setStoragePlace(storagePlace);
    }
}
