package HangmanDude;
import java.util.Scanner;


/**
 * 
 */

/**
 * @author daniel
 * 
 */
public class wordsetterPlain extends wordsetter
{
    public wordsetterPlain( String dictFile )
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
