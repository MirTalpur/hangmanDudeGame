package HangmanDude;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.jms.JMSException;

public class hangmanDudePlain extends hangmanDudeGame
{
    public hangmanDudePlain() throws JMSException, InterruptedException, URISyntaxException, IOException
    {
        super();
    }

    
    public String nextWord(Scanner scan)
    {
    	System.out.print("Guess next Letter: ");
		return scan.next().toLowerCase();
    }

    public void drawHangman()
    {
        // Draws the hangman in plain text.
        System.out.println();
        System.out.println();
        System.out.println( "\t----------------" );
        System.out.println( "\t|              |" );
        System.out.print( "\t|" );
        if ( strikes >= 4 )
        {
            System.out.print( "             \\O/" );
        }
        else if ( strikes == 3 )
        {
            System.out.print( "             \\O" );
        }
        else if ( strikes >= 1 )
        {
            System.out.print( "              O" );
        }
        System.out.println();
        System.out.print( "\t|" );
        if ( strikes >= 2 )
        {
            System.out.print( "              |" );
        }
        System.out.println();
        System.out.print( "\t|" );
        if ( strikes >= 6 )
        {
            System.out.print( "             / \\" );
        }
        else if ( strikes == 5 )
        {
            System.out.print( "             /  " );
        }
        System.out.println();
        System.out.println( "\t|" );
        System.out.print( "\t|  " );
        for ( char c : this.guesses )
        {
            if ( getWord().indexOf( c ) == -1 )
                System.out.print( c + " " );
        }
        System.out.println();
        System.out.println( "   ---------------------------" );
        System.out.println();

        // Draws the letter blanks by looping over each letter in word.
        System.out.print( "\t" );
        for ( int i = 0; i < getWord().length(); i++ )
        {
            char c = getWord().charAt( i );
            if ( guesses.contains( c ) )
            {
                System.out.print( c + " " );
            }
            else
            {
                System.out.print( "_ " );
            }
        }
        System.out.println();
        System.out.println();

        // Draws the ending if game is over.
        if ( isGameOver() )
        {
            if ( areAllLettersGuessed() )
            {
                System.out.println( "YOU WIN" );
            }
            else
            {
                System.out.println();
                System.out.println( " .-\"\"-." );
                System.out.println( "/ _  _ \\" );
                System.out.println( "|(_)(_)|" );
                System.out.println( "(_ /\\ _)" );
                System.out.println( " L====J" );
                System.out.println( " '-..-'" );
                System.out.println( "YOU LOSE" );
                System.out.println( "THE WORD WAS " + getWord().toUpperCase() );
            }
        }
    }
}
