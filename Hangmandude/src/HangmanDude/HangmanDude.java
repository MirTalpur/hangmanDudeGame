package HangmanDude;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.jms.JMSException;

public class HangmanDude
{

    public static void main( String[] args ) throws Exception
    {
        //wordsetter set = new wordsetterPlain(  );
        HangmanDudeGameModel game = new HangmanDudeGUIView("words.txt");
    }
}