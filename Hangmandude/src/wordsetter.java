import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


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

    protected String word;


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
}
