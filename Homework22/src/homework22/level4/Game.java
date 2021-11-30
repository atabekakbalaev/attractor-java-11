package homework22.level4;


import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private Hand hand;
    private Deck deck;

    private final String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final char[] suits = {'\u2660', '\u2665', '\u2666', '\u2663'};

    public Game() {
        this.deck = new Deck(suits, values);
        this.hand = new Hand();
    }
    public void distributeCards() {
        this.hand.addCard(deck);
        this.hand.addCard(deck);
        this.hand.addCard(deck);
        this.hand.addCard(deck);
        this.hand.addCard(deck);
    }
    public void displayCardsInHand() {
        this.hand.printHandInfo();
    }
    public void changeHandCards() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter card three numbers(0-4) you want to change: ");
        String[] values = scanner.nextLine().replaceAll("\\D", "").split("");
        System.out.println("There will be " + values.length + " cards changed.");
        for (String value : values) {
            int k = Integer.parseInt(value);
            if (k < 0 || k > 5) {
                System.out.println("Number " + k + " is not within range. Skipping it.");
                continue;
            }
            Card cardInHand = this.hand.getCards()[k];
            if (this.deck.canPutThisCardBackToDeck(cardInHand)) {
                Card c = this.deck.getRandomCard();
                this.deck.putCardToDeck(cardInHand);
                this.hand.replaceCard(k, c);
            }
            System.out.println("-".repeat(10) + value + "-change" + "-".repeat(10));
            this.hand.printHandInfo();
        }
    }
}
