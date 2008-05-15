/**
 * 
 */
package gui.panels.tablemodels;



import java.util.Arrays;
import javax.swing.table.AbstractTableModel;
import benutzerModell.BenutzerDatenbank;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class BenutzerModel extends AbstractTableModel
{
  private String[] spaltennamen = new String[]
  {"Benutzername", "Benutzergruppe"};


  @Override
  public int getColumnCount()
  {
    return spaltennamen.length;
  }


  @Override
  public int getRowCount()
  {
    return BenutzerDatenbank.datenBankFactory()
                            .getBenutzerDatenbank()
                            .keySet()
                            .size();
  }


  @Override
  public Class< ? > getColumnClass(int columnIndex)
  {
    return String.class;
  }


  @Override
  public String getColumnName(int column)
  {
    return spaltennamen[column];
  }


  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    String[] namen = new String[BenutzerDatenbank.datenBankFactory()
                                                 .getBenutzerDatenbank()
                                                 .size()];

    int i = 0;
    for(String s : BenutzerDatenbank.datenBankFactory()
                                    .getBenutzerDatenbank()
                                    .keySet())
    {
      namen[i] = s;
      i ++ ;
    }

    Arrays.sort(namen, String.CASE_INSENSITIVE_ORDER);

    switch(columnIndex)
    {
      case 0 :
        return (String)namen[rowIndex];
      default :
        return (String)BenutzerDatenbank.datenBankFactory()
                                        .getBenutzerDatenbank()
                                        .get(namen[rowIndex])
                                        .getGruppe()
                                        .toString();
    }
  }
}
