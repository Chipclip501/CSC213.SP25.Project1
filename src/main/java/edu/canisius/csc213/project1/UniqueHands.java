package edu.canisius.csc213.project1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;



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

                    System.out.printf("Deck Size: %d | Hand Size: %d | Trial %d | Attempts: %d | time %.6f", deckSize, handSize, trial, attempts, timeInSeconds);
                    System.out.println();
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
    Set<String> UniqueHands = new HashSet<>();
    int attempts = 0;
    int totalUniqueHands = calculateTotalUniqueHands(deckSize, handSize);
    while (UniqueHands.size() < totalUniqueHands) {
        Deck deck = new Deck(deckSize);
        deck.shuffle();
        List<Card> hand = new ArrayList<>();
        for(int i =0; i < handSize; i++){
            hand.add(deck.draw());
        }
        String sortedHand = sortHand(hand);// needs to be sorted so its not in random order, how will it know if the elements are unique or not
        UniqueHands.add(sortedHand);
        attempts++;
        if (attempts % 100000 == 0) {
            int needed = totalUniqueHands - UniqueHands.size();
            double progress = (100.0 * UniqueHands.size())/totalUniqueHands;
            System.out.printf("Progress: %.3f%% coverage after %,d attempts (Unique Hands: %,d / %,d | Needed: %,d)",
            progress, attempts, UniqueHands.size(), totalUniqueHands, needed);
            System.out.println();
        }
    }

return attempts;
    }
    // TODO: Implement calculateTotalUniqueHands()
    public static int calculateTotalUniqueHands(int deckSize, int handSize) { // n is deck and k is hand like in the formula
        if(handSize > deckSize){return -1;}
        BigInteger kFact = factorial(handSize);
        BigInteger nFact = factorial(deckSize);
        BigInteger nMinusKFact = factorial( deckSize - handSize);


        return nFact.divide(kFact.multiply(nMinusKFact)).intValue();
       
    }
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));  

        }
        return result;
    }
private static String sortHand(List<Card> hand) {
    
    hand.sort(new Comparator<Card>() {
        @Override
        public int compare(Card card1, Card card2) {
            // First comparing ranks, if equal then comparing suits.
            int rankComparison = card1.getRank().compareTo(card2.getRank());
            if (rankComparison != 0) {
                return rankComparison;
            }
            return card1.getSuit().compareTo(card2.getSuit());
        }
    });

    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < hand.size(); i++) {
        sb.append(hand.get(i).toString());
        if (i < hand.size() - 1) {
            sb.append(";");
        }
    }
    return sb.toString();
}
}