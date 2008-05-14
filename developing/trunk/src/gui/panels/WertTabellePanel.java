/**
 * 
 */
package gui.panels;



import gui.frames.FrameLeser;
import gui.frames.FrameSchreiber;
import gui.frames.SuperFrame;
import gui.helfer.TableSorter;
import gui.panels.tablemodels.AuswertungModel;
import gui.panels.tablemodels.BlattModel;
import gui.panels.tablemodels.LeeresModel;
import gui.panels.tablemodels.BereichOderTabelleModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import datenModell.Auswertung;
import datenModell.Bereich;
import datenModell.Bewertbar;
import datenModell.TabelleBlatt;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class WertTabellePanel extends JPanel
{
  private final FrameLeser frame;
  private final boolean editable;


  private static LeeresModel LEERES_MODEL = new LeeresModel();

  private JTable table;

  private AbstractTableModel tablemodel;
  private DefaultMutableTreeNode aktuellernode = null;

  private JPanel inputfields = new JPanel();
  private JScrollPane scroller;


  /**
   * @param frame
   */
  public WertTabellePanel(FrameLeser frame)
  {
    super(new BorderLayout());
    this.frame = frame;

    if(this.frame instanceof FrameSchreiber)
    {
      editable = true;
    }
    else
    {
      editable = false;
    }

    setNode(null);
    table = new JTable(tablemodel);
    scroller = new JScrollPane(table);
    add(scroller, BorderLayout.CENTER);
  }


  private void fuegeInputFieldsEin()
  {
    if( ! editable || tablemodel.equals(LEERES_MODEL))
    {
      remove(inputfields);
      return;
    }


    if(aktuellernode instanceof TabelleBlatt)
    {

      final TabelleBlatt blatt = (TabelleBlatt)aktuellernode;

      final JTextField label = new JTextField("")
      {
        {
          setPreferredSize(new Dimension(200, 22));
        }
      };
      final JTextField xwert = new JTextField("");
      final JTextField ywert = new JTextField("");


      final ActionListener listener = new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          Double x = null;
          Double y = null;

          if(label.getText().length() == 0 || xwert.getText().length() == 0)
          {
            String msg = "Bitte das Label und Wert 1 ausfüllen!";
            SuperFrame.zeigeInfo(msg, "Neuer Datenpunkt");
          }
          else
          {
            try
            {
              x = Double.parseDouble(xwert.getText());
              if(ywert.getText().length() != 0)
              {
                y = Double.parseDouble(ywert.getText());
              }
              else
              {
                y = 0.0;
              }
            }
            catch(Exception exc)
            {
              String msg = "Ungültiger Wert!\nBitte Punkt als Dezimaltrennzeichen verwenden!";
              SuperFrame.zeigeError(msg, "Neuer Datenpunkt");
              return;
            }

            blatt.getWerteA().add(new Point2D.Double(x, y));
            blatt.getLabels().add(label.getText());

            setNode(aktuellernode);
          }
        }
      };

      remove(inputfields);
      inputfields = new JPanel(new BorderLayout())
      {
        {
          add(new JLabel("Hier können sie einen neuen Datenpunkt einfügen:"),
              BorderLayout.NORTH);

          add(new JPanel(new GridLayout(0, 2))
          {
            {
              add(new JLabel("Label"));
              add(label);
              add(new JLabel("Wert 1"));
              add(xwert);
              add(new JLabel("Wert 2"));
              add(ywert);
              setBorder(new EmptyBorder(5, 100, 5, 100));
            }
          }, BorderLayout.EAST);

          add(new JPanel(new BorderLayout())
          {
            {
              add(new JButton("Neuen Datenpunkt einfügen")
              {
                {
                  addActionListener(listener);
                }
              }, BorderLayout.EAST);
            }
          }, BorderLayout.SOUTH);

          setBorder(new EmptyBorder(9, 9, 9, 9));
        }
      };

      add(inputfields, BorderLayout.SOUTH);

      return;

    }// ende von if(aktuellernode instanceof TabelleBlatt)

  }


  public void doLayout2()
  {
    fuegeInputFieldsEin();

    if(aktuellernode != null)
    {
      if( ! (aktuellernode instanceof TabelleBlatt))
      {
        remove(inputfields);
      }
    }

    if(table != null)
    {
      remove(scroller);
      table = new JTable(tablemodel);
      scroller = new JScrollPane(table);
      add(scroller, BorderLayout.CENTER);
    }
    frame.refreshHard();
  }


  /**
   * @param lastSelectedPathComponent
   */
  public void setNode(DefaultMutableTreeNode node)
  {
    aktuellernode = node;

    if(node == null)
    {
      tablemodel = LEERES_MODEL;
    }


    else if(node instanceof Auswertung)
    {
      tablemodel = new AuswertungModel(editable);
    }


    else if(node instanceof TabelleBlatt)
    {
      tablemodel = new BlattModel((TabelleBlatt)node, editable);
    }


    else
    {
      tablemodel = new BereichOderTabelleModel((Bewertbar)node, editable);
    }

    tablemodel.fireTableStructureChanged();

    doLayout2();
  }
}
