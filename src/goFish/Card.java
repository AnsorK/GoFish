package goFish;

/**
* Properties of a Card
* @author Ansor Kasimov
* @version 2.0
*/

public class Card {

	// An integer between 0 - 12 representing the rank
	private int rank;
	// An integer between 0 - 3 representing the suit
	private int suit;

	/**
	 * Card made with value that will be split amongst rank and suit
	 * @param n - a number between 0 - 51
	 */
	public Card(int n) {
		if (n >= 0 && n <= 51) {
			rank = n % 13;
			suit = n / 13;
		}
	}

	/**
	 * Return the Card's rank
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Compare Cards by rank
	 * @param otherCard - the Card to compare with
	 * @return negative, zero, or a positive integer if this Card is less than, equal to, or greater than the other Card
	 */
	public int compareByRank(Card otherCard) {
		return rank - otherCard.rank;
	}

	/**
	 * Return the Card's rank as a String
	 * @return rank as String
	 */
	private String getRankAsString() {
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		return ranks[rank];
	}

	/**
	 * Retrun a inputted Card rank as a String
	 * @param r - the specifeid rank
	 * @return rank as String
	 */
	public static String getRankAsString(int r) {
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		return ranks[r];
	}

	/**
	 * Return the Card's suit as a String
	 * @return suit as String
	 */
	private String getSuitAsString() {
		String[] suits = {"C", "D", "H", "S"};
		return suits[suit];
	}

	@Override
	/**
	 * Return the Card as a String
	 * @return the rank and suit as a String
	 */
	public String toString() {
		return getRankAsString() + getSuitAsString();
	}

}