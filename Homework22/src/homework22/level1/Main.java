package homework22.level1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        final char[] suits = {'\u2665', '\u2663', '\u2660', '\u2666'};
        // Hearts, Cloves, Pikes, Tiles
        Card card1 = new Card(suits[0], values[11]);
        Card card2 = new Card(suits[1], values[5]);
        Card card3 = new Card(suits[2], values[12]);
        Card card4 = new Card(suits[3], values[10]);
        Card[] cards = {card1, card2, card3, card4};
        System.out.print(Arrays.toString(cards));
    }

}

