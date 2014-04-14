import java.util.Scanner;

public class hangmanDudeGame 
{
	
	private String word;
	
	private int strikes;
	
	private Scanner scan;
	
	/**
	 * Constructor
	 */
	public hangmanDudeGame()
	{
		// Get word to guess
		word = "hangman"; // TEMP FILLER, WILL FIX LATER.
		strikes = 0;
		
		scan = new Scanner(System.in);
	}
	
	public void startGame()
	{
		while(true)
		{
			drawHangmanText(strikes);
			System.out.println("Guess next Letter");
			String guess = scan.next();
			
			clearText();
		}
	}
	
	public void drawHangmanText( int strikes )
	{
		System.out.println("\t----------------");
		System.out.println("\t|              |");
		System.out.print("\t|");
		if (strikes >= 4)
		{
			System.out.print("             \\O/");
		}
		else if (strikes == 3)
		{
			System.out.print("             \\O");
		}
		else if (strikes >= 1)
		{
			System.out.print("              O");
		}
		System.out.println();
		System.out.print("\t|");
		if (strikes >= 2)
		{
			System.out.print("              |");
		}
		System.out.println();
		System.out.print("\t|");
		if (strikes >= 6)
		{
			System.out.print("             / \\");
		}
		else if (strikes == 5)
		{
			System.out.print("             /  ");
		}
		System.out.println();
		System.out.println("\t|");
		System.out.println("\t|");
		System.out.println("   -------------------------------");
		System.out.println();
	}
	
	public final static void clearText()
	{
		try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
}