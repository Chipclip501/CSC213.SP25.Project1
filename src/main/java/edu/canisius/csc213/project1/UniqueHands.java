package edu.canisius.csc213.project1;
import java.util.HashSet;
import java.util.Set;
import java.io.FileOutputStream;
import java.io.IOException;



/**
 * UniqueHands class to analyze how long it takes to see every possible hand 
 * for different deck sizes and hand sizes.
 */
public class UniqueHands {
    private static String csvFile = "unique_hands_results.csv";
    public static void main(String[] args) {
        int[] deckSizes = {24, 28}; // Deck sizes to test
        int[] handSizes = {6, 7}; // Hand sizes to test
        int trials = 5; // Number of trials per deck-hand combination

        System.out.println("🃏 Deck Simulation: How long to see every possible hand?");
        System.out.println("------------------------------------------------------");

        // TODO: Implement nested loops
        try (FileOutputStream outputStream = new FileOutputStream(csvFile)) {
            String header = "Deck Size\tHand Size\tTrial\tAttempts\tTime (sec)\n";
            outputStream.write(header.getBytes());

        for (int deckSize : deckSizes) {
            for (int handSize : handSizes) {
                for (int trial = 1; trial <= trials; trial++) {
                    long startTime = System.nanoTime();

                    int attempts = countAttemptsToSeeAllHands(deckSize, handSize);


                    long endTime = System.nanoTime();

                    double timeInSeconds = (endTime - startTime) / 1000000000.0;
                    String result = String.format("%d\t%d\t%d\t%d\t%.6f\n",
                                deckSize, handSize, trial, attempts, timeInSeconds);
                        outputStream.write(result.getBytes());
                }
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Outer loop: Iterates through deck sizes (24, 28)
        // Inner loop: Iterates through hand sizes (6, 7)
        // Inside inner loop: Run 5 trials, track time and attempts, and compute averages.  Which is probably another loop!

    }

    // TODO: Implement countAttemptsToSeeAllHands()
    public static int countAttemptsToSeeAllHands(int deckSize, int handSize) {
        Deck deck = new Deck(deckSize);
        deck.shuffle();
        HashSet<HashSet<Card>> uniqueHands = new HashSet<>();
        int attempts = 0;

        while (uniqueHands.size() < calculateTotalUniqueHands(deckSize, handSize)) {
            HashSet<Card> hand = new HashSet<>();
            while (hand.size() < handSize) {
                hand.add(deck.draw());
            }
            uniqueHands.add(hand);
            attempts++;
        }

        return attempts;

    }
    // TODO: Implement calculateTotalUniqueHands()
    public static int calculateTotalUniqueHands(int deckSize, int handSize) {
        return  factorial(deckSize) / (factorial(handSize) * factorial(deckSize - handSize));
    }
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}