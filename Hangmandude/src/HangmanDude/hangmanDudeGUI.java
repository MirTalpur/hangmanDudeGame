package HangmanDude;

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
public class hangmanDudeGUI extends hangmanDudeGame {

    /**
     * Creates new form GUI
     */
	private Scanner scan;
	
    public hangmanDudeGUI() throws JMSException, InterruptedException, URISyntaxException, IOException{
        initComponents();
        scan = new Scanner(System.in);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")                    
    private void initComponents() {
    	JFrame frame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        START = new javax.swing.JToggleButton();
        EXIT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        A = new javax.swing.JToggleButton();
        B = new javax.swing.JToggleButton();
        C = new javax.swing.JToggleButton();
        D = new javax.swing.JToggleButton();
        E = new javax.swing.JToggleButton();
        F = new javax.swing.JToggleButton();
        G = new javax.swing.JToggleButton();
        H = new javax.swing.JToggleButton();
        I = new javax.swing.JToggleButton();
        J = new javax.swing.JToggleButton();
        K = new javax.swing.JToggleButton();
        L = new javax.swing.JToggleButton();
        M = new javax.swing.JToggleButton();
        N = new javax.swing.JToggleButton();
        O = new javax.swing.JToggleButton();
        P = new javax.swing.JToggleButton();
        Q = new javax.swing.JToggleButton();
        R = new javax.swing.JToggleButton();
        S = new javax.swing.JToggleButton();
        T = new javax.swing.JToggleButton();
        U = new javax.swing.JToggleButton();
        V = new javax.swing.JToggleButton();
        W = new javax.swing.JToggleButton();
        X = new javax.swing.JToggleButton();
        Y = new javax.swing.JToggleButton();
        Z = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        START.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        START.setText("START");
        START.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STARTActionPerformed(evt);
            }
        });
        jPanel2.add(START);
        START.setBounds(110, 200, 90, 31);

        EXIT.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        EXIT.setText("EXIT");
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });
        jPanel2.add(EXIT);
        EXIT.setBounds(110, 260, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon("HangmanPics/background.png")); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 330, 510);

        A.setText("A");
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });
        jPanel2.add(A);
        A.setBounds(10, 320, 40, 20);

        B.setText("B");
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }
        });
        jPanel2.add(B);
        B.setBounds(60, 320, 40, 20);

        C.setText("C");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });
        jPanel2.add(C);
        C.setBounds(110, 320, 40, 20);

        D.setText("D");
        D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DActionPerformed(evt);
            }
        });
        jPanel2.add(D);
        D.setBounds(160, 320, 40, 20);

        E.setText("E");
        E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EActionPerformed(evt);
            }
        });
        jPanel2.add(E);
        E.setBounds(210, 320, 40, 20);

        F.setText("F");
        F.setActionCommand("F");
        F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FActionPerformed(evt);
            }
        });
        jPanel2.add(F);
        F.setBounds(270, 320, 40, 20);

        G.setText("G");
        G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GActionPerformed(evt);
            }
        });
        jPanel2.add(G);
        G.setBounds(10, 360, 40, 20);

        H.setText("H");
        H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HActionPerformed(evt);
            }
        });
        jPanel2.add(H);
        H.setBounds(60, 360, 40, 20);

        I.setText("I");
        I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IActionPerformed(evt);
            }
        });
        jPanel2.add(I);
        I.setBounds(110, 360, 40, 20);

        J.setText("J");
        J.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JActionPerformed(evt);
            }
        });
        jPanel2.add(J);
        J.setBounds(160, 360, 40, 20);

        K.setText("K");
        K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KActionPerformed(evt);
            }
        });
        jPanel2.add(K);
        K.setBounds(210, 360, 40, 20);

        L.setText("L");
        L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LActionPerformed(evt);
            }
        });
        jPanel2.add(L);
        L.setBounds(270, 360, 40, 20);

        M.setText("M");
        M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MActionPerformed(evt);
            }
        });
        jPanel2.add(M);
        M.setBounds(10, 390, 40, 20);

        N.setText("N");
        N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NActionPerformed(evt);
            }
        });
        jPanel2.add(N);
        N.setBounds(60, 390, 40, 20);

        O.setText("O");
        O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OActionPerformed(evt);
            }
        });
        jPanel2.add(O);
        O.setBounds(110, 390, 40, 20);

        P.setText("P");
        P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PActionPerformed(evt);
            }
        });
        jPanel2.add(P);
        P.setBounds(160, 390, 40, 20);

        Q.setText("Q");
        Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QActionPerformed(evt);
            }
        });
        jPanel2.add(Q);
        Q.setBounds(210, 390, 40, 20);

        R.setText("R");
        R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RActionPerformed(evt);
            }
        });
        jPanel2.add(R);
        R.setBounds(270, 390, 40, 20);

        S.setText("S");
        S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SActionPerformed(evt);
            }
        });
        jPanel2.add(S);
        S.setBounds(10, 430, 40, 20);

        T.setText("T");
        T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TActionPerformed(evt);
            }
        });
        jPanel2.add(T);
        T.setBounds(60, 430, 40, 20);

        U.setText("U");
        U.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UActionPerformed(evt);
            }
        });
        jPanel2.add(U);
        U.setBounds(110, 430, 40, 20);

        V.setText("V");
        V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VActionPerformed(evt);
            }
        });
        jPanel2.add(V);
        V.setBounds(160, 430, 40, 20);

        W.setText("W");
        W.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WActionPerformed(evt);
            }
        });
        jPanel2.add(W);
        W.setBounds(210, 430, 50, 20);

        X.setText("X");
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });
        jPanel2.add(X);
        X.setBounds(270, 430, 40, 20);

        Y.setText("Y");
        Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YActionPerformed(evt);
            }
        });
        jPanel2.add(Y);
        Y.setBounds(10, 460, 40, 20);

        Z.setText("Z");
        Z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZActionPerformed(evt);
            }
        });
        jPanel2.add(Z);
        Z.setBounds(60, 460, 40, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon("HangmanPics/hangman1.jpg")); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 330, 500);

        jLabel3.setIcon(new javax.swing.ImageIcon("HangmanPics/hangman2.jpg")); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 330, 500);

        jLabel4.setIcon(new javax.swing.ImageIcon("HangmanPics/hangman3.jpg")); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 0, 330, 500);

        jLabel5.setIcon(new javax.swing.ImageIcon("HangmanPics/hangman4.jpg")); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 330, 500);

        jLabel6.setIcon(new javax.swing.ImageIcon("HangmanPics/hangman5.jpg")); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(0, 0, 330, 500);

        jLabel7.setIcon(new javax.swing.ImageIcon("HangmanPics/hangman6.jpg")); // NOI18N
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 0, 330, 500);

        jLabel8.setIcon(new javax.swing.ImageIcon("HangmanPics/hangman7.jpg")); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 330, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        frame.pack();
    }               

    private void STARTActionPerformed(java.awt.event.ActionEvent evt) {                                      
      
        Object src = evt.getSource();
        if(src.equals(START)){
            START.setVisible(false);
            EXIT.setVisible(false);
            //jPanel2.setVisible(false);
            jLabel1.setVisible(false);
        }
        
    }                                     

    private void EXITActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        Object src = evt.getSource();
        if(src.equals(EXIT)){
            System.exit(1);

        }   
    }                                    

    private void BActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(B)){
           B.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void checkStrikes() {
    	 if(strikes == 1){
         	jLabel2.setVisible(false);
         }
         if(strikes == 2){
         	jLabel3.setVisible(false);
         }
         if(strikes == 3){
         	jLabel4.setVisible(false);
         }
         if(strikes == 4){
         	jLabel5.setVisible(false);
         }
         if(strikes == 5){
         	jLabel6.setVisible(false);
         }
         if(strikes == 6){
         	jLabel7.setVisible(false);
         }
	}

	private void AActionPerformed(java.awt.event.ActionEvent evt) {                                  
        // TODO add your handling code here:
        Object src = evt.getSource();
        if(src.equals(A)){
           A.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void CActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(C)){
           C.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void DActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(D)){
           D.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void EActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(E)){
           E.setVisible(false);
        }
    }                                 

    private void FActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(F)){
           F.setVisible(false);
        }
    }                                 

    private void GActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(G)){
           G.setVisible(false);
        }
    }                                 

    private void HActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(H)){
           H.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void IActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(I)){
           I.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void JActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(J)){
           J.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void KActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(K)){
           K.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void LActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(L)){
           L.setVisible(false);
        }
    }                                 

    private void MActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(M)){
           M.setVisible(false);
        }
    }                                 

    private void NActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(N)){
           N.setVisible(false);
        }
    }                                 

    private void OActionPerformed(java.awt.event.ActionEvent evt) {                                  
        
        Object src = evt.getSource();
        if(src.equals(O)){
           O.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void PActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(P)){
           P.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void QActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(Q)){
           Q.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void RActionPerformed(java.awt.event.ActionEvent evt) {                                  
        Object src = evt.getSource();
        if(src.equals(R)){
           R.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void SActionPerformed(java.awt.event.ActionEvent evt) {                                  
        // TODO add your handling code here:
        Object src = evt.getSource();
        if(src.equals(S)){
           S.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void TActionPerformed(java.awt.event.ActionEvent evt) {                                  
        
        Object src = evt.getSource();
        if(src.equals(T)){
           T.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void UActionPerformed(java.awt.event.ActionEvent evt) {                                  
        
        Object src = evt.getSource();
        if(src.equals(U)){
           U.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void VActionPerformed(java.awt.event.ActionEvent evt) {                                  
      
        Object src = evt.getSource();
        if(src.equals(V)){
           V.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void WActionPerformed(java.awt.event.ActionEvent evt) {                                  
        
        Object src = evt.getSource();
        if(src.equals(W)){
           W.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void XActionPerformed(java.awt.event.ActionEvent evt) {                                  
     
        Object src = evt.getSource();
        if(src.equals(X)){
           X.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void YActionPerformed(java.awt.event.ActionEvent evt) {                                  
       
        Object src = evt.getSource();
        if(src.equals(Y)){
           Y.setVisible(false);
        }
        checkStrikes();
    }                                 

    private void ZActionPerformed(java.awt.event.ActionEvent evt) {                                  
      
        Object src = evt.getSource();
        if(src.equals(Z)){
           Z.setVisible(false);
        }
        checkStrikes();
    }                                 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(hangmanDudeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hangmanDudeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hangmanDudeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hangmanDudeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration                  
    private javax.swing.JToggleButton A;
    private javax.swing.JToggleButton B;
    private javax.swing.JToggleButton C;
    private javax.swing.JToggleButton D;
    private javax.swing.JToggleButton E;
    private javax.swing.JButton EXIT;
    private javax.swing.JToggleButton F;
    private javax.swing.JToggleButton G;
    private javax.swing.JToggleButton H;
    private javax.swing.JToggleButton I;
    private javax.swing.JToggleButton J;
    private javax.swing.JToggleButton K;
    private javax.swing.JToggleButton L;
    private javax.swing.JToggleButton M;
    private javax.swing.JToggleButton N;
    private javax.swing.JToggleButton O;
    private javax.swing.JToggleButton P;
    private javax.swing.JToggleButton Q;
    private javax.swing.JToggleButton R;
    private javax.swing.JToggleButton S;
    private javax.swing.JToggleButton START;
    private javax.swing.JToggleButton T;
    private javax.swing.JToggleButton U;
    private javax.swing.JToggleButton V;
    private javax.swing.JToggleButton W;
    private javax.swing.JToggleButton X;
    private javax.swing.JToggleButton Y;
    private javax.swing.JToggleButton Z;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration                   

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		while (!isGameOver()) {
			drawHangman();
	    	//System.out.print("Guess next Letter: ");
			String s = scan.next().toLowerCase();
			char c = s.charAt(0);
			if (!guesses.contains(c)) {
				guesses.add(c);
				if (getWord().indexOf(c) == -1) {
					strikes++;
				}
			}
		}

		drawHangman();
		
	}

	@Override
	public void drawHangman() {
		// TODO Auto-generated method stub
		initComponents();
		
	}
}

