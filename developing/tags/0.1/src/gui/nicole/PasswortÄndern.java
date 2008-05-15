package gui.nicole;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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
public class PasswortÄndern extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = - 6126239037743739899L;
   private JPasswordField tf_apasswort;
   private JPasswordField tf_apasswortneu;
   private JButton b_aAbbrechen;
   private JButton b_benAndern;
   private JLabel tf_aneuesPasswort2;
   private JLabel l_aneuespasswort;
   private JTextField tf_abenutzername;
   private JLabel l_abenutzername;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            PasswortÄndern inst = new PasswortÄndern();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public PasswortÄndern()
   {
      super();
      initGUI();
   }


   private void initGUI()
   {
      try
      {
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         getContentPane().setLayout(null);
         setTitle("Benutzerpasswort ändern");
         {
            tf_apasswort = new JPasswordField();
            getContentPane().add(tf_apasswort);
            tf_apasswort.setBounds(24, 102, 179, 20);
            tf_apasswort.setSize(180, 22);
         }
         {
            l_abenutzername = new JLabel();
            getContentPane().add(l_abenutzername);
            l_abenutzername.setText("Benutzername:");
            l_abenutzername.setBounds(24, 28, 106, 16);
         }
         {
            tf_abenutzername = new JTextField();
            getContentPane().add(tf_abenutzername);
            tf_abenutzername.setBounds(24, 50, 179, 20);
            tf_abenutzername.setSize(180, 22);
         }
         {
            l_aneuespasswort = new JLabel();
            getContentPane().add(l_aneuespasswort);
            l_aneuespasswort.setText("Neues Passwort:");
            l_aneuespasswort.setBounds(24, 82, 111, 14);
         }
         {
            tf_aneuesPasswort2 = new JLabel();
            getContentPane().add(tf_aneuesPasswort2);
            tf_aneuesPasswort2.setText("Neues Passwort wiederholen:");
            tf_aneuesPasswort2.setBounds(24, 138, 220, 14);
         }
         {
            tf_apasswortneu = new JPasswordField();
            getContentPane().add(tf_apasswortneu);
            tf_apasswortneu.setBounds(24, 158, 182, 19);
            tf_apasswortneu.setSize(180, 22);
         }
         {
            b_benAndern = new JButton();
            getContentPane().add(b_benAndern);
            b_benAndern.setText("Ändern");
            b_benAndern.setBounds(239, 192, 100, 22);
            b_benAndern.addActionListener(new ActionListener()
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
            b_aAbbrechen = new JButton();
            getContentPane().add(b_aAbbrechen);
            b_aAbbrechen.setText("Abbrechen");
            b_aAbbrechen.setBounds(239, 223, 100, 22);
         }
         pack();
         this.setSize(382, 297);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

}
