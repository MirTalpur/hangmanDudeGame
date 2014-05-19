package HangmanDude;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.Session;


/**
 * 
 */

/**
 * @author daniel
 * 
 */
public abstract class wordsetter
{
    HashMap<String, Integer> dict = new HashMap<String, Integer>();

    private String word;


    public wordsetter( String dictFile )
    {
        File dictionary = new File( dictFile );
        BufferedReader reader = null;

        try
        {
            reader = new BufferedReader( new FileReader( dictionary ) );
            String text = null;

            while ( ( text = reader.readLine() ) != null )
            {
                dict.put( text, 1 );
            }
        }
        catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if ( reader != null )
                {
                    reader.close();
                }
            }
            catch ( IOException e )
            {
            }
        }

    }


    public String getWord()
    {
        return word;
    }


	public void setWord(String word) throws JMSException, InterruptedException, URISyntaxException {
		this.word = word;
		
		Session session = PlayerGamer.createSession();
	    // Comment the following line after configured.
        //org.apache.log4j.BasicConfigurator.configure();
	    
	    
		while(true) {
			word = PlayerGamer.getItemFromWordQueue(PlayerGamer.WORD_QUEUE, session);
			if(word != null)
				break;
			Thread.sleep(1000);
				
		}
		int index = word.indexOf(",");
		
		String queue_name = word.substring(index+1,word.length());
			PlayerGamer.addWordToQueue(this.word, PlayerGamer.QUEUEPREFIX+queue_name, session);
		//session.close();
	}
}
