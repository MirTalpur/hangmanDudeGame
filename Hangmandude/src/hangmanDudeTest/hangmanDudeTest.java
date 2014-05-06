package hangmanDudeTest;

import static org.junit.Assert.*;
import HangmanDude.*;

import org.junit.Test;

public class hangmanDudeTest {

	@Test
	public void hangmanDudeTest() {
		wordsetter test = new wordsetterPlain("words.txt");
		//wordsetter test1 = new wordsetterPlain("words.txt");
		assertNotNull("Is it null yo",test);
		System.out.println(test.toString());
		//hangmanDudeGame game = new hangmanDudePlain( test.getWord() );
		//System.out.println(test.toString());
		assertEquals("Is it Equal yo","boss",test.getWord());
	}
	
}
