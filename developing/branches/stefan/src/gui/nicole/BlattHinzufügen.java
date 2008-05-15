package gui.nicole;



import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
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
public class BlattHinzufügen extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = - 5691734826832006181L;
   private ButtonGroup bg_DiagrammArtAuswählen;
   private JLabel l_NamenBlattGewichtung;
   private JButton b_NeuesBlatt;
   private JButton b_NeuesBlattAbbrechen;
   private JTextField tf_BlattGewichtung;
   private JTextField tf_NamenBlattNeu;
   private JLabel l_namenBlattNeu;
   private JLabel l_NeuesBlattDiagramm;
   private JRadioButton rb_DiagrammPunkt;
   private JRadioButton rb_DiagrammBalken;
   private JRadioButton rb_DiagrammKreis;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            BlattHinzufügen inst = new BlattHinzufügen();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public BlattHinzufügen()
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
         setPreferredSize(new java.awt.Dimension(400, 300));
         setTitle("Neues Blatt erstellen");
         {
            rb_DiagrammKreis = new JRadioButton();
            getContentPane().add(rb_DiagrammKreis);
            rb_DiagrammKreis.setText("Kreisdiagramm");
            rb_DiagrammKreis.setBounds(28, 156, 178, 18);

         }
         {
            rb_DiagrammBalken = new JRadioButton();
            getContentPane().add(rb_DiagrammBalken);
            rb_DiagrammBalken.setText("Balkendiagramm");
            rb_DiagrammBalken.setBounds(28, 183, 192, 18);

         }
         {
            rb_DiagrammPunkt = new JRadioButton();
            getContentPane().add(rb_DiagrammPunkt);
            getContentPane().add(getL_NeuesBlattDiagramm());
            getContentPane().add(getL_namenBlattNeu());
            getContentPane().add(getTf_NamenBlattNeu());
            getContentPane().add(getL_NamenBlattGewichtung());
            getContentPane().add(getTf_BlattGewichtung());
            getContentPane().add(getB_NeuesBlattAbbrechen());
            getContentPane().add(getB_NeuesBlatt());
            rb_DiagrammPunkt.setText("Punktdiagramm");
            rb_DiagrammPunkt.setBounds(28, 210, 183, 18);

         }

         /*
          * bg_DiagrammArtAuswählen.add(rb_DiagrammBalken);
          * bg_DiagrammArtAuswählen.add(rb_DiagrammPunkt);
          * bg_DiagrammArtAuswählen.add(rb_DiagrammKreis);
          */
         pack();
         setSize(400, 300);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }

   }


   private ButtonGroup getBg_DiagrammArtAuswählen()
   {
      if(bg_DiagrammArtAuswählen == null)
      {
         bg_DiagrammArtAuswählen = new ButtonGroup();
      }
      return bg_DiagrammArtAuswählen;
   }


   private JLabel getL_NeuesBlattDiagramm()
   {
      if(l_NeuesBlattDiagramm == null)
      {
         l_NeuesBlattDiagramm = new JLabel();
         l_NeuesBlattDiagramm.setText("Diagrammart wählen:");
         l_NeuesBlattDiagramm.setBounds(28, 132, 169, 14);
      }
      return l_NeuesBlattDiagramm;
   }


   private JLabel getL_namenBlattNeu()
   {
      if(l_namenBlattNeu == null)
      {
         l_namenBlattNeu = new JLabel();
         l_namenBlattNeu.setText("Namen des neuen Blattes:");
         l_namenBlattNeu.setBounds(24, 22, 215, 14);
      }
      return l_namenBlattNeu;
   }


   private JTextField getTf_NamenBlattNeu()
   {
      if(tf_NamenBlattNeu == null)
      {
         tf_NamenBlattNeu = new JTextField();
         tf_NamenBlattNeu.setBounds(24, 42, 173, 21);
         tf_NamenBlattNeu.setSize(173, 22);
      }
      return tf_NamenBlattNeu;
   }


   private JLabel getL_NamenBlattGewichtung()
   {
      if(l_NamenBlattGewichtung == null)
      {
         l_NamenBlattGewichtung = new JLabel();
         l_NamenBlattGewichtung.setText("Gewichtung des Blattes:");
         l_NamenBlattGewichtung.setBounds(24, 75, 196, 14);
      }
      return l_NamenBlattGewichtung;
   }


   private JTextField getTf_BlattGewichtung()
   {
      if(tf_BlattGewichtung == null)
      {
         tf_BlattGewichtung = new JTextField();
         tf_BlattGewichtung.setBounds(24, 95, 173, 21);
         tf_BlattGewichtung.setSize(173, 22);
      }
      return tf_BlattGewichtung;
   }


   private JButton getB_NeuesBlattAbbrechen()
   {
      if(b_NeuesBlattAbbrechen == null)
      {
         b_NeuesBlattAbbrechen = new JButton();
         b_NeuesBlattAbbrechen.setText("Abbrechen");
         b_NeuesBlattAbbrechen.setBounds(250, 217, 118, 21);
         b_NeuesBlattAbbrechen.setSize(118, 22);
      }
      return b_NeuesBlattAbbrechen;
   }


   private JButton getB_NeuesBlatt()
   {
      if(b_NeuesBlatt == null)
      {
         b_NeuesBlatt = new JButton();
         b_NeuesBlatt.setText("Erstellen");
         b_NeuesBlatt.setBounds(250, 188, 118, 21);
         b_NeuesBlatt.setSize(118, 22);
      }
      return b_NeuesBlatt;
   }

}
