package HangmanDude;

import java.awt.Window;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.swing.JFrame;


/**
 * 
 * @author Ali
 */
public class hangmanDudeGUI extends hangmanDudeGame
{

    // Variables declaration

    private javax.swing.JToggleButton[] letterButtons = new javax.swing.JToggleButton[26];

    private javax.swing.JLabel[] images = new javax.swing.JLabel[8];

    private javax.swing.JButton EXIT;

    private javax.swing.JToggleButton START;

    private javax.swing.JPanel jPanel2;


    // End of variables declaration

    /**
     * Creates new form GUI
     */
    public hangmanDudeGUI( String wordsFile )
        throws JMSException,
        InterruptedException,
        URISyntaxException,
        IOException
    {
        super( wordsFile );
        
        playGame();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents()
    {
        JFrame frame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        START = new javax.swing.JToggleButton();
        EXIT = new javax.swing.JButton();

        // Initialize the 8 images for the hangman.
        for ( int x = 0; x < 8; x++ )
        {
            images[x] = new javax.swing.JLabel();
        }

        // Initialize the 26 letter buttons.
        for ( int x = 0; x < 26; x++ )
        {
            letterButtons[x] = new javax.swing.JToggleButton();
        }

        frame.setDefaultCloseOperation( javax.swing.WindowConstants.EXIT_ON_CLOSE );

        jPanel2.setLayout( null );

        START.setFont( new java.awt.Font( "Traditional Arabic", 1, 14 ) ); // NOI18N
        START.setText( "START" );
        START.addActionListener( new java.awt.event.ActionListener()
        {
            public void actionPerformed( java.awt.event.ActionEvent evt )
            {
                STARTActionPerformed( evt );
            }
        } );
        jPanel2.add( START );
        START.setBounds( 110, 200, 90, 31 );

        EXIT.setFont( new java.awt.Font( "Traditional Arabic", 1, 14 ) ); // NOI18N
        EXIT.setText( "EXIT" );
        EXIT.addActionListener( new java.awt.event.ActionListener()
        {
            public void actionPerformed( java.awt.event.ActionEvent evt )
            {
                EXITActionPerformed( evt );
            }
        } );
        jPanel2.add( EXIT );
        EXIT.setBounds( 110, 260, 90, 30 );

        images[0].setIcon( new javax.swing.ImageIcon( "HangmanPics/background.png" ) ); // NOI18N
        jPanel2.add( images[0] );
        images[0].setBounds( 0, 0, 330, 510 );

        for ( int x = 0; x < 26; x++ )
        {
            letterButtons[x].setText( Character.toString( (char)( x + 65 ) ) );
            letterButtons[x].addActionListener( new java.awt.event.ActionListener()
            {
                public void actionPerformed( java.awt.event.ActionEvent evt )
                {
                    javax.swing.JToggleButton src = (javax.swing.JToggleButton)evt.getSource();
                    src.setVisible( false );
                    checkStrikes( src.getText() );
                }
            } );
            jPanel2.add( letterButtons[x] );
            letterButtons[x].setBounds( ( x % 5 ) * 60 + 17,
                ( x / 5 ) * 30 + 317,
                50,
                20 );
        }

        for ( int x = 1; x <= 7; x++ )
        {
            images[x].setIcon( new javax.swing.ImageIcon( "HangmanPics/hangman"
                + x + ".jpg" ) );
            jPanel2.add( images[x] );
            images[x].setBounds( 0, 0, 330, 500 );
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( frame.getContentPane() );
        frame.getContentPane().setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addComponent( jPanel2,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                324,
                javax.swing.GroupLayout.PREFERRED_SIZE ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
            .addComponent( jPanel2,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                514,
                javax.swing.GroupLayout.PREFERRED_SIZE ) );

        frame.pack();

        // System.out.println( "test" );
        frame.setVisible( true );
    }


    private void STARTActionPerformed( java.awt.event.ActionEvent evt )
    {

        Object src = evt.getSource();
        if ( src.equals( START ) )
        {
            START.setVisible( false );
            EXIT.setVisible( false );
            // jPanel2.setVisible(false);
            images[0].setVisible( false );
        }

    }


    private void EXITActionPerformed( java.awt.event.ActionEvent evt )
    {

        Object src = evt.getSource();
        if ( src.equals( EXIT ) )
        {
            System.exit( 1 );

        }
    }


    private void checkStrikes( String guess ) throws Exception
    {
        guessLetter( guess );
        images[strikes].setVisible( false );
        if ( isGameOver() )
        {
            // GAME IS OVER. END
            System.exit( 0 );
        }
    }


    @Override
    public void playGame()
    {
        initComponents();
    }
}
