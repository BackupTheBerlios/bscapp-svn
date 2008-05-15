package gui.nicole;



import java.awt.Point;
import java.awt.Toolkit;
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
public class Login extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = 5064091614987614530L;
   private JButton b_anmelden;
   private JTextField tf_name;
   private JLabel l_passwort;
   private JPasswordField tf_passwort;
   private JLabel l_header;
   private JLabel l_name;
   private JButton b_hilfe;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            Login inst = new Login();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public Login()
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
         setTitle("BSC-Login");
         {
            b_anmelden = new JButton();
            getContentPane().add(b_anmelden);
            b_anmelden.setText("Anmelden");
            b_anmelden.setBounds(243, 166, 98, 26);
            b_anmelden.setSize(98, 24);
            b_anmelden.addActionListener(new ActionListener()
            {
               public void actionPerformed(ActionEvent evt)
               {
                  if(false)
                  {
                     JOptionPane.showMessageDialog(null,
                                                   "Anmeldung fehlgeschlagen! Bitte überprüfen Sie die Eingabe.",
                                                   "Anmeldung fehlgeschlagen",
                                                   JOptionPane.ERROR_MESSAGE);
                  }
                  else
                  {
                     AdminFenster ben = new AdminFenster();

                     int bildschirmBreite = Toolkit.getDefaultToolkit()
                                                   .getScreenSize().width;
                     int bildschirmHoehe = Toolkit.getDefaultToolkit()
                                                  .getScreenSize().height;

                     int fensterBreite = ben.getWidth();
                     int fensterHoehe = ben.getHeight();

                     Point p = new Point(bildschirmBreite / 2
                                         - fensterBreite
                                         / 2, bildschirmHoehe / 2
                                              - fensterHoehe
                                              / 2);
                     ben.setLocation(p);
                     AdminBenutzer ab = new AdminBenutzer();
                     ben.setContentPane(ab.getContentPane());
                     ben.setVisible(true);
                  }
               }
            });
         }
         {
            b_hilfe = new JButton();
            getContentPane().add(b_hilfe);
            b_hilfe.setText("Hilfe");
            b_hilfe.setBounds(243, 201, 101, 24);
            b_hilfe.setSize(98, 24);
         }
         {
            l_name = new JLabel();
            getContentPane().add(l_name);
            l_name.setText("Benutzername:");
            l_name.setBounds(37, 59, 159, 22);
         }
         {
            tf_name = new JTextField();
            getContentPane().add(tf_name);
            tf_name.setBounds(37, 81, 162, 22);
            tf_name.setSize(161, 22);

         }
         {
            l_passwort = new JLabel();
            getContentPane().add(l_passwort);
            l_passwort.setText("Passwort:");
            l_passwort.setBounds(37, 113, 163, 23);
         }
         {
            l_header = new JLabel();
            getContentPane().add(l_header);
            l_header.setText("Willkommen bei der BSC der Spengergasse!");
            l_header.setBounds(25, 20, 326, 29);
            l_header.setFont(new java.awt.Font("Tahoma", 1, 14));
         }
         {
            tf_passwort = new JPasswordField();
            getContentPane().add(tf_passwort);
            tf_passwort.setBounds(37, 136, 161, 23);
            tf_passwort.setSize(161, 22);
         }
         pack();
         this.setSize(374, 268);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

}
