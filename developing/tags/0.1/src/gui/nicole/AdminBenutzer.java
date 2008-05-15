/**
 * 
 */
package gui.nicole;



import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
 * @author andre
 */
 @ SuppressWarnings( "serial" )
public class AdminBenutzer extends JFrame
{
   private JTable table;
   private JLabel überschrift = new JLabel("Hier werden Benutzerkonten angelegt und bearbeitet.");
   private JButton löschen, ändernPasswort, neu, gruppeÄndern;
   // @ SuppressWarnings( "unused" )
   private JTextField statusLeiste = new JTextField("Status: ");


   /**
    * @throws HeadlessException
    */
   public AdminBenutzer() throws HeadlessException
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
      super.setPreferredSize(new Dimension(620, 400));
      super.pack();
      super.setLocation(getCenterOfScreen());
      super.setVisible(true);
   }


   public static void main(String[] args)
   {
      new AdminBenutzer();
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
      TableSorter ts = new TableSorter(new MyTableModel());
      table = new JTable(ts);
      table.setFillsViewportHeight(true);
      ts.setTableHeader(table.getTableHeader());
      JScrollPane srcoll = new JScrollPane(table);
      panel.add(srcoll);
      panel.setBorder(new EmptyBorder(0, 5, 5, 0));
      return panel;
   }


   private JPanel createNORTH()
   {
      JPanel panel = new JPanel(new BorderLayout());
      panel.add(überschrift);
      überschrift.setPreferredSize(new java.awt.Dimension(559, 25));
      überschrift.setText("     Benutzerübersicht:");
      return panel;
   }


   private JPanel createEAST()
   {
      JPanel panel = new JPanel(new GridLayout(0, 1));
      JPanel p = new JPanel(new BorderLayout());
      // private JButton löschen, ändernPasswort, neu, gruppeÄndern;
      löschen = new JButton("Benutzer löschen");
      löschen.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            JOptionPane.showConfirmDialog(null,
                                          "Möchten Sie den ausgewählten Benutzer wirklich löschen?",
                                          "Benutzer löschen",
                                          JOptionPane.YES_NO_CANCEL_OPTION,
                                          JOptionPane.QUESTION_MESSAGE);
         }
      });
      ändernPasswort = new JButton("Passwort ändern");
      neu = new JButton("Neuer Benutzer");

      gruppeÄndern = new JButton("Gruppe ändern");
      panel.add(neu);
      panel.add(löschen);

      panel.add(ändernPasswort);
      ändernPasswort.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            PasswortÄndern ben = new PasswortÄndern();

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

      neu.setText("Benutzer anlegen");
      neu.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            neuerBenutzer ben = new neuerBenutzer();

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
      panel.add(gruppeÄndern);
      gruppeÄndern.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent evt)
         {
            GruppeÄndern ben = new GruppeÄndern();

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
      panel.setBorder(new EmptyBorder(5, 5, 5, 5));
      p.add(panel, BorderLayout.SOUTH);

      return p;
   }


   private JPanel createSOUTH()
   {
      JPanel panel = new JPanel(new BorderLayout());
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

   // @ SuppressWarnings( "serial" )
   private class MyTableModel extends AbstractTableModel
   {
      /**
       * 
       */
      private static final long serialVersionUID = - 8949697799483016694L;
      private String[] colNames =
      {"Benutzername", "Benuzergruppe"};


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
