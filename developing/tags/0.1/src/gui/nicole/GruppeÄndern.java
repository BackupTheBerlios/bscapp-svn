package gui.nicole;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class GruppeÄndern extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = - 4878032000854651395L;
   private JLabel l_nameG;
   private JTextField tf_nameG;
   private JButton b_abbrechenG;
   private JButton b_gruppeA;
   private JComboBox combo1;
   private JLabel l_gruppeG;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            GruppeÄndern inst = new GruppeÄndern();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public GruppeÄndern()
   {
      super();
      initGUI();
   }


   private void initGUI()
   {
      try
      {
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setTitle("Benutzergruppe ändern");
         getContentPane().setLayout(null);
         {
            l_nameG = new JLabel();
            getContentPane().add(l_nameG);
            l_nameG.setText("Benutzername:");
            l_nameG.setBounds(28, 36, 111, 14);
         }
         {
            tf_nameG = new JTextField();
            getContentPane().add(tf_nameG);
            tf_nameG.setBounds(28, 56, 142, 21);
         }
         {
            l_gruppeG = new JLabel();
            getContentPane().add(l_gruppeG);
            l_gruppeG.setText("Gruppe auswählen:");
            l_gruppeG.setBounds(28, 89, 136, 15);
         }
         {
            ComboBoxModel combo1Model = new DefaultComboBoxModel(new String[]
            {"Administrator/in", "Leser/Schreiber/in", "Leser/in"});
            combo1 = new JComboBox();
            getContentPane().add(combo1);
            combo1.setModel(combo1Model);
            combo1.setBounds(28, 110, 142, 21);
            combo1.setSize(142, 22);
         }
         {
            b_gruppeA = new JButton();
            b_gruppeA.addActionListener(new ActionListener()
            {
               public void actionPerformed(ActionEvent evt)
               {
                  JOptionPane.showMessageDialog(null,
                                                "Die Benutzergruppe wurde erfolgreich geändert.",
                                                "Änderung erfolgreich",
                                                JOptionPane.PLAIN_MESSAGE);
                  // JOptionPane.showMessageDialog(null,"Die
                  // Benutzergruppe konnte nicht geändert werden.
                  // Bitte überprüfen Sie die Eingabe.","Änderung
                  // fehlgeschlagen",JOptionPane.ERROR_MESSAGE);

               }
            });


            getContentPane().add(b_gruppeA);
            b_gruppeA.setText("Ändern");
            b_gruppeA.setBounds(197, 153, 107, 22);

         }
         {
            b_abbrechenG = new JButton();
            getContentPane().add(b_abbrechenG);
            b_abbrechenG.setText("Abbrechen");
            b_abbrechenG.setBounds(197, 185, 107, 22);
         }
         pack();
         this.setSize(337, 260);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

}
