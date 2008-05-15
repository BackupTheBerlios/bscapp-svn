package gui.nicole;



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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
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
 * <li> fragt es beim schliessen, ob beendet werden soll. //@author
 * andre
 */
public class AndresJFrame extends JFrame implements
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
    * //@param sofortAnzeigen wenn true, dann wird das jframe mit den
    * defaultabmessungen auf dem bildschirm angezeigt.
    */
   public AndresJFrame(boolean sofortAnzeigen)
   {
      super();
      super.setTitle(this.getClass().getName());
      super.setContentPane(erzeugeContentPane());
      super.setPreferredSize(new Dimension(800, 600));

      setzeSystemLookAndFeel();
      setzeWindowListener(this);

      if(sofortAnzeigen)
      {
         zeigeMittig();
      }
   }


   /**
    * packt das jframe, setzt es auf die bildschirmmitte, definiert
    * die größe des fensters, und setzt es visible(true)
    */
   protected void zeigeMittig()
   {
      super.pack();
      super.setLocation(getMitte());
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


   private Point getMitte()
   {
      int bildschirmBreite = Toolkit.getDefaultToolkit().getScreenSize().width;
      int bildschirmHoehe = Toolkit.getDefaultToolkit().getScreenSize().height;

      int fensterBreite = super.getSize().width;
      int fensterHoehe = super.getSize().height;

      return new Point(bildschirmBreite / 2 - fensterBreite / 2,
                       bildschirmHoehe / 2 - fensterHoehe / 2);
   }


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
         // @ Override
         @Override
         public void windowClosing(WindowEvent e)
         {
            int i = JOptionPane.showConfirmDialog(frame,
                                                  "Wollen Sie das Programm beenden?",
                                                  "Programm beenden",
                                                  JOptionPane.YES_NO_OPTION,
                                                  JOptionPane.QUESTION_MESSAGE);
            if(i == JOptionPane.YES_OPTION)
            {
               System.exit(0);
            }
         }
      };

      frame.addWindowListener(windowlistener);
   }


   /*
    * (non-Javadoc) //@see
    * javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
    */
   // @ Override
   public void valueChanged(ListSelectionEvent e)
   {}


   /*
    * (non-Javadoc) //@see
    * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   public void actionPerformed(ActionEvent e)
   {}


   /*
    * (non-Javadoc) //@see
    * javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
    */
   public void stateChanged(ChangeEvent e)
   {}


   /*
    * (non-Javadoc) //@see
    * java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
    */
   // @ Override
   public void mouseClicked(MouseEvent e)
   {}


   /*
    * (non-Javadoc) //@see
    * java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
    */
   // @ Override
   public void mouseEntered(MouseEvent e)
   {}


   /*
    * (non-Javadoc) //@see
    * java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
    */
   // @ Override
   public void mouseExited(MouseEvent e)
   {}


   /*
    * (non-Javadoc) //@see
    * java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
    */
   // @ Override
   public void mousePressed(MouseEvent e)
   {}


   /*
    * (non-Javadoc) //@see
    * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
    */
   // @ Override
   public void mouseReleased(MouseEvent e)
   {}
}
