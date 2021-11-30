package attractor_hw22.level4;

public class Hand {
	private final int hand = 5;
	private Card[] cards = new Card[5];
	public Hand() {
		this.cards[0] = new Card();
		this.cards[1] = new Card();
		this.cards[2] = new Card();
		this.cards[3] = new Card();
		this.cards[4] = new Card();
	}
	
	public void replaceCard(int i, Card c) {
		this.cards[Math.abs(i)%5] = c;
	}
	public void addCard(Deck deck) {
		Card c = deck.getRandomCard();
		if (!handIsFull()) {
			int i = this.getEmptyHandIndex();
			this.cards[i] = c;
		}
		
	}
	public Card[] getCards() {
		return this.cards;
	}
	public boolean handIsFull() {
		for (Card c : this.cards) {
			if (c.toString().equals((new Card()).toString())) {
				return false;
			}
		}
		return true;
	}
	public int getEmptyHandIndex() {
		for (int i = 0; i < this.cards.length; i++) {
			if (this.cards[i].toString().equals((new Card()).toString())) {
				return i;
			}
		}
		return -1;
	}
	public void handInfo() {
		String s = "%4s |".repeat(4) + "%4s\n";
		System.out.printf(s, 0, 1, 2, 3, 4);	
		System.out.printf(s, cards[0], cards[1], cards[2], cards[3], cards[4]);		
	}
}
