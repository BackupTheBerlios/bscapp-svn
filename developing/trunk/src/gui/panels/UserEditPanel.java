/**
 * 
 */
package gui.panels;



import gui.panels.tablemodels.BenutzerModel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class UserEditPanel extends JPanel
{
  private BenutzerModel model;

  private JTable table;


  public UserEditPanel()
  {
    super(new BorderLayout());
    model = new BenutzerModel();
    table = new JTable(model);

    add(new JLabel("Hier können Sie die Benutzer bearbeiten:"),
        BorderLayout.NORTH);
    add(new JScrollPane(table), BorderLayout.CENTER);
  }


  /**
   * 
   * @see javax.swing.table.AbstractTableModel#fireTableStructureChanged()
   */
  public void fireTableStructureChanged()
  {
    model.fireTableStructureChanged();
  }
}
