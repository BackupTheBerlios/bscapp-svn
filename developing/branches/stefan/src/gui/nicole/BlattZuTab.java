package gui.nicole;



import javax.swing.JButton;
import javax.swing.JLabel;
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
public class BlattZuTab extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = - 8070606579700826117L;
   private JButton b_BzuT_hinzufügen;
   private JButton b_BzuT_abbrechen;
   private JLabel l_Tabgewichtung;
   private JLabel l_TabName;
   private JTextField tf_TabGewichtung;
   private JTextField tf_TabName;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            BlattZuTab inst = new BlattZuTab();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public BlattZuTab()
   {
      super();
      initGUI();
   }


   private void initGUI()
   {
      try
      {
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setTitle("Blatt zur Tabelle");
         getContentPane().setLayout(null);
         {
            b_BzuT_hinzufügen = new JButton();
            getContentPane().add(b_BzuT_hinzufügen);
            b_BzuT_hinzufügen.setText("Tabelle generieren");
            b_BzuT_hinzufügen.setBounds(227, 146, 142, 22);
         }
         {
            b_BzuT_abbrechen = new JButton();
            getContentPane().add(b_BzuT_abbrechen);
            b_BzuT_abbrechen.setText("Abbrechen");
            b_BzuT_abbrechen.setBounds(227, 175, 142, 21);
         }
         {
            tf_TabName = new JTextField();
            getContentPane().add(tf_TabName);
            tf_TabName.setBounds(24, 54, 173, 21);
            tf_TabName.setSize(173, 22);
         }
         {
            tf_TabGewichtung = new JTextField();
            getContentPane().add(tf_TabGewichtung);
            tf_TabGewichtung.setBounds(24, 114, 173, 21);
            tf_TabGewichtung.setSize(173, 22);
         }
         {
            l_TabName = new JLabel();
            getContentPane().add(l_TabName);
            l_TabName.setText("Tabellenname:");
            l_TabName.setBounds(24, 33, 135, 15);
         }
         {
            l_Tabgewichtung = new JLabel();
            getContentPane().add(l_Tabgewichtung);
            l_Tabgewichtung.setText("Tabellengewichtung:");
            l_Tabgewichtung.setBounds(24, 94, 173, 14);
         }
         pack();
         this.setSize(398, 248);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

}
