package HangmanDude;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class hangmanDudeGame {
	public static final int MAXSTRIKES = 6;

	public String word;

	public int strikes;

	private Scanner scan;

	protected ArrayList<Character> guesses;

	/**
	 * Constructor
	 */
	public hangmanDudeGame(String word) {
		// Get word to guess
		this.setWord(word.toLowerCase());
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
				if (getWord().indexOf(c) == -1) {
					strikes++;
				}
			}
		}

		drawHangman();
	}

	public boolean isGameOver() {
		return (strikes >= MAXSTRIKES) || (areAllLettersGuessed());
	}

	protected boolean areAllLettersGuessed() {
		for (int i = 0; i < getWord().length(); i++) {
			if (!guesses.contains(getWord().charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public String getWord() {
		return word;
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

	public void setWord(String word) {
		this.word = word;
	}

}