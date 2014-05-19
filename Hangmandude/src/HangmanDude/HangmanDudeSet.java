package HangmanDude;

import java.net.URISyntaxException;

import javax.jms.JMSException;

public class HangmanDudeSet
{

    public static void main( String[] args ) throws JMSException, InterruptedException, URISyntaxException
    {
        wordsetter set = new wordsetterPlain( "words.txt" );
        //hangmanDudeGame game = new hangmanDudeGUI( set.getWord() );
        //game.playGame();
    }
}