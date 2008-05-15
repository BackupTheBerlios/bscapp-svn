package gui.nicole;



import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
public class SchreiberFenster extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = 3111854941251394124L;
   private JMenuBar jMenuBar1;
   private JMenuItem mi_PasswortÄndern;
   private JMenu jMenu1;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            SchreiberFenster inst = new SchreiberFenster();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public SchreiberFenster()
   {
      super();
      initGUI();
   }


   private void initGUI()
   {
      try
      {
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setTitle("Die BSC der HTL Spengergasse");
         {
            jMenuBar1 = new JMenuBar();
            setJMenuBar(jMenuBar1);
            {
               jMenu1 = new JMenu();
               jMenuBar1.add(jMenu1);
               jMenu1.setText("Eigene Einstellungen");
               jMenu1.setPreferredSize(new java.awt.Dimension(131, 21));
               {
                  mi_PasswortÄndern = new JMenuItem();
                  jMenu1.add(mi_PasswortÄndern);
                  mi_PasswortÄndern.setText("Passwort ändern");
               }
            }
         }
         pack();
         this.setSize(620, 400);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

}
