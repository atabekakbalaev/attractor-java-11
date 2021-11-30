package homework22.level3;

public class Main {

    public static void main(String[] args) {
        final String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        final char[] suits = {'\u2660', '\u2665', '\u2666', '\u2663'};

        Deck deck = new Deck(suits, values);
        System.out.println("The initial state of the deck:");
        deck.printDeck();
        printDivider();

        System.out.println("The state of the deck after shuffling:");
        deck.shuffle();
        deck.printDeck();
        printDivider();

        // create hand
        Hand hand = new Hand();
        // add cards to hand
        hand.addCard(deck);
        hand.addCard(deck);
        hand.addCard(deck);
        hand.addCard(deck);
        hand.addCard(deck);
        // print hand cards
        hand.handInfo();

        printDivider();

        // replace 2nd card in the hand with a random card from the deck
        Card c = deck.getRandomCard();
        hand.replaceCard(1, c);
        hand.handInfo();

    }

    public static void printDivider() {
        System.out.println("-".repeat(100));
    }
}
