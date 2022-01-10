package goFish;

/**
* Properties of a GoFishCard
* @author Ansor Kasimov
* @version 2.0
*/

public class GoFishCard extends Card implements Comparable<GoFishCard> {

	/**
	 * GoFishCard made with an integer between 0 - 51, value will be split amongst rank and suit
	 * @param n - a number between 0 - 51
	 */
	public GoFishCard(int n) {
		super(n);
	}

	/**
	 * Compare GoFishCards by rank
	 * @param otherCard - GoFishCard to compare with
	 * @return -1 if this Card's rank is lower than the other's, 0 if they are the same, 1 if higher
	 */
	public int compareTo(GoFishCard otherCard) {
		return compareByRank((Card) otherCard);
	}

	/**
	 * Check if GoFishCards are equal
	 * @param otherCard - GoFishCard to compare with
	 * @return true if this Card's rank is the same as the other's, false otherwise
	 */
	public boolean equals(GoFishCard otherCard) {
		return (getRank() == otherCard.getRank());
	}

	/**
	 * Converts a String into an applicable rank
	 * @param rank - String value of a rank
	 * @return the rank if found, -1 otherwise
	 */
	public static int convertToRank(String rank) {
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		for (int i = 0; i < ranks.length; i++)
			if (ranks[i].equalsIgnoreCase(rank))
				return i;
		return 0;
	}

}