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

    public void canPlaceProduct(Product product) {
        int index = this.getFirstNullIndex();
        if (index != -1) {
            this.products[index] = product;
        } else {
            System.out.println("The Store is full. Cannot add anymore products.");
        }
    }
    private int getFirstNullIndex() {
        for(int i = 0; i <= this.products.length; i++) {
            if (this.products[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
