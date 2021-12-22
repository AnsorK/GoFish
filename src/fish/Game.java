package fish;
import java.io.*;

/**
* Start a GoFish game
* @author Ansor Kasimov
* @version 1.0
*/

public class Game {
	
	public static void main(String[] args) throws IOException {
		
		// Start a new Go-Fish game
		GoFish game = new GoFish();
		game.playGame();
		
	}
	
}
