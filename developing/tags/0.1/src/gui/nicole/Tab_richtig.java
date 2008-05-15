/**
 * 
 */
package gui.nicole;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
 * @author nicole
 */

public class Tab_richtig extends JFrame
{
   /**
    * 
    */
   private static final long serialVersionUID = 8115523811922997119L;
   private JTable table;
   private JLabel überschrift = new JLabel("");
   private JButton b_BlattZuTab, b_BlattHinzufügen;
   private JLabel jLabel2;
   private JLabel jLabel1;


   /**
    * @throws HeadlessException
    */
   public Tab_richtig() throws HeadlessException
   {
      super("");
      super.addWindowListener(new WindowAdapter()
      {
         // @ Override
         @Override
         public void windowClosing(WindowEvent e)
         {
            System.exit(0);
         }
      });
      super.setContentPane(createContentPane());
      super.setPreferredSize(new Dimension(620, 400));
      super.pack();
      super.setLocation(getCenterOfScreen());
      super.setVisible(true);
      setTitle("Tabelleneigenschaften");
   }


   public static void main(String[] args)
   {
      new Tab_richtig();
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
      panel.setBackground(new Color(255, 140, 0));
      panel.setBorder(new EmptyBorder(0, 5, 5, 0));
      return panel;

      /*
       * TableSorter ts = new TableSorter( new MyTableModel() );
       * ts.setTableHeader( table.getTableHeader() ); JScrollPane
       * srcoll = new JScrollPane( table ); panel.add( srcoll ); {
       * table = new JTable( ts ); panel.add(table,
       * BorderLayout.CENTER); table.setFillsViewportHeight( true ); }
       */
   }


   private JPanel createNORTH()
   {
      JPanel panel = new JPanel(new BorderLayout());
      panel.add(überschrift);
      überschrift.setPreferredSize(new java.awt.Dimension(559, 25));
      überschrift.setText("     Blätterübersicht:");
      return panel;
   }


   private JPanel createEAST()
   {
      JPanel panel = new JPanel(new GridLayout(0, 1));
      JPanel p = new JPanel(new BorderLayout());
      b_BlattZuTab = new JButton("Blatt zu Tabelle");

      b_BlattZuTab.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            BlattZuTab ben = new BlattZuTab();

            int bildschirmBreite = Toolkit.getDefaultToolkit().getScreenSize().width;
            int bildschirmHoehe = Toolkit.getDefaultToolkit().getScreenSize().height;

            int fensterBreite = ben.getWidth();
            int fensterHoehe = ben.getHeight();

            Point p = new Point(bildschirmBreite / 2 - fensterBreite / 2,
                                bildschirmHoehe / 2 - fensterHoehe / 2);
            ben.setLocation(p);
            ben.setVisible(true);
         }
      });
      JButton b_BlattLöschen = new JButton("Blatt löschen");

      b_BlattHinzufügen = new JButton("Blatt hinzufügen");
      b_BlattHinzufügen.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            BlattHinzufügen ben = new BlattHinzufügen();

            int bildschirmBreite = Toolkit.getDefaultToolkit().getScreenSize().width;
            int bildschirmHoehe = Toolkit.getDefaultToolkit().getScreenSize().height;

            int fensterBreite = ben.getWidth();
            int fensterHoehe = ben.getHeight();

            Point p = new Point(bildschirmBreite / 2 - fensterBreite / 2,
                                bildschirmHoehe / 2 - fensterHoehe / 2);
            ben.setLocation(p);
            ben.setVisible(true);
         }
      });
      panel.add(b_BlattHinzufügen);
      panel.add(b_BlattLöschen);
      panel.add(b_BlattZuTab);

      panel.setBorder(new EmptyBorder(5, 5, 5, 5));
      p.add(panel, BorderLayout.SOUTH);

      return p;
   }


   private JPanel createSOUTH()
   {
      JPanel panel = new JPanel(new BorderLayout());
      panel.setPreferredSize(new Dimension(620, 25));
      panel.setLayout(null);
      panel.add(getJLabel1());
      panel.add(getJLabel2());

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
      if(jLabel1 == null)
      {
         jLabel1 = new JLabel();
         jLabel1.setText("Gesamtnote der Tabelle: ");
         jLabel1.setBounds(12, 6, 144, 14);
      }
      return jLabel1;
   }


   private JLabel getJLabel2()
   {
      if(jLabel2 == null)
      {
         jLabel2 = new JLabel();
         jLabel2.setText("Note wird berechnet");
         jLabel2.setBounds(174, 6, 136, 14);
      }
      return jLabel2;
   }

   // @ SuppressWarnings( "serial" )
   private class MyTableModel extends AbstractTableModel
   {
      /**
       * 
       */
      private static final long serialVersionUID = 8125864168809200370L;
      private String[] colNames =
      {"Blattname", "Gewichtung"};


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
