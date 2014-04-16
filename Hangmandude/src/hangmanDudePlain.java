public class hangmanDudePlain extends hangmanDudeGame {
	public hangmanDudePlain(String word) {
		super(word);
	}

	public void drawHangman() {
		// Draws the hangman in plain text.
		System.out.println();
		System.out.println();
		System.out.println("\t----------------");
		System.out.println("\t|              |");
		System.out.print("\t|");
		if (strikes >= 4) {
			System.out.print("             \\O/");
		} else if (strikes == 3) {
			System.out.print("             \\O");
		} else if (strikes >= 1) {
			System.out.print("              O");
		}
		System.out.println();
		System.out.print("\t|");
		if (strikes >= 2) {
			System.out.print("              |");
		}
		System.out.println();
		System.out.print("\t|");
		if (strikes >= 6) {
			System.out.print("             / \\");
		} else if (strikes == 5) {
			System.out.print("             /  ");
		}
		System.out.println();
		System.out.println("\t|");
		System.out.print("\t|  ");
		for (char c : this.guesses) {
			System.out.print(c + " ");
		}
		System.out.println();
		System.out.println("   ---------------------------");
		System.out.println();

		// Draws the letter blanks by looping over each letter in word.
		System.out.print("\t");
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (guesses.contains(c)) {
				System.out.print(c + " ");
			} else {
				System.out.print("_ ");
			}
		}
		System.out.println();
		System.out.println();

		// Draws the ending if game is over.
		if (isGameOver()) {
			if (areAllLettersGuessed()) {
				System.out.println("YOU WIN");
			} else {
				System.out.println();
				System.out.println(" .-\"\"-.");
				System.out.println("/ _  _ \\");
				System.out.println("|(_)(_)|");
				System.out.println("(_ /\\ _)");
				System.out.println(" L====J");
				System.out.println(" '-..-'");
				System.out.println("YOU LOSE");
				System.out.println("THE WORD WAS " + word.toUpperCase());
			}
		}
	}
}
