package goFish;
import java.util.LinkedList;

/**
* Properties of a Go-Fish Player
* @author Ansor Kasimov
* @version 2.0
*/

public class Player {

	// GoFishCards in possesion
	private Hand hand;
	// Points accumulated
	private int books;

	/**
	 * Setup a new Player with a Hand and no books
	 */
	public Player() {
		hand = new Hand();
		books = 0;
	}

	/**
	 * Check if Player has GoFishCard of specified rank
	 * @param rank - the specified rank
	 * @return true if Player has specified rank, false otherwise
	 */
	public boolean hasRank(int rank) {
		return hand.hasRank(rank);
	}

	/**
	 * Add a GoFishCard to the Player
	 * @param card - the GoFishCard to add
	 */
	public void addCard(GoFishCard card) {
		hand.addCard(card);
	}

	/**
	 * Add GoFishCards to the Player
	 * @param cards - the LinkedList of GoFishCards to add
	 */
	public void addCards(LinkedList<GoFishCard> cards) {
		hand.addCards(cards);
	}

	/**
	 * Find and return all GoFishCards of specified rank
	 * @param rank - the specified rank
	 * @return LinkedList of GoFishCards
	 */
	public LinkedList<GoFishCard> getCardsByRank(int rank) {
		return hand.getCardsByRank(rank);
	}

	/**
	 * Find and remove all GoFishCards of specified rank
	 * @param rank - the specified rank
	 */
	public void removeCardsByRank(int rank) {
		hand.removeCardsByRank(rank);
	}

	/**
	 * Check if Player has a book
	 * @return true if a book is found, false otherwise
	 */
	public boolean hasBook() {
		return hand.hasBook();
	}

	/**
	 * Add a book
	 */
	public void addBook() {
		++books;
	}

	/**
	 * Show the book
	 * @param rank - the specified rank
	 */
	public LinkedList<GoFishCard> showBook(int rank) {
		return hand.showBook(rank);
	}

	/**
	 * Get Player Hand
	 * @return Hand
	 */
	public Hand getHand() {
		return hand;
	}
	
	/**
	 * Get Player books
	 * @return books
	 */
	public int getBooks() {
		return books;
	}

	/**
	 * String representation of Player
	 * @return Player as String
	 */
	public String toString() {
		return "Hand: " + hand + "Books: " + books;
	}

}