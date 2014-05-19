package HangmanDude;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.jms.JMSException;


/**
 * 
 */

/**
 * @author daniel
 * 
 */
public class wordsetterPlain extends wordsetter
{
    public wordsetterPlain( String dictFile ) throws JMSException, InterruptedException, URISyntaxException
    {
        super( dictFile );

        while ( this.getWord() == null )
        {
            System.out.print( "Pick a Word: " );
            Scanner scan = new Scanner( System.in );
            String word = scan.nextLine();
            System.out.println();
            if ( dict.get( word ) != null )
            {
                this.setWord(word);
            }
            else
            {
                System.out.println( "Error: Invalid word, try again." );
            }
        }
    }
}
