
// # 1) Write a program to store a deck of 52 cards in a linked list in random sequence using a Random class 
// # object. You can represent a card as a two-character string—”1C” for the ace of clubs, “JD” for the 
// # jack of diamonds, and so on. Output the cards from the linked list as four hands of 13 cards.
import java.util.*;

public class CollectionFour {
    public static void main(String[] args) {
        // Step 1: Define the suits and ranks
        String[] suits = {"C", "D", "H", "S"}; // Clubs, Diamonds, Hearts, Spades
        String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; // Ace, 2-10, Jack, Queen, King

        // Step 2: Create a list to store the deck of cards
        LinkedList<String> deck = new LinkedList<>();

        // Step 3: Populate the deck with all 52 cards
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + suit); // Card like "1C", "JD", "10H", etc.
            }
        }

        // Step 4: Shuffle the deck using Random class
        Random random = new Random();
        Collections.shuffle(deck, random);

        // Step 5: Distribute the cards into 4 hands (each hand gets 13 cards)
        for (int i = 0; i < 4; i++) {
            hands[i] = new ArrayList<>();
        }

        for (int i = 0; i < deck.size(); i++) {
            hands[i % 4].add(deck.get(i)); // Distribute cards round-robin
        }

        // Step 6: Display the 4 hands of 13 cards each
        for (int i = 0; i < 4; i++) {
            System.out.println("Hand " + (i + 1) + ": " + hands[i]);
        }
    }
}
