package homework21;

import java.time.LocalDate;

public class Milk extends Product{
    public Milk(String productName, int expiryDateInFridgeDuration, LocalDate producedOn) {
        super(productName, expiryDateInFridgeDuration, producedOn);
    }

    @Override
    public boolean isFresh() {
        int i = this.getStoragePlace().ordinal();
        int duration = switch (StoragePlace.values()[i]) {
            case Icebox -> this.getExpiryDateInFridgeDuration();
            case Showcase -> getExpiryDateInShowcaseDuration();
        };
        return this.getProducedOn().plusDays(duration).isBefore(LocalDate.now());
    }
    @Override
    public int getExpiryDateInShowcaseDuration() {
        return this.getExpiryDateInFridgeDuration() / 2;
    }
}
