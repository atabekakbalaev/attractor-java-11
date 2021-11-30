package homework22.level1;

public class Card {
    private final char suit;
    private final String value;

    public Card(char suits, String value) {
        this.suit = suits;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public char getSuit() {
        return this.suit;
    }

    @Override
    public String toString() {
        return this.value + this.suit;
    }
}
