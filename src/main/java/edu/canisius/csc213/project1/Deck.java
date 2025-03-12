package edu.canisius.csc213.project1;

import java.util.List;

/**
 * Represents a deck of playing cards with a configurable size.
 */
public class Deck {
    private final List<Card> cards;

    /**
     * Creates a deck with a given size.
     * The size must be a multiple of 4 and at most 52.
     * 
     * @param size The number of cards in the deck.
     * @throws IllegalArgumentException if size is invalid.
     */
    public Deck(int size) {
        // TODO: Validate size (must be a multiple of 4 and at most 52).
        //this is here to show that i changed code to test the commit
        // TODO: Initialize the deck with the correct cards.
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        // TODO: Implement shuffle logic.
    }

    /**
     * Draws the top card from the deck.
     * 
     * @return The drawn card.
     * @throws NoSuchElementException if the deck is empty.
     */
    public Card draw() {
        // TODO: Implement draw logic.
        return null;
    }

    /**
     * Gets the number of remaining cards in the deck.
     *
     * @return The number of cards left.
     */
    public int size() {
        // TODO: Implement size method.
        return 0;
    }
}
