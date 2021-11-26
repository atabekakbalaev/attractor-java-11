package homework21;

import java.time.LocalDate;

public class Salt extends Product {
    public Salt(String productName, int expiryDateInFridgeDuration, LocalDate producedOn) {
        super(productName, expiryDateInFridgeDuration, producedOn);

    }

    @Override
    public boolean isFresh() {
        return true;
    }

    @Override
    public int getExpiryDateInShowcaseDuration() {
        return 0;
    }
}
