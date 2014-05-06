package hangmanDudeTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import HangmanDude.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class hangmanDudeGameTest {

	/*
	 * public abstract class test1 extends hangmanDudeGameTest {
	 * 
	 * @Test public void hangmanDudeTest() { hangmanDudeGameTest test = new
	 * hangmanDudeGameTest(); test.toString(); test.getWord("hw");
	 * 
	 * } }
	 */

	hangmanDudeGame hangmanDudeGameTest = new hangmanDudePlain("boss");
	@Test
	public void hangmanDudeGameTesting() {
		assertNotNull("Is it null yo", hangmanDudeGameTest);
		hangmanDudeGameTest.strikes = 7;
		assertEquals("Is it equal yo", 7, hangmanDudeGameTest.strikes);
		hangmanDudeGameTest.word = "boss";
		assertEquals("boss", hangmanDudeGameTest.word);
		//System.out.println(hangmanDudeGameTest.strikes);
		
		/*
		 * if strikes are greater than equal to 6 than isgameOver should return
		 * true
		 */
		//System.out.println(hangmanDudeGameTest.isGameOver());
		//if (hangmanDudeGameTest.strikes >= 6) {
			assertEquals( hangmanDudeGameTest.isGameOver(), true);
		//}
		//assertFalse("game is over", hangmanDudeGameTest.isGameOver());
		
	}
}
// hangmanDudeGame hangmanDudeGameTest;

/*
 * @Before public void setUp() { hangmanDudeGame hangmanDudeGameTest = new
 * hangmanDudeGame; hangmanDudeGameTest.setWord("boss");
 * hangmanDudeGameTest.strikes = 6;
 * 
 * }
 */
/*
 * @Test public void hangmanDudeTest() {
 * assertEquals("boss",hangmanDudeGameTest.getWord());
 * assertEquals(6,hangmanDudeGameTest.strikes); }
 */

