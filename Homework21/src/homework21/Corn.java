package homework21;

import java.time.LocalDate;

public class Corn extends Product {

    public Corn(String productName, int expiryDateInFridgeDuration, LocalDate producedOn) {
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
                return true;
        }
        return this.getProducedOn().plusDays(duration).isBefore(LocalDate.now()) ? true : false;
    }
}
