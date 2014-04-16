import java.util.ArrayList;
import java.util.Scanner;

public abstract class hangmanDudeGame {
	public static final int MAXSTRIKES = 6;

	protected String word;

	protected int strikes;

	private Scanner scan;

	protected ArrayList<Character> guesses;

	/**
	 * Constructor
	 */
	public hangmanDudeGame(String word) {
		// Get word to guess
		this.word = word.toLowerCase();
		guesses = new ArrayList<Character>();
		strikes = 0;

		scan = new Scanner(System.in);
	}

	public void playGame() {
		while (!isGameOver()) {
			drawHangman();
			System.out.print("Guess next Letter: ");
			String s = scan.next().toLowerCase();
			char c = s.charAt(0);
			if (!guesses.contains(c)) {
				guesses.add(c);
				if (word.indexOf(c) == -1) {
					strikes++;
				}
			}
		}

		drawHangman();
	}

	protected boolean isGameOver() {
		return strikes >= MAXSTRIKES || areAllLettersGuessed();
	}

	protected boolean areAllLettersGuessed() {
		for (int i = 0; i < word.length(); i++) {
			if (!guesses.contains(word.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method draws the hangman platform and the person on the platform. It
	 * takes the integer provided and draws the person based on the number of
	 * strikes that have been given.
	 * 
	 * Also draws the blanks based on the word and the guesses given.
	 * 
	 * @param strikes
	 */
	public abstract void drawHangman();
}