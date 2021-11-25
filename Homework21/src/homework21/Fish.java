package homework21;

import java.time.LocalDate;

public class Fish extends Product {
    public Fish(String productName, int expiryDateInFridgeDuration, LocalDate producedOn) {
        super(productName, expiryDateInFridgeDuration, producedOn);

    }

    @Override
    public boolean isFresh() {
        int i = this.getStoragePlace().ordinal();
        int duration = 0;
        switch (StoragePlace.values()[i]) {
            case Icebox:
                duration = this.getExpiryDateInFridgeDuration();
                break;
            case Showcase:
                duration = (int) this.getExpiryDateInFridgeDuration() / 6;
                break;
        }
        return this.getProducedOn().plusDays(duration).isBefore(LocalDate.now()) ? true : false;
    }
}
