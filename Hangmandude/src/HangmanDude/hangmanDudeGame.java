package HangmanDude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Session;

public abstract class hangmanDudeGame {
	public static final int MAXSTRIKES = 6;

	public String word;

	public int strikes;

	public ArrayList<Character> guesses;

	/**
	 * Constructor
	 * 
	 * @throws JMSException
	 * @throws InterruptedException
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public hangmanDudeGame() throws JMSException, InterruptedException,
			URISyntaxException, IOException {
	    
	    // FOR TESTING ONLY. COMMENT OUT WHEN PLAYING
	    this.setWord("PAPER");
        guesses = new ArrayList<Character>();
        strikes = 0;
        return;

/*
		final Session session = PlayerChallenger.createSession();
		final String queue_name = "" + PlayerChallenger.randomLetter()
				+ PlayerChallenger.randomLetter()
				+ PlayerChallenger.randomLetter();
		PlayerChallenger
				.addWordToQueue("SomeWord," + queue_name,
						PlayerChallenger.QUEUEPREFIX
								+ PlayerChallenger.WORD_GAME_QUEUE, session);

		String word = null;
		while (word == null) {
			try {
				word = PlayerChallenger.getItemFromWordQueue(
						PlayerChallenger.QUEUEPREFIX + queue_name, session);
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		this.setWord(word.toLowerCase());
		guesses = new ArrayList<Character>();
		strikes = 0;*/

	}

	public abstract void playGame();

	public boolean isGameOver() {
		return (strikes >= MAXSTRIKES) || (areAllLettersGuessed());
	}

	public boolean areAllLettersGuessed() {
		for (int i = 0; i < getWord().length(); i++) {
			if (!guesses.contains(getWord().charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public void guessLetter(String s)
	{
	    char c = s.charAt(0);
        if (!guesses.contains(c)) {
            guesses.add(c);
            if (getWord().indexOf(c) == -1) {
                strikes++;
            }
        }
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}