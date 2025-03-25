package edu.canisius.csc213.project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Represents a deck of playing cards with a configurable size.
 */
public class Deck {
    private final List<Card> cards = new ArrayList<>();

    /**
     * Creates a deck with a given size.
     * The size must be a multiple of 4 and at most 52.
     * 
     * @param size The number of cards in the deck.
     * @throws IllegalArgumentException if size is invalid.
     */
    public Deck(int size) {
        // TODO: Validate size (must be a multiple of 4 and at most 52).
        if(size % 4 != 0 || size > 52 || size < 4){
            throw new IllegalArgumentException("Deck size must be a multiple of 4 and at most 52.");
        }
        // TODO: Initialize the deck with the correct cards.
        Card.Rank[] ranks = Card.Rank.values();
        int rankIndex = ranks.length - 1; // Start from aces to king queen jack 10 9 ...

        while (cards.size() < size) {
            for (Card.Suit suit : Card.Suit.values()) {
                if (cards.size() < size) {
                    cards.add(new Card(suit, ranks[rankIndex]));
                }
            }
            rankIndex--; 
        }
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        // TODO: Implement shuffle logic.
        Collections.shuffle(cards);
    }

    /**
     * Draws the top card from the deck.
     * 
     * @return The drawn card.
     * @throws NoSuchElementException if the deck is empty.
     */
    public Card draw() {
        // TODO: Implement draw logic.
        if (cards.isEmpty()){
            throw new NoSuchElementException("Deck is empty");
        }
        return cards.remove(0);
    }

    /**
     * Gets the number of remaining cards in the deck.
     *
     * @return The number of cards left.
     */
    public int size() {
        // TODO: Implement size method.
        return cards.size();
    }
}
