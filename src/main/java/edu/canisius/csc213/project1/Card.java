package edu.canisius.csc213.project1;

/**
 * Represents a playing card with a suit and rank.
 */
public class Card {

    public enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }
    public enum Rank { 
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, 
        JACK, QUEEN, KING, ACE 
    }

    // TODO: Define private fields for suit and rank.
    private final Suit suit;
    private final Rank rank;
    // TODO: Implement the constructor.
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    // TODO: Implement getters for suit and rank.
    public Suit getSuit() {
        return suit;
    }
    public Rank getRank() {
        return rank;
    }
    // TODO: Override toString() to return a readable format.
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    // TODO: Override equals() and hashCode() for comparisons.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card card = (Card) obj;
        return suit == card.suit && rank == card.rank;
    }
    @Override
    public int hashCode() {
        return suit.hashCode() + rank.hashCode();
    }
}