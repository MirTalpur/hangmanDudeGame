package hangmanDudeTest;

import static org.junit.Assert.*;
import HangmanDude.*;

import org.junit.Test;

public class hangmanDudeTest {

	@Test
	public void hangmanDudeTest() {
		wordsetter test = new wordsetterPlain("words.txt");
		//check if its null
		assertNotNull("Is it null yo",test);
		//print out the string
		test.setWord("boss");
		//check if they equal
		assertEquals("Is it Equal yo","boss",test.getWord());
	}
	
}