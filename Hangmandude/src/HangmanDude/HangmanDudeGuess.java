package HangmanDude;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.jms.JMSException;

public class HangmanDudeGuess
{

    public static void main( String[] args ) throws JMSException, InterruptedException, URISyntaxException, IOException
    {
        //wordsetter set = new wordsetterPlain( "words.txt" );
        hangmanDudeGame game = new hangmanDudePlain();
        game.playGame();
    }
}