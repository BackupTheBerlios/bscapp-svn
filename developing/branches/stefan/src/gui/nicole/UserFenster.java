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
public class UserFenster extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = 570674818674802326L;
   private JMenuBar userMenuBar;
   private JMenu jMenu1;
   private JMenuItem jMenuItem1;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            UserFenster inst = new UserFenster();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public UserFenster()
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
            userMenuBar = new JMenuBar();
            setJMenuBar(userMenuBar);
            {
               jMenu1 = new JMenu();
               userMenuBar.add(jMenu1);
               jMenu1.setPreferredSize(new java.awt.Dimension(128, 19));
               jMenu1.setText("Eigene Einstellungen");
               {
                  jMenuItem1 = new JMenuItem();
                  jMenu1.add(jMenuItem1);
                  jMenuItem1.setText("Passwort ändern");
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
