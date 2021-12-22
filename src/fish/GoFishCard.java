package fish;

/**
* Properties of a GoFish playing card
* @author Ansor Kasimov
* @version 1.0
*/

public class GoFishCard extends Card implements Comparable<GoFishCard> {

	// GoFishCard default constructor - create a new card
	public GoFishCard() {
		super();
	}
	
	/**
	* GoFishCard parameterized constructor - create a new card with custom rank and suit 
	* @param int n - a number between 0 and 51 inclusive
	*/
	public GoFishCard(int n) {
		super(n);
	}
	
	/**
	* GoFishCard parameterized constructor - create a new card with custom rank and suit 
	* @param int r - a number between 0 and 12 representing the rank 
	* @param int s - a number between 0 and 3 representing the suit 
	*/
	public GoFishCard(int r, int s) {
		super(r,s);
	}
	
	/**
	* Comparable interface method to compare GoFish cards
	* @param GoFishCard otherCard - a GoFish card to compare to
	* @return -1 if this card's rank is lower than than the other's, 0 if they are the same, 1 if this card's rank is higher than the other's
	*/
	public int compareTo(GoFishCard otherCard) {
		return compareByRank((Card) otherCard);
	}
	
	/**
	* Comparable interface mehod to compare GoFish cards
	* @param GoFishCard otherCard - a GoFish card to compare to
	* @return true if this card's rank is the same as the other's, false otherwise
	*/
	public boolean equals(GoFishCard otherCard) {
		return (getRank() == otherCard.getRank());
	}
	
	/**
	* Converts a string representation of a rank into an integer version
	* @param String str - a string representing a rank
	* @return the equivalent rank in intger form
	*/
	public static int convertToRank(String str) {
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		for (int i = 0; i < ranks.length; i++)
			if (ranks[i].equalsIgnoreCase(str))
				return i;
		return -1;
	}
	
}
