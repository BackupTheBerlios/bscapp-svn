package gui.panels.tablemodels;



import javax.swing.table.AbstractTableModel;



@SuppressWarnings("serial")
public class LeeresModel extends AbstractTableModel
{
  protected final boolean editable;

  protected int anzahlzeilen = 0;

  protected String[] colnames = new String[]
  {"Label", "Wert 1", "Wert 2"};


  protected LeeresModel(boolean editable)
  {
    this.editable = editable;
  }


  public LeeresModel()
  {
    this.editable = false;
  }


  public int getColumnCount()
  {
    return colnames.length;
  }


  @Override
  public String getColumnName(int column)
  {
    return colnames[column];
  }


  @Override
  public Class< ? > getColumnClass(int columnIndex)
  {
    switch(columnIndex)
    {
      case 0 :
        return String.class;
      default :
        return Double.class;
    }
  }


  public int getRowCount()
  {
    return anzahlzeilen;
  }


  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex)
  {
    return editable;
  }


  public Object getValueAt(int rowIndex, int columnIndex)
  {
    return null;
  }

}
