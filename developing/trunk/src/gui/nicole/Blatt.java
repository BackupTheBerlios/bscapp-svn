/**
 * 
 */
package gui.nicole;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;



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
/**
 * @author nicole
 */

public class Blatt extends JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = - 5957454077461199259L;
   private JTable table;
   private JLabel überschrift = new JLabel("");
   private JLabel l_gesNoteZahl;
   private JButton b_gesNoteFestlegen;
   private JLabel l_gesNote;


   /**
    * @throws HeadlessException
    */
   public Blatt() throws HeadlessException
   {
      super("Benutzer bearbeiten");
      super.addWindowListener(new WindowAdapter()
      {
         @Override
         public void windowClosing(WindowEvent e)
         {
            System.exit(0);
         }
      });
      super.setContentPane(createContentPane());
      setPreferredSize(new java.awt.Dimension(500, 350));
      super.pack();
      this.setSize(500, 306);
      super.setLocation(getCenterOfScreen());
      super.setVisible(true);
      setTitle("Blatteigenschaften");
   }


   public static void main(String[] args)
   {
      new Blatt();
   }


   public JPanel createContentPane()
   {
      JPanel panel = new JPanel(new BorderLayout());
      panel.add(createCENTER(), BorderLayout.CENTER);
      panel.add(createNORTH(), BorderLayout.NORTH);
      panel.add(createEAST(), BorderLayout.EAST);
      panel.add(createSOUTH(), BorderLayout.SOUTH);
      panel.add(createWEST(), BorderLayout.WEST);
      return panel;
   }


   private JPanel createCENTER()
   {
      JPanel panel = new JPanel(new BorderLayout());
      panel.setBorder(new EmptyBorder(0, 5, 5, 5));
      panel.setBackground(new Color(255, 140, 0));
      return panel;

      /*
       * TableSorter ts = new TableSorter( new MyTableModel() ); table =
       * new JTable( ts ); table.setFillsViewportHeight( true );
       * table.setPreferredSize(new java.awt.Dimension(484, 202));
       * ts.setTableHeader( table.getTableHeader() ); JScrollPane
       * srcoll = new JScrollPane(); panel.add( srcoll );
       */
   }


   private JPanel createNORTH()
   {
      JPanel panel = new JPanel(new BorderLayout());
      panel.add(überschrift);
      überschrift.setPreferredSize(new java.awt.Dimension(559, 25));
      überschrift.setText("     Blatteigenschaften:");
      return panel;
   }


   private JPanel createEAST()
   {
      JPanel panel = new JPanel(new BorderLayout());
      return panel;
   }



   private JPanel createSOUTH()
   {
      JPanel panel = new JPanel();
      panel.setPreferredSize(new java.awt.Dimension(492, 54));
      panel.setLayout(null);
      panel.add(getJLabel1());
      panel.add(getJLabel2());
      panel.add(getJButton2());
      return panel;
   }


   private JPanel createWEST()
   {
      JPanel panel = new JPanel(new BorderLayout());
      return panel;
   }


   private Point getCenterOfScreen()
   {
      int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
      int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;

      int windowW = super.getSize().width;
      int windowH = super.getSize().height;

      return new Point(screenW / 2 - windowW / 2, screenH / 2 - windowH / 2);
   }


   private JLabel getJLabel1()
   {
      if(l_gesNote == null)
      {
         l_gesNote = new JLabel();
         l_gesNote.setText("Gesamtnote des Blattes:");
         l_gesNote.setBounds(7, 16, 152, 14);
      }
      return l_gesNote;
   }


   private JLabel getJLabel2()
   {
      if(l_gesNoteZahl == null)
      {
         l_gesNoteZahl = new JLabel();
         l_gesNoteZahl.setText("1.0 - 5.0");
         l_gesNoteZahl.setBounds(165, 16, 67, 13);
      }
      return l_gesNoteZahl;
   }


   private JButton getJButton2()
   {
      if(b_gesNoteFestlegen == null)
      {
         b_gesNoteFestlegen = new JButton();
         b_gesNoteFestlegen.setText("Gesamtnote festlegen");
         b_gesNoteFestlegen.setBounds(311, 18, 163, 21);
         b_gesNoteFestlegen.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               GesNote ben = new GesNote();

               int bildschirmBreite = Toolkit.getDefaultToolkit()
                                             .getScreenSize().width;
               int bildschirmHoehe = Toolkit.getDefaultToolkit()
                                            .getScreenSize().height;

               int fensterBreite = ben.getWidth();
               int fensterHoehe = ben.getHeight();

               Point p = new Point(bildschirmBreite / 2 - fensterBreite / 2,
                                   bildschirmHoehe / 2 - fensterHoehe / 2);
               ben.setLocation(p);
               ben.setVisible(true);
            }
         });
      }
      return b_gesNoteFestlegen;
   }

   // @ SuppressWarnings( "serial" )
   private class MyTableModel extends AbstractTableModel
   {
      /**
       * 
       */
      private static final long serialVersionUID = - 1162537879016320427L;
      private String[] colNames =
      {"Name", "Wert"};


      public MyTableModel()
      {}


      public int getColumnCount()
      {
         return colNames.length;
      }


      // @ Override
      @Override
      public String getColumnName(int col)
      {
         return colNames[col];
      }


      public int getRowCount()
      {
         return 0;
      }


      public Object getValueAt(int row, int col)
      {
         return new Object();
      }


      // @ Override
      @Override
      public Class< ? > getColumnClass(int col)
      {
         return Object.class;
      }


      // @ Override
      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
         return false;
      }
   }
}
