package gui.frames;




import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



/**
 * von dieser klasse solle abgeleitet werden wenn ein jframe erstellt
 * werden soll, das:
 * <li> ActionListener implementiert, und/oder
 * <li> ChangeListener implementiert, und/oder
 * <li> ListSelectionListener implementiert, und/oder
 * <li> MouseListener implementiert.
 * <p>
 * <br>
 * ausserdem
 * <li> hat es hat dann ein BorderLayout, wessen panels auch alle ein
 * BorderLayout besitzen: center, north, south, east und west,
 * <li> setzt es sich selbst auf die bildschirmmitte
 * <li> nimmt es das look and feel des systems an.
 * <li> fragt es beim schliessen, ob beendet werden soll.
 * 
 * @author ragg andre
 */
public class SuperFrame extends JFrame implements
                                       ActionListener,
                                       ChangeListener,
                                       ListSelectionListener,
                                       MouseListener
{
   /**
    * 
    */
   private static final long serialVersionUID = - 7262201416241436060L;
   /**
    * das jpanel im center-bereich des BorderLayouts, hat defaultmäßig
    * ein BorderLayout
    */
   protected JPanel center = new JPanel(new BorderLayout());
   /**
    * das jpanel im north-bereich des BorderLayouts, hat defaultmäßig
    * ein BorderLayout
    */
   protected JPanel north = new JPanel(new BorderLayout());
   /**
    * das jpanel im east-bereich des BorderLayouts, hat defaultmäßig
    * ein BorderLayout
    */
   protected JPanel east = new JPanel(new BorderLayout());
   /**
    * das jpanel im south-bereich des BorderLayouts, hat defaultmäßig
    * ein BorderLayout
    */
   protected JPanel south = new JPanel(new BorderLayout());
   /**
    * das jpanel im west-bereich des BorderLayouts, hat defaultmäßig
    * ein BorderLayout
    */
   protected JPanel west = new JPanel(new BorderLayout());

   /**
    * das ist die größe des JFrames. default ist 800 * 600 pixel.
    * diese wird in der zeigeMittig() methode verwendet.
    */
   protected Dimension size = new Dimension(800, 600);


   /**
    * erzeugt alle elemnte, die nötig sind zum einfügen des jframes.
    * 
    * @param sofortAnzeigen
    *           wenn true, dann wird das jframe mit den
    *           defaultabmessungen auf dem bildschirm angezeigt.
    */
   public SuperFrame()
   {
      super();
      super.setTitle(this.getClass().getName());
      super.setContentPane(erzeugeContentPane());
      super.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

      setzeSystemLookAndFeel();
      setzeWindowListener(this);
   }


   /**
    * packt das jframe, setzt es auf die bildschirmmitte, definiert
    * die größe des fensters, und setzt es visible(true)
    */
   protected void zeige()
   {
      super.setPreferredSize(size);
      super.pack();
      super.setLocation(getMitte(this));
      super.setVisible(true);
   }


   private JPanel erzeugeContentPane()
   {
      JPanel panel = new JPanel(new BorderLayout());
      panel.add(center, BorderLayout.CENTER);
      panel.add(north, BorderLayout.NORTH);
      panel.add(east, BorderLayout.EAST);
      panel.add(south, BorderLayout.SOUTH);
      panel.add(west, BorderLayout.WEST);
      return panel;
   }


   private static Point getMitte(JFrame jframe)
   {
      int bildschirmBreite = Toolkit.getDefaultToolkit().getScreenSize().width;
      int bildschirmHoehe = Toolkit.getDefaultToolkit().getScreenSize().height;

      int fensterBreite = jframe.getSize().width;
      int fensterHoehe = jframe.getSize().height;

      return new Point(bildschirmBreite / 2 - fensterBreite / 2,
                       bildschirmHoehe / 2 - fensterHoehe / 2);
   }


   @SuppressWarnings("unused")
   private void setzeSystemLookAndFeel()
   {
      try
      {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }


   private void setzeWindowListener(final JFrame frame)
   {
      WindowListener windowlistener;

      windowlistener = new WindowAdapter()
      {
         @Override
         public void windowClosing(WindowEvent e)
         {
            if(SuperFrame.frageTrueFalse("Wollen Sie das Programm beenden?",
                                          "Programm beenden"))
            {
               System.exit(0);
            }
         }
      };

      frame.addWindowListener(windowlistener);
   }


   /**
    * zeigt eine errormessage mit joptionpane an
    * 
    * @param message
    *           die meldung
    * @param title
    *           die überschrift
    */
   public static void zeigeError(Object message, String title)
   {
      JOptionPane.showMessageDialog(null,
                                    message,
                                    title,
                                    JOptionPane.ERROR_MESSAGE);
   }


   /**
    * zeigt eine exception mit joptionpane an
    * 
    * @param message
    *           die meldung
    * @param title
    *           die überschrift
    * @param e
    *           die exception
    */
   @SuppressWarnings("serial")
   public static void zeigeException(String message, final Exception exc)
   {
      final String msg = message == null ? "" : message;

      JPanel error = new JPanel(new BorderLayout());

      error.add(new JTextArea()
      {
         {
            setText(msg);
         }
      }, BorderLayout.NORTH);

      error.add(new JScrollPane(new JTextArea()
      {
         {
            append("Technische Information:\n\nFehlertyp:");
            append(exc.getMessage() + "\n\nFehlerursprung:");

            for(StackTraceElement element : exc.getStackTrace())
            {
               append(element.toString() + "\n");
            }
         }
      }));

      zeigeError(error, "Ausnahmefehler!");
   }


   /**
    * zeigt eine infomessage mit joptionpane an
    * 
    * @param message
    *           die meldung
    * @param title
    *           die überschrift
    */
   public static void zeigeInfo(Object message, String title)
   {
      JOptionPane.showMessageDialog(null,
                                    message,
                                    title,
                                    JOptionPane.INFORMATION_MESSAGE);
   }


   /**
    * zeigt eine frage mit joptionpane an.
    * 
    * @param message
    *           die frage
    * @param title
    *           die überschrift
    * @return true wenn auf yes geklickt wurde, sonst false
    */
   public static boolean frageTrueFalse(Object message, String title)
   {
      int erg = JOptionPane.showConfirmDialog(null,
                                              message,
                                              title,
                                              JOptionPane.YES_NO_OPTION,
                                              JOptionPane.QUESTION_MESSAGE);
      if(erg == JOptionPane.YES_OPTION)
      {
         return true;
      }
      else
      {
         return false;
      }
   }


   /**
    * setzt dem angegebenen JComponent-Objekt einen titledborder mit
    * dem angegebenen titel ein
    * 
    * @param comp
    *           das zu betitelnde JComponent-Objekt
    * @param titel
    *           der titel
    */
   public static void betitle(JComponent comp, String titel)
   {
      comp.setBorder(BorderFactory.createTitledBorder(titel));
   }


   /*
    * (non-Javadoc)
    * 
    * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
    */
   @Override
   public void valueChanged(ListSelectionEvent e)
   {}


   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   public void actionPerformed(ActionEvent e)
   {}


   /*
    * (non-Javadoc)
    * 
    * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
    */
   public void stateChanged(ChangeEvent e)
   {}


   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseClicked(MouseEvent e)
   {}


   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseEntered(MouseEvent e)
   {}


   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseExited(MouseEvent e)
   {}


   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
    */
   @Override
   public void mousePressed(MouseEvent e)
   {}


   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseReleased(MouseEvent e)
   {}


   /**
    * @return the center
    */
   public JPanel getCenter()
   {
      return center;
   }


   /**
    * @return the north
    */
   public JPanel getNorth()
   {
      return north;
   }


   /**
    * @return the east
    */
   public JPanel getEast()
   {
      return east;
   }


   /**
    * @return the south
    */
   public JPanel getSouth()
   {
      return south;
   }


   /**
    * @return the west
    */
   public JPanel getWest()
   {
      return west;
   }


   /**
    * @param center the center to set
    */
   public void setCenter(JPanel center)
   {
      this.center = center;
   }


   /**
    * @param north the north to set
    */
   public void setNorth(JPanel north)
   {
      this.north = north;
   }


   /**
    * @param east the east to set
    */
   public void setEast(JPanel east)
   {
      this.east = east;
   }


   /**
    * @param south the south to set
    */
   public void setSouth(JPanel south)
   {
      this.south = south;
   }


   /**
    * @param west the west to set
    */
   public void setWest(JPanel west)
   {
      this.west = west;
   }
}
