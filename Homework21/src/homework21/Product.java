package homework21;

import java.time.LocalDate;

enum StoragePlace {
    Icebox, Showcase
}
public abstract class Product {
    private String productName;
    private final int expiryDateInFridgeDuration;
    private StoragePlace storagePlace;
    private LocalDate producedOn;

    public Product(String productName, int expiryDateInFridgeDuration, LocalDate producedOn) {
        this.productName = productName;
        this.expiryDateInFridgeDuration = expiryDateInFridgeDuration;
        this.producedOn = producedOn;
    }

    public int getExpiryDateInFridgeDuration() {
        return expiryDateInFridgeDuration;
    }

    public LocalDate getProducedOn() {
        return this.producedOn;
    }

    public void setStoragePlace(StoragePlace storagePlace) {
        this.storagePlace = storagePlace;
    }
    public StoragePlace getStoragePlace() {
        return this.storagePlace;
    }

    public abstract boolean isFresh();
    public abstract int getExpiryDateInShowcaseDuration();
}
