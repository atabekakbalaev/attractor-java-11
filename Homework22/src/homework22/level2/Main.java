package homework22.level2;

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

        System.out.println("A random card is taken from the deck.");
        Card random_card = deck.getRandomCard();
        System.out.println("The random card is: " + random_card);
        System.out.println("Is the card in the deck now? " + deck.checkIfCardExists(random_card));
        System.out.println("Empty card index is: " + deck.getEmptyCardIndex());
        deck.printDeck();
        printDivider();

        System.out.println("Can I get " + random_card + " from deck again? " + deck.canTakeThisCardFromDeck(random_card));
        printDivider();

        // Testing if a specific card can be put back to the deck if it exists in the deck
        Card c = new Card(suits[0], values[0]);
        deck.putCardToDeck(c);

        printDivider();
        System.out.println("Can I put " + random_card + " to deck? " + deck.canPutThisCardBackToDeck(random_card));

    }

    public static void printDivider() {
        System.out.println("-".repeat(100));
    }

}
