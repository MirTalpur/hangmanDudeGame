import java.util.ArrayList;
import java.util.Scanner;


public class hangmanDudeGame
{
    public static final int MAXSTRIKES = 6;

    private String word;

    private int strikes;

    private Scanner scan;

    private ArrayList<Character> guesses;


    /**
     * Constructor
     */
    public hangmanDudeGame( String word )
    {
        // Get word to guess
        this.word = word.toLowerCase();
        guesses = new ArrayList<Character>();
        strikes = 0;

        scan = new Scanner( System.in );
    }


    public void startGame()
    {
        while ( !isGameOver() )
        {
            drawHangmanText( strikes );
            System.out.print( "Guess next Letter: " );
            String s = scan.next().toLowerCase();
            char c = s.charAt( 0 );
            guesses.add( c );
            if ( word.indexOf( c ) == -1 )
            {
                strikes++;
            }
        }

        drawHangmanText( strikes );

        if ( areAllLettersGuessed() )
        {
            System.out.println( "YOU WIN" );
        }
        else
        {
            System.out.println( "YOU LOSE" );
        }
    }


    private boolean isGameOver()
    {
        return strikes >= MAXSTRIKES || areAllLettersGuessed();
    }


    private boolean areAllLettersGuessed()
    {
        for ( int i = 0; i < word.length(); i++ )
        {
            if ( !guesses.contains( word.charAt( i ) ) )
            {
                return false;
            }
        }
        return true;
    }


    /**
     * This method draws the hangman platform and the person on the platform. It
     * takes the integer provided and draws the person based on the number of
     * strikes that have been given.
     * 
     * Also draws the blanks based on the word and the guesses given.
     * 
     * @param strikes
     */
    public void drawHangmanText( int strikes )
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
        System.out.println( "\t|" );
        System.out.println( "   ---------------------------" );
        System.out.println();

        // Draws the letter blanks by looping over each letter in word.
        System.out.print( "\t" );
        for ( int i = 0; i < word.length(); i++ )
        {
            char c = word.charAt( i );
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
    }
}