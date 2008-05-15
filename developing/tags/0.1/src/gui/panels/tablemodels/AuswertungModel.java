/**
 * 
 */
package gui.panels.tablemodels;



import datenModell.Auswertung;
import datenModell.Bereich;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class AuswertungModel extends LeeresModel
{
  public AuswertungModel(boolean editable)
  {
    super(editable);
    anzahlzeilen = Auswertung.getInstanz().getChildCount();
    colnames = new String[]
    {"Bereich", "Kundenpriorität", "Vergleichspriorität", "Zusammenfassung"};
  }


  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex)
  {
    if(columnIndex == 3)
    {
      return false;
    }
    return editable;
  }


  @Override
  public int getRowCount()
  {
    anzahlzeilen = Auswertung.getInstanz().getChildCount();
    return super.getRowCount();
  }


  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    switch(columnIndex)
    {
      case 0 :
        return ((Bereich)Auswertung.getInstanz().getChildAt(rowIndex)).getTitel();
      case 1 :
        return ((Bereich)Auswertung.getInstanz().getChildAt(rowIndex)).getKoordinate().x;
      case 2 :
        return ((Bereich)Auswertung.getInstanz().getChildAt(rowIndex)).getKoordinate().y;
      default :
        return ((Bereich)Auswertung.getInstanz().getChildAt(rowIndex)).getZusammenfassung();
    }
  }


  @Override
  public void setValueAt(Object value, int rowIndex, int columnIndex)
  {
    switch(columnIndex)
    {
      case 0 :
        ((Bereich)Auswertung.getInstanz().getChildAt(rowIndex)).setTitel((String)value);
        break;
      case 1 :
        ((Bereich)Auswertung.getInstanz().getChildAt(rowIndex)).getKoordinate().x = (Double)value;
        break;
      case 2 :
        ((Bereich)Auswertung.getInstanz().getChildAt(rowIndex)).getKoordinate().x = (Double)value;
    }
  }
}
