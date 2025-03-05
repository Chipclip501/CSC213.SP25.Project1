import java.util.HashSet;
import java.util.set; 
import java.io.exception;

package edu.canisius.csc213.project1;

/**
 * UniqueHands class to analyze how long it takes to see every possible hand 
 * for different deck sizes and hand sizes.
 */
public class UniqueHands {
    public static void main(String[] args) {
        int[] deckSizes = {24, 28}; // Deck sizes to test
        int[] handSizes = {6, 7}; // Hand sizes to test
        int trials = 5; // Number of trials per deck-hand combination

        System.out.println("🃏 Deck Simulation: How long to see every possible hand?");
        System.out.println("------------------------------------------------------");

        // TODO: Implement nested loops
        // Outer loop: Iterates through deck sizes (24, 28)
        // Inner loop: Iterates through hand sizes (6, 7)
        // Inside inner loop: Run 5 trials, track time and attempts, and compute averages.  Which is probably another loop!

    }

    // TODO: Implement countAttemptsToSeeAllHands()
    // TODO: Implement calculateTotalUniqueHands()
}