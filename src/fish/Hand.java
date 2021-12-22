package fish;
import java.util.*;

/**
* Properties of a GoFish hand
* @author Ansor Kasimov
* @version 1.0
*/

public class Hand {

	// LinkList of GoFish cards
	private LinkedList<GoFishCard> hand;
	
	// Default constructor
	public Hand() {
		hand = new LinkedList<GoFishCard>();
	}
	
	/**
	* Counts the number of cards of a particular rank in the hand
	* @param int rank - the rank to count
	* @return the number of cards of that rank
	*/
	public int countRank(int rank) {
		int count = 0;
		for (GoFishCard card : hand)
			if (card.getRank() == rank)
				count++;
		return count;
	}
	
	/**
	* Returns 1 if a book (all 4 cards of a particular suit) is in the hand and removes the book from the hand
	* @return the number of books (all 4 cards of a particular suit) in the hand
	*/
	public int evaluate() {
		for (GoFishCard card : hand)
			if (countRank(card.getRank()) == 4) {
				findRank(card.getRank());
				return 1;
			}
		return 0;
	}
	
	/**
	* Finds and returns all cards of the specified rank
	* @param int rank - the rank to search for
	* @return all of the cards of that rank as a LinkedList of GoFish Cards
	*/
	public LinkedList<GoFishCard> findRank(int rank){
		LinkedList<GoFishCard> ranks = new LinkedList<GoFishCard>();
		for (GoFishCard card : hand)
			if (card.getRank() == rank)
				ranks.add(card);
		return ranks;
	}
	
	/**
	* Returns the card at the specified position in this list.
	* @param int index - the index of the list
	* @return GoFishCard at specified index
	*/
	public GoFishCard getCardAt(int index){
		return hand.get(index);
	}
	
	/**
	* Adds a card to the hand, the hand is sorted by rank
	* @param GoFishCard card - a GoFish card
	*/
	public void insertByRank(GoFishCard card){
		hand.add(card);
		Collections.sort(hand);
	}
	
	/**
	* Adds a LinkList of cards to the hand, the hand is sorted by rank
	* @param Collection of GoFish cards
	*/
	public void insertHand(Collection<? extends GoFishCard> otherHand) {
		hand.addAll(otherHand);
		Collections.sort(hand);
	}
	
	/** 
	* Returns true if this rank is in the hand
	* @param int rank - the rank to search for
	* @return true if this rank is in the hand, false otherwise 
	*/
	public boolean hasRank(int rank) {
		for (GoFishCard card : hand)
			if (card.getRank() == rank)
				return true; 
		return false;
	}
	
	/** 
	* Return the number of cards in the hand
	* @return The number of cards in the hand 
	*/
	public int getCount(){
		return hand.size();
	}
	
	/** 
	* Return the hand as a LinkedList of GoFish cards
	* @return The hand as a LinkedList of GoFish cards 
	*/
	public LinkedList<GoFishCard> getHand() {
		return hand;
	}
	
	/**
	* Remove all cards of specified rank from deck
	* @param int rank - rank number
	*/
	public void removeAll(int rank) {
		hand.removeAll((findRank(rank)));
	}
	
	/**
	* Determines if the hand is empty
	* @return true if the hand is empty, false otherwise
	*/
	public boolean isEmpty() {
		if (hand.isEmpty())
			return true;
		return false;
	}
	
	/** 
	* String representation of the hand
	* @return the string representation of the hand
	*/
	public String toString() {
		String cards = "";
		for (GoFishCard card : hand)
			cards += card + " ";
		return cards;
	}
}
