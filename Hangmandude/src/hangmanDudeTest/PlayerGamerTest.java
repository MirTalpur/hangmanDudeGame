package hangmanDudeTest;
import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import javax.jms.JMSException;
import javax.jms.Session;

import org.junit.Test;

import HangmanDude.*;


public class PlayerGamerTest
{

    @Test
    public void testAddWordToQueueAndGetItemFromWordQueue() throws JMSException, URISyntaxException
    {
    	Session session = PlayerGamer.createSession();
        PlayerGamer.addWordToQueue( "boss", PlayerGamer.QUEUEPREFIX+"TEST_QUEUE2", session);
        assertEquals(PlayerGamer.getItemFromWordQueue(PlayerGamer.QUEUEPREFIX+"TEST_QUEUE2", session), "boss");
    }



}
