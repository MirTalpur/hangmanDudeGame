package HangmanDude;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Session;


public abstract class HangmanDudeGameModel implements HangmanMessageListener
{
    public static final int MAXSTRIKES = 6;

    public String word;

    ArrayList<String> dict = new ArrayList<String>();

    public int strikes;

    public ArrayList<Character> guesses = new ArrayList<Character>();

    protected int playerType;

    NetworkingController player;


    /**
     * Constructor
     * 
     * @throws JMSException
     * @throws InterruptedException
     * @throws URISyntaxException
     * @throws IOException
     */
    public HangmanDudeGameModel( String wordsFile ) throws IOException
    {
        initializeDictionary( wordsFile );
    }


    public abstract void playGame() throws Exception;


    private void initializeDictionary( String wordsFile ) throws IOException
    {
        File dictionary = new File( wordsFile );
        BufferedReader reader = null;

        reader = new BufferedReader( new FileReader( dictionary ) );
        String text = null;

        while ( ( text = reader.readLine() ) != null )
        {
            dict.add( text );
        }
        reader.close();

    }
    
    public abstract void challange_was_accepted();

    public void setPlayerType() throws JMSException
    {
        player = new NetworkingController( this );
    }


    public boolean isGameOver()
    {
        return ( strikes >= MAXSTRIKES ) || ( areAllLettersGuessed() );
    }


    public boolean areAllLettersGuessed()
    {
        for ( int i = 0; i < getWord().length(); i++ )
        {
            if ( !guesses.contains( getWord().charAt( i ) ) )
            {
                return false;
            }
        }
        return true;
    }


    public void guessLetter( String s ) throws Exception
    {
        player.GamerGuessLetter( s );
        char c = s.charAt( 0 );
        if ( !guesses.contains( c ) )
        {
            guesses.add( c );
            if ( getWord().indexOf( c ) == -1 )
            {
                strikes++;
            }
        }
    }


    public String getWord()
    {
        return word;
    }


    public boolean setWord( String word )
    {
        if ( dict.contains( word ) )
        {
            this.word = word;

            return true;
        }
        return false;
    }


    protected void getWordFromServer() throws Exception
    {
        word = player.GamerGetGameChallangeWord();
        player.GamerAcceptChallange();
    }


    protected void pushWordToServer() throws JMSException
    {
        player.ChallangerCreateGame( word );
    }

    public void challangeAccepted() throws JMSException
    {
        challange_was_accepted();
    }


    public void challangeRejected()
    {
        // TODO Auto-generated method stub

    }


    public void playerQuit()
    {
        // TODO Auto-generated method stub

    }


    public void playerGuessed( String guess )
    {
        char c = guess.charAt( 0 );
        guesses.add( c );
        if ( getWord().indexOf( c ) == -1 )
        {
            strikes++;
        }
    }

}