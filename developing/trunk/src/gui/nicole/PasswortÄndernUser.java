package gui.nicole;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;



/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial use. If
 * Jigloo is being used commercially (ie, by a corporation, company or
 * business for any purpose whatever) then you should purchase a
 * license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance
 * of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class PasswortÄndernUser extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = - 2163437254594664029L;
   private JButton b_pwAvU;
   private JLabel l_pwA;
   private JLabel l_pwA3;
   private JPasswordField tf_pwA3;
   private JPasswordField tf_pwA2;
   private JPasswordField tf_pwA;
   private JLabel l_pwA2;
   private JButton b_abbrechenU;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            PasswortÄndernUser inst = new PasswortÄndernUser();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public PasswortÄndernUser()
   {
      super();
      initGUI();
   }


   private void initGUI()
   {
      try
      {
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setTitle("Passwort ändern");
         getContentPane().setLayout(null);
         {
            b_pwAvU = new JButton();
            getContentPane().add(b_pwAvU);
            b_pwAvU.setText("Ändern");
            b_pwAvU.setBounds(227, 166, 95, 20);
            b_pwAvU.setSize(96, 22);
            b_pwAvU.addActionListener(new ActionListener()
            {
               public void actionPerformed(ActionEvent evt)
               {
                  JOptionPane.showMessageDialog(null,
                                                "Benutzerpasswort wurde erfolgreich geändert.",
                                                "Änderung erfolgreich",
                                                JOptionPane.INFORMATION_MESSAGE);
                  // JOptionPane.showMessageDialog(null,"Änderung
                  // fehlgeschlagen! Bitte überprüfen Sie die
                  // Eingabe.","Änderung
                  // fehlgeschlagen",JOptionPane.ERROR_MESSAGE);
               }
            });
         }
         {
            b_abbrechenU = new JButton();
            getContentPane().add(b_abbrechenU);
            b_abbrechenU.setText("Abbrechen");
            b_abbrechenU.setBounds(227, 193, 96, 25);
            b_abbrechenU.setSize(96, 22);
         }
         {
            l_pwA = new JLabel();
            getContentPane().add(l_pwA);
            l_pwA.setText("Altes Passwort:");
            l_pwA.setBounds(23, 25, 126, 15);
         }
         {
            l_pwA2 = new JLabel();
            getContentPane().add(l_pwA2);
            l_pwA2.setText("Neues Passwort:");
            l_pwA2.setBounds(23, 72, 133, 14);
         }
         {
            l_pwA3 = new JLabel();
            getContentPane().add(l_pwA3);
            l_pwA3.setText("Neues Passwort wiederholen:");
            l_pwA3.setBounds(23, 117, 182, 14);
         }
         {
            tf_pwA = new JPasswordField();
            getContentPane().add(tf_pwA);
            tf_pwA.setBounds(23, 44, 174, 22);
         }
         {
            tf_pwA2 = new JPasswordField();
            getContentPane().add(tf_pwA2);
            tf_pwA2.setBounds(23, 91, 174, 22);
         }
         {
            tf_pwA3 = new JPasswordField();
            getContentPane().add(tf_pwA3);
            tf_pwA3.setBounds(23, 137, 174, 22);
         }
         pack();
         this.setSize(358, 263);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

}
