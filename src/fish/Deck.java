package fish;
import java.util.*;

/**
* Properties of a a deck of cards
* @author Ansor Kasimov
* @version 1.0
*/

public class Deck {

	// ArrayList of cards
	private ArrayList<Card> cards = new ArrayList<Card>();

	// Deck default constructor - generate 52 cards into the deck
	public Deck() {
		cards.ensureCapacity(52);
		initialize();
	}
	
	// Generate 52 cards and stores them into the ArrayList
	private void initialize(){
		for (int i = 0; i < 52; i++) {
			cards.add(new GoFishCard(i));
		}		
	}
	
	// Shuffle the deck of cards
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	* Returns a card from the deck
	* @return a card from the deck
	*/
	public Card deal() {
		if (!cards.isEmpty())
			return cards.remove(0);
		return null;
	}
	
	/**
	* Returns true if the deck is empty
	* @return true if the deck is empty, false otherwise
	*/
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	/**
	* Returns a string representation of the deck
	* @return a string representation of the list of cards in the deck
	*/
	public String toString() {
		return "No. of cards: " + cards.size() +"\n" + cards.toString();
	}

}
