package homework22.level3;

public class Card {
    private char suit;
    private String value;

    // empty card constructor
    public Card() {
        this.suit = '_';
        this.value = "0";
    }
    // real card constructor
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
