package goFish;
import java.awt.*;
import java.util.Random;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

/**
* Play Go-Fish with the computer
* @author Ansor Kasimov
* @version 2.0
* @see https://bicyclecards.com/how-to-play/go-fish/
*/

public class Game extends JFrame {

	private static final long serialVersionUID = 1L;
	// Turn states
	private enum Turn {YOU, COMPUTER}
	Turn turn;
	// Deck of cards
	private Deck deck;
	// 2 players - you and the computer
	private Player you, computer;
	// Random number generator
	private Random random;
	// Rank to search for
	private int rank;
	// Background color used for components
	private Color darkBlue = new Color(50, 83, 138);
	private Color darkGreen = new Color(39, 115, 39);
	// Swing components
	private JPanel startPanel;
	private JPanel mainPanel;
	private JPanel endPanel;

	/**
	 * Open a new window
	 * @param title - set the name of window
	 */
	public Game(String title) {
		super(title);
		setSize(800, 550);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBackground(darkGreen);
	}

	/**
	 * Display the start screen
	 */
	public void start() {
		startPanel = new JPanel(null);
		startPanel.setBackground(darkGreen);

		JLabel label = new JLabel("Go Fish!");
		label.setBounds(300, 100, 200, 50);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 50));
		label.setForeground(Color.WHITE);

		JButton button = new JButton("Start");
		button.setBounds(355, 200, 80, 60);
		button.setFont(new Font("Serif", Font.BOLD, 20));
		button.setFocusable(false);
		button.setForeground(Color.WHITE);
		button.setBackground(darkBlue);
		button.addActionListener(a -> play());

		startPanel.add(label);
		startPanel.add(button);
		add(startPanel);
		setVisible(true);
	}

	/**
	 * Display the game screen
	 */
	private void play() {
		mainPanel = new JPanel(null);
		mainPanel.setBackground(darkGreen);

		JTextArea textArea = new JTextArea("Starting a new game of Go Fish, dealing cards now ...\n\n");
		textArea.setFont(new Font("Arial", Font.ITALIC, 17));
		textArea.setFocusable(false);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setBorder(new EmptyBorder(15, 15, 15, 15));
		textArea.setCaretPosition(textArea.getDocument().getLength()); // Auto scroll to bottom after new text gets appended

	    JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(100, 50, 600, 300);

		JTextField textField = new JTextField();
		textField.setBounds(300, 400, 100, 50);
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(new EmptyBorder(3, 10, 3, 10));

		JButton button = new JButton("Enter");
		button.setBounds(450, 400, 90, 50);
		button.setFont(new Font("Serif", Font.BOLD, 20));
		button.setFocusable(false);
		button.setForeground(Color.WHITE);
		button.setBackground(darkBlue);

		mainPanel.add(scrollPane);
		mainPanel.add(textField);
		mainPanel.add(button);
		remove(startPanel);
		add(mainPanel);
		revalidate();
		repaint();

		you = new Player();
		computer = new Player();
		random = new Random();
		turn = Turn.YOU;
		deck = new Deck();

		dealCards();
		textArea.append(you + "\n\n");
		textArea.append("What rank do you seek?\n\n");

		button.addActionListener(a -> {
			if (deck.isEmpty())
				end();
			else {
				if (computer.getHand().isEmpty()) {
					textArea.append("I don't have any cards left, sorry\n\n");
					turn = Turn.COMPUTER;
					computerTurn(textArea);
				} else {
					if (you.getHand().isEmpty()) {
						textArea.append("Your hand is empty, drawing from the deck ...\n\n");
						you.addCard(deck.deal());
					}
					rank = GoFishCard.convertToRank(textField.getText());
					textField.setText("");
					if (computer.hasRank(rank)) {
						textArea.append("Yes I have the rank: " + Card.getRankAsString(rank) + ", adding it to your hand ...\n\n");
						you.addCards(computer.getCardsByRank(rank));
						computer.removeCardsByRank(rank);
					} else {
						textArea.append("No I don't have the rank: " + Card.getRankAsString(rank) + ", go fish!\n\n");
						rank = deck.peekRank();
						you.addCard(deck.deal());
						turn = Turn.COMPUTER;
					}
					if (you.hasBook()) {
						textArea.append("Congrats you got a book: " + you.showBook(rank) + "\n\n");
						you.removeCardsByRank(rank);
						you.addBook();
					}
					if (turn == Turn.YOU) {
						textArea.append("You go again\n\n");
						textArea.append(you.toString() + "\n\n");
						textArea.append("What rank do you seek?\n\n");
					} else {
						textArea.append("My turn now\n\n");
						computerTurn(textArea);
					}
				}
			}
		});
	}

	/**
	 * Deal 7 cards to you and the computer
	 */
	private void dealCards() {
		deck.shuffle();
		for (int i = 0; i < 7; i++) {
			you.addCard(deck.deal());
			computer.addCard(deck.deal());
		}
	}
	
	/**
	 * Computer plays GoFish
	 */
	private void computerTurn(JTextArea textArea) {
		while (turn == Turn.COMPUTER) {
			if (you.getHand().isEmpty()) {
				textArea.append("You don't have any cards left\n\n");
				textArea.append("Your turn now ...\n\n");
				textArea.append("What rank do you seek?\n\n");
				turn = Turn.YOU;
			} else {
				if (computer.getHand().isEmpty()) {
					textArea.append("My hand is empty, drawing from the deck ...\n\n");
					computer.addCard(deck.deal());
				}
				rank = computer.getHand().getCard(random.nextInt(computer.getHand().getSize())).getRank();
				if (you.hasRank(rank)) {
					textArea.append("You have the rank I seek: " + Card.getRankAsString(rank) + ", adding it to my hand ...\n\n");
					computer.addCards(you.getCardsByRank(rank));
					you.removeCardsByRank(rank);
				} else {
					textArea.append("You don't have the rank I seek: " + Card.getRankAsString(rank) + ", going fishing ...\n\n");
					rank = deck.peekRank();
					computer.addCard(deck.deal());
					turn = Turn.YOU;
				}
				if (computer.hasBook()) {
					textArea.append("Yay I got a book: " + computer.showBook(rank) + "\n\n");
					computer.removeCardsByRank(rank);
					computer.addBook();
				}
				if (turn == Turn.COMPUTER)
					textArea.append("Going again ...\n\n");
				else {
					textArea.append("Your turn now ...\n\n");
					textArea.append(you + "\n\n");
					textArea.append("What rank do you seek?\n\n");
				}
			}
		}
	}

	/**
	 * Display the end screen
	 */
	private void end() {
		endPanel = new JPanel(null);
		endPanel.setBackground(darkGreen);

		JLabel label1 = new JLabel("Game Over");
		label1.setBounds(300, 100, 200, 50);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.BOLD, 40));
		label1.setForeground(Color.WHITE);

		JTextArea textArea = new JTextArea("No more cards left in the deck\n\nScores:\nYou - books:  " + you.getBooks() + "\nComputer - books: " + computer.getBooks());
		textArea.setBounds(250, 170, 300, 160);
		textArea.setFont(new Font("Serif", Font.BOLD, 20));
		textArea.setFocusable(false);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(darkGreen);
		textArea.setBorder(new EmptyBorder(15, 15, 15, 15));
		textArea.setCaretPosition(textArea.getDocument().getLength());

		JLabel label2 = new JLabel();
		label2.setBounds(300, 350, 200, 50);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Serif", Font.BOLD, 30));
		label2.setForeground(Color.WHITE);

		if (you.getBooks() > computer.getBooks())
			label2.setText("You win");
		else if (you.getBooks() < computer.getBooks())
			label2.setText("You lose");
		else
			label2.setText("It's a tie");

		endPanel.add(label1);
		endPanel.add(textArea);
		endPanel.add(label2);
		remove(mainPanel);
		add(endPanel);
		revalidate();
		repaint();
	}

	/**
	 * Start and run a new Go-Fish game
	 * @param args command-line arguments
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		Game goFish = new Game("Go Fish");
		goFish.start();
	}
}