package HangmanDude;
public class hangmanDude
{

    public static void main( String[] args )
    {
        wordsetter set = new wordsetterPlain( "words.txt" );
        hangmanDudeGame game = new hangmanDudePlain( set.getWord() );
        game.playGame();
    }
}