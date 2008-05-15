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
public class GesNote extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = 5576801959866906632L;
   private JLabel l_gesNoteFestlegen;
   private JTextField tf_GesNoteFestlegen;
   private JButton b_gesNoteAbbrechen;
   private JButton b_gesNoteFestlegen;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            GesNote inst = new GesNote();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public GesNote()
   {
      super();
      initGUI();
   }


   private void initGUI()
   {
      try
      {
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setTitle("Gesamtnote festlegen");
         getContentPane().setLayout(null);
         {
            l_gesNoteFestlegen = new JLabel();
            getContentPane().add(l_gesNoteFestlegen);
            l_gesNoteFestlegen.setText("Gesamtnote festlegen:");
            l_gesNoteFestlegen.setBounds(23, 21, 149, 14);
         }
         {
            b_gesNoteFestlegen = new JButton();
            getContentPane().add(b_gesNoteFestlegen);
            b_gesNoteFestlegen.setText("Festlegen");
            b_gesNoteFestlegen.setBounds(163, 87, 127, 21);
         }
         {
            b_gesNoteAbbrechen = new JButton();
            getContentPane().add(b_gesNoteAbbrechen);
            b_gesNoteAbbrechen.setText("Abbrechen");
            b_gesNoteAbbrechen.setBounds(163, 115, 128, 21);
         }
         {
            tf_GesNoteFestlegen = new JTextField();
            getContentPane().add(tf_GesNoteFestlegen);
            tf_GesNoteFestlegen.setBounds(23, 44, 129, 22);
         }
         pack();
         this.setSize(327, 192);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

}
