package fish;
import java.util.*;

/**
* Properties of a GoFish player
* @author Ansor Kasimov
* @version 1.0
*/

public class Player {
	
	// Name of player
	private String name;
	// The cards in possesion of the player
	private Hand hand;
	// Points player has
	private int points;

	// Player default constructor
	public Player() {
		name = "";
		hand = new Hand();
		points = 0;
	}
		
	/**
	* Player parameterized constructor - set the  name
	* @param String n - name of player
	*/
	public Player(String n) {
		name = n;
		hand = new Hand();
		points = 0;
	}
			
	/**
	* Adds a card to the hand
	* @param GoFishCard card - the card to add
	*/
	public void addCard(GoFishCard card) {
		hand.insertByRank(card);
	}
		
	/**
	* Adds a LinkedList of Cards to the hand
	* @param LinkedList otherHand - the hand to add
	*/
	public void addCards(LinkedList<GoFishCard> otherHand) {
		hand.insertHand(otherHand);
	}
		
	// Increment points by one
	public void addPoint() {
		points++;
	}
		
	/**
	* Returns all of the cards of the specified rank as a LinkedList
	* @param int rank - the rank to search for
	* @return the cards of the specified rank as a LinkedList
	*/
	public LinkedList<GoFishCard> getCards(int rank) {
		return hand.findRank(rank);
	}
		
	/**
	* Set the player's name
	* @param String name - the name to set
	*/
	public void setName(String name) {
		this.name = name;
	}
		
	/**
	* Returns the player's name
	* @return the player's name
	*/
	public String getName() {
		return name;
	}
		
	/**
	* Returns the number of books the player has
	* @return the number of books the player has
	*/
	public int getPoints() {
		return points;
	}
		
	/**
	* Returns the player's hand
	* @return the player's hand
	*/
	public Hand getHand() {
		return hand;
	}
		
	/**
	* Returns true if the player has a specified rank
	* @param int rank - the rank to search for
	* @return true if the player has a specified rank, false otherwise
	*/
	public boolean hasRank(int rank) {
		if (hand.hasRank(rank))
			return true;
		return false;
	}
	
	/**
	* Returns the string representation of the player
	* @return the string representation of the player
	*/
	public String toString() {
		return name + " [Books: " + points + "]\n" + hand; 
	}
			
}
