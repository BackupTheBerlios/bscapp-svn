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
public class AdminFenster extends javax.swing.JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = 5554950782055069074L;
   private JMenuBar jMenuBar1;
   private JMenu m_daten;
   private JMenuItem mi_passwortÄndern;
   private JMenu m_eigene;
   private JMenu m_user;


   /**
    * Auto-generated main method to display this JFrame
    */
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable()
      {
         public void run()
         {
            AdminFenster inst = new AdminFenster();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
         }
      });
   }


   public AdminFenster()
   {
      super();
      initGUI();
   }


   private void initGUI()
   {
      try
      {
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setTitle("Administratorbereich");
         {
            jMenuBar1 = new JMenuBar();
            setJMenuBar(jMenuBar1);
            {
               m_user = new JMenu();
               jMenuBar1.add(m_user);
               m_user.setText("Benutzer");
               m_user.setPreferredSize(new java.awt.Dimension(62, 23));
            }
            {
               m_daten = new JMenu();
               jMenuBar1.add(m_daten);
               m_daten.setText("Daten");
               m_daten.setPreferredSize(new java.awt.Dimension(44, 23));
            }
            {
               m_eigene = new JMenu();
               jMenuBar1.add(m_eigene);
               m_eigene.setText("Eigene Einstellungen");
               {
                  mi_passwortÄndern = new JMenuItem();
                  m_eigene.add(mi_passwortÄndern);
                  mi_passwortÄndern.setText("Passwort ändern");
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
