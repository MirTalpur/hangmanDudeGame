package hangmanDudeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;

import javax.jms.JMSException;
import javax.jms.Session;

import org.junit.Test;

import HangmanDude.PlayerChallenger;

/*
 * Tests Challenger Side
 */

public class PlayerChallengerTest
{
    @Test
    public void testRandomLetter()
    {
        assertTrue( Character.isLetter( PlayerChallenger.randomLetter() ) );
    }

    @Test
    public void testAddWordAndGetItemFromWordQueue()
        throws JMSException,
        URISyntaxException, InterruptedException
    {
    	
    	Session session = PlayerChallenger.createSession();
        PlayerChallenger.addWordToQueue( "SomeWord", PlayerChallenger.QUEUEPREFIX
            + "TEST_QUEUE", session );
        
        assertEquals(( PlayerChallenger.getItemFromWordQueue( PlayerChallenger.QUEUEPREFIX
            + "TEST_QUEUE",session)), "SomeWord");
        
    }

}
