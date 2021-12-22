package fish;
import java.util.*;

/**
* Practice GoFish game against the computer
* @author Ansor Kasimov
* @version 1.0
*/

public class GoFish {

	// Deck of cards
	private Deck deck;
	// 2 players
	private Player you, computer;
	// Scanner for input
	private Scanner sc;

	// Setup the match between you and the computer
	public GoFish() {
		deck = new Deck();
		you = new Player(); 
		computer = new Player("Computer");
		sc = new Scanner(System.in);
		setName();
		dealCards();
	}
		
	// Input your name
	private void setName() {
		System.out.print("Enter your name: ");
		you.setName(sc.nextLine());
		System.out.println("Game starting in practice mode");
	}
		
	// Deal 7 cards to each player
	private void dealCards() {
		deck.shuffle();
		for (int i = 0; i < 7; i++) { 
			you.addCard((GoFishCard)deck.deal());
			computer.addCard((GoFishCard)deck.deal());
		}	
	}
		
	// Play Go-Fish
	public void playGame() {
			
		// True if it's your turn, false otherwise
		boolean turn = true;
		// Random rank input from computer
		Random rand = new Random();
		int randomRank;
			
			// Loop while cards are in the deck or in either player's hands
			while (true) {
				
				// Your turn
				if (turn) {
					
					System.out.println("\n***************************************************************");
					System.out.println(you);
					System.out.print("Computer, do you have any: ");
					int rank = GoFishCard.convertToRank(sc.nextLine());
					
					// Check if computer has specified rank
					if (computer.hasRank(rank)) {
						System.out.println("Computer says \"Yes!\"");
						you.addCards(computer.getHand().findRank(rank));
						computer.getHand().removeAll(rank);
						
						// Check if you have a book
						hasBook(you, rank);
						
						System.out.println(you);
						
						// Check if either player's hands are empty
						if (you.getHand().isEmpty() || computer.getHand().isEmpty())
							break;
						// Next turn
						turn = false;
					} 
					
					// Go fish
					else {
						System.out.println("Computer says \"No, go fish!\"");
						GoFishCard card = ((GoFishCard)deck.deal());
						you.addCard(card);
						
						// Check if you have a book
						hasBook(you, card.getRank());
						
						System.out.println(you);
						
						// Check if the deck is empty
						if (deck.isEmpty())
							break;
						// Next turn
						turn = false;
					}
					
				}
				
				// Computer's turn
				else {
					
					System.out.println("\n***************************************************************");
					System.out.println(computer);
					randomRank = rand.nextInt(13);
					System.out.print(you.getName() + ", do you have any: " + Card.getRankAsString(randomRank) + "\n");
					
					// Check if you have specified rank
					if (you.hasRank(randomRank)) {
						System.out.println(you.getName() + " says \"Yes!\"");
						computer.addCards(you.getHand().findRank(randomRank));
						you.getHand().removeAll(randomRank);
						
						// Check if computer has a book
						hasBook(computer, randomRank);
						
						System.out.println(computer);
						
						// Check if either player's hands are empty
						if (computer.getHand().isEmpty() || you.getHand().isEmpty())
							break;
						// Next turn
						turn = true;
						
					} 
					
					// Go fish
					else {
						System.out.println(you.getName() + " says \"No, go fish!\"");
						GoFishCard card = ((GoFishCard)deck.deal());
						computer.addCard(card);
						
						// Check if computer has a book
						hasBook(computer, card.getRank());
						
						System.out.println(computer);
						
						// Check if the deck is empty
						if (deck.isEmpty())
							break;
						// Next turn
						turn = true;
					}
					
				}
				
			}
			
		// Display results after game end
		gameResults();
			
	}
		
	// Check if a player has a book
	private void hasBook(Player p, int rank) {
		if (p.getHand().countRank(rank) == 4) {
			p.addPoint();
			System.out.println("Book: " + p.getHand().findRank(rank));
			p.getHand().removeAll(rank);
		}
	}
		
	// Display game results
	private void gameResults() {
		if (you.getPoints() > computer.getPoints())
			System.out.println(you.getName() + " is the winner...");
		else System.out.println("\nComputer is the winner...");
	}
	
}
