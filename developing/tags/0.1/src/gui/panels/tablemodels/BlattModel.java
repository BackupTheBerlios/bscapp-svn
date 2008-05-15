/**
 * 
 */
package gui.panels.tablemodels;



import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import datenModell.TabelleBlatt;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class BlattModel extends LeeresModel
{
  private final TabelleBlatt blatt;
  private final List<Point2D.Double> numbers;
  private final List<String> labels;


  public BlattModel(TabelleBlatt node, boolean editable)
  {
    super(editable);

    blatt = node;
    numbers = blatt.getWerteA();

    if(blatt.getLabels() == null)
    {
      labels = new ArrayList<String>(0);
    }
    else
    {
      labels = blatt.getLabels();
    }
    anzahlzeilen = numbers.size() >= labels.size() ? numbers.size()
                                                  : labels.size();
  }


  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    switch(columnIndex)
    {
      case 0 :
        return labels.get(rowIndex);
      case 1 :
        return numbers.get(rowIndex).x;
      default :
        return numbers.get(rowIndex).y;
    }
  }


  @Override
  public void setValueAt(Object value, int rowIndex, int columnIndex)
  {
    if( ! editable)
    {
      return;
    }

    switch(columnIndex)
    {
      case 0 :
        labels.add(rowIndex, (String)value);
        break;
      case 1 :
        numbers.get(rowIndex).x = (Double)value;
        break;
      default :
        numbers.get(rowIndex).y = (Double)value;
        break;
    }
  }
}
