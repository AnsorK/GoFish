package goFish;
import java.util.*;

/**
* Properties of a Go-Fish Hand
* @author Ansor Kasimov
* @version 2.0
*/

public class Hand {

	// LinkedList of GoFishCards
	private LinkedList<GoFishCard> hand;

	/**
	 * Make a new LinkedList of GoFishCards
	 */
	public Hand() {
		hand = new LinkedList<>();
	}

	/**
	 * Check if Hand has a rank
	 * @param rank - the specified rank
	 * @return true if found, false otherwise
	 */
	public boolean hasRank(int rank) {
		for (GoFishCard card : hand)
			if (card.getRank() == rank)
				return true;
		return false;
	}

	/**
	 * Add a GoFishCard to the Hand, and sort collection afterwards
	 * @param card - the GoFishCard to add
	 */
	public void addCard(GoFishCard card) {
		hand.add(card);
		Collections.sort(hand);
	}

	/**
	 * Add GoFishCards to the Hand, and sort collection afterwards
	 * @param cards - the LinkedList of GoFishCards to add
	 */
	public void addCards(LinkedList<GoFishCard> cards) {
		hand.addAll(cards);
		Collections.sort(hand);
	}

	/**
	 * Find and return all GoFishCards of specified rank
	 * @param rank - the specified rank
	 * @return LinkedList of GoFishCards
	 */
	public LinkedList<GoFishCard> getCardsByRank(int rank) {
		LinkedList<GoFishCard> cards = new LinkedList<>();
		for (GoFishCard card : hand)
			if (card.getRank() == rank)
				cards.add(card);
		return cards;
	}

	/**
	 * Find and remove all GoFishCards of specified rank
	 * @param rank - the specified rank
	 */
	public void removeCardsByRank(int rank) {
		LinkedList<GoFishCard> list = new LinkedList<>();
		for (GoFishCard card : hand)
			if (card.getRank() == rank)
				list.add(card);
		hand.removeAll(list);
	}

	/**
	 * Count the number of GoFishCards of a particular rank in the Hand
	 * @param rank - the rank to tally
	 * @return the number of GoFishCards of that rank in the Hand
	 */
	private int countRanks(int rank) {
		int count = 0;
		for (GoFishCard card : hand)
			if (card.getRank() == rank)
				count++;
		return count;
	}

	/**
	 * Check the Hand if a book is present
	 * @return true if a book is found, false otherwise
	 */
	public boolean hasBook() {
		for (GoFishCard card : hand)
			if (countRanks(card.getRank()) == 4)
				return true;
		return false;
	}

	/**
	 * Show the book in Hand
	 * @param rank - the specified rank
	 */
	public LinkedList<GoFishCard> showBook(int rank) {
		if (hasBook())
			return getCardsByRank(rank);
		return null;
	}

	/**
	 * Check if Hand is empty
	 * @return true if the Hand is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (hand.isEmpty())
			return true;
		return false;
	}

	/**
	 * Get size of the Hand
	 * @return length
	 */
	public int getSize() {
		return hand.size();
	}

	/**
	 * Get GoFishCard from Hand
	 * @param index - index of GoFishCard in Hand
	 * @return GoFishCard
	 */
	public GoFishCard getCard(int index) {
		return hand.get(index);
	}

	/**
	 * String representation of the Hand
	 * @return the Hand as a String
	 */
	public String toString() {
		String cards = "";
		for (GoFishCard card : hand)
			cards += card + ", ";
		return cards;
	}

}