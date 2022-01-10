package goFish;
import java.util.*;

/**
* Properties of a Deck of GoFishCards
* @author Ansor Kasimov
* @version 2.0
*/

public class Deck {

	// ArrayList of GoFishCards
	private ArrayList<GoFishCard> cards = new ArrayList<>();

	/**
	 * Make a Deck with 52 GoFishCards in it
	 */
	public Deck() {
		cards.ensureCapacity(52);
		initialize();
	}

	/**
	 * Generate 52 GoFishCards and store them into a Deck
	 */
	private void initialize() {
		for (int i = 0; i < 52; i++)
			cards.add(new GoFishCard(i));
	}

	/**
	 * Shuffle the Deck
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Return a GoFishCard from the Deck
	 * @return GoFishCard
	 */
	public GoFishCard deal() {
		if (!cards.isEmpty())
			return cards.remove(0);
		return null;
	}

	public int peekRank() {
		if (!cards.isEmpty())
			return cards.get(0).getRank();
		return 0;
	}

	/**
	 * Check if the Deck is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return cards.isEmpty();
	}

}