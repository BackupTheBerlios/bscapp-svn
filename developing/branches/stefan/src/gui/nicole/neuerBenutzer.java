package gui.nicole;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class neuerBenutzer extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = - 3561363330157764977L;
   private JButton b_hinzufügen;
   private JButton b_abbrechen;
   private JComboBox jComboBox1;
   private JLabel l_gruppeW;
   private JPasswordField tf_bpasswort;
   private JLabel l_bpasswort;
   private JTextField tf_bname;
   private JLabel l_bname;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            neuerBenutzer inst = new neuerBenutzer();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public neuerBenutzer()
   {
      super();
      initGUI();
   }


   private void initGUI()
   {
      try
      {
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setTitle("Benutzer anlegen");
         getContentPane().setLayout(null);
         {
            b_hinzufügen = new JButton();
            getContentPane().add(b_hinzufügen);
            b_hinzufügen.setText("Hinzufügen");
            b_hinzufügen.setBounds(246, 191, 101, 21);
            b_hinzufügen.setSize(100, 22);
            b_hinzufügen.addActionListener(new ActionListener()
            {
               public void actionPerformed(ActionEvent evt)
               {
                  JOptionPane.showMessageDialog(null,
                                                "Der Benutzer wurde erfolgreich angelegt.",
                                                "Benutzer hinzugefügt",
                                                JOptionPane.INFORMATION_MESSAGE);
                  // JOptionPane.showMessageDialog(null,"Anlegen des
                  // Benutzers fehlgeschlagen! Bitte überprüfen Sie
                  // die Eingabe.","Anlegen
                  // fehlgeschlagen",JOptionPane.ERROR_MESSAGE);
               }
            });
         }
         {
            b_abbrechen = new JButton();
            getContentPane().add(b_abbrechen);
            b_abbrechen.setText("Abbrechen");
            b_abbrechen.setBounds(246, 223, 101, 21);
            b_abbrechen.setSize(100, 22);
         }
         {
            l_bname = new JLabel();
            getContentPane().add(l_bname);
            l_bname.setText("Benutzername:");
            l_bname.setBounds(33, 32, 94, 16);
         }
         {
            tf_bname = new JTextField();
            getContentPane().add(tf_bname);
            tf_bname.setBounds(33, 55, 175, 23);
         }
         {
            l_bpasswort = new JLabel();
            getContentPane().add(l_bpasswort);
            l_bpasswort.setText("Passwort:");
            l_bpasswort.setBounds(33, 90, 74, 14);
         }
         {
            tf_bpasswort = new JPasswordField();
            getContentPane().add(tf_bpasswort);
            tf_bpasswort.setBounds(33, 111, 295, 24);
            tf_bpasswort.setSize(175, 22);
         }
         {
            ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(new String[]
            {"Administrator/in", "Leser/Schreiber/in", "Leser/in"});
            jComboBox1 = new JComboBox();
            getContentPane().add(jComboBox1);
            jComboBox1.setModel(jComboBox1Model);
            jComboBox1.setBounds(33, 163, 175, 21);
            jComboBox1.setFocusCycleRoot(true);
            jComboBox1.setToolTipText("Gruppe wählen...");
            jComboBox1.setSize(175, 22);
         }
         {
            l_gruppeW = new JLabel();
            getContentPane().add(l_gruppeW);
            l_gruppeW.setText("Gruppe wählen:");
            l_gruppeW.setBounds(33, 143, 140, 14);
         }
         pack();
         this.setSize(375, 300);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

}
