package fish;

/**
* Properties of a playing card
* @author Ansor Kasimov
* @version 1.0
*/

public class Card {

	// An integer between 0 - 12 representing the rank
	private int rank;
	// An integer between 0 - 3 representing the suit
	private int suit;
	
	// Card default constructor - rank and suit are randomly defined
	public Card() {
		rank = (int) (Math.random() * 13);
		suit = (int) (Math.random() * 4);
	}
	
	/**
	* Card parameterized constructor - rank and suit based on integer parameter
	* @param int n - a number between 0 and 51 that gets converted to a value between 0 and 12 for a rank and a value between 0 and 3 for a suit
	*/
	public Card(int n) {
		if (n >= 0 && n <= 51) {
			rank = n % 13;
			suit = n / 13;
		}
	}
	
	/**
	* Card parameterized constructor - rank and suit based on integer parameters 
	* @param int r - a number between 0 and 12 representing the rank
	* @param int s - a number between 0 and 3 representing the suit
	*/
	public Card(int r, int s) {
		if ((r >= 0 && r <= 12) && (s >= 0 && s <= 3)) {
			rank = r;
			suit = s;
		}
	}
	
	/**
	* Modifies the value of the instance variable rank
	* @param int r - a number between 0 and 12 representing the rank
	*/
	public void setRank(int r) {
		if (r >= 0 && r <= 12)
			rank = r;
	}
	
	/**
	* Modifies the value of the instance variable suit
	* @param int s - a number between 0 and 3 representing the suit
	*/
	public void setSuit(int s) {
		if (s >= 0 && s <= 3)
			suit = s;
	}
	
	/**
	* Returns what's stored in the instance variable rank
	* @return the state of the instance variable rank
	*/
	public int getRank() {
		return rank;
	}
	
	/**
	* Returns what's stored in the instance variable suit
	* @return the state of the instance variable suit
	*/
	public int getSuit() {
		return suit;
	}

	/**
	* Returns a String representation of the instance variable rank
	* @return the state of the instance variable rank as a String
	*/
	public String getRankAsString() {
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		return ranks[rank];
	}
	
	/**
	* Returns a String representation of the instance variable rank
	* @param int i - a number between 0 and 12 representing the rank
	* @return the state of the instance variable rank as a String
	*/
	public static String getRankAsString(int i) {
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A" };
		return ranks[i];
	}
	
	/**
	* Returns a String representation of the instance variable suit
	* @return the state of the instance variable suit as a String
	*/
	public String getSuitAsString() {
		String[] suits = {"C", "D", "H", "S"};
		return suits[suit];
	}
	
	/**
	* Compare 2 cards by rank and return a negative, zero, or a positive integer as this card is less than, equal to, or greater than the other card
	* @param Card otherCard - a reference to a card 
	* @return negative, zero, or a positive integer as this card is less than, equal to, or greater than the other card
	*/
	public int compareByRank(Card otherCard) {
		return rank - otherCard.rank;
	}
	
	/**
	* Compare 2 cards by suit and return a negative, zero, or a positive integer as this card is less than, equal to, or greater than the other card
	* @param Card otherCard - a reference to a card
	* @return negative, zero, or a positive integer as this card is less than, equal to, or greater than the other card
	*/
	public int compareBySuit(Card otherCard) {
		return suit - otherCard.suit;
	}
	
	/**
	* Indicates whether some other card has the same rank and suit
	* @param Card otherCard - a reference to a card with which to compare
	* @return true if this card has the same rank and suit as the other card, false otherwise
	*/
	public boolean equals(Card otherCard) {
		return ((rank == otherCard.rank) && (suit == otherCard.suit));
	}
	
	/**
	* Return the card as a string
	* @return the rank and suit as a string
	*/
	public String toString() {
		return getRankAsString() + getSuitAsString();
	}

}