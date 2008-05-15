/**
 * 
 */
package gui.panels.tablemodels;



import gui.frames.SuperFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import datenModell.Bewertbar;
import datenModell.TabelleBlatt;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class BereichOderTabelleModel extends LeeresModel
{
  private final DefaultMutableTreeNode node;


  public BereichOderTabelleModel(Bewertbar node, boolean editable)
  {
    super(editable);
    this.node = (DefaultMutableTreeNode)node;
    colnames = new String[]
    {"Element", "Zusammenfassung", "Priorität"};
    anzahlzeilen = ((DefaultMutableTreeNode)node).getChildCount();
  }


  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex)
  {
    switch(columnIndex)
    {
      case 0 :
        break;
      case 1 :
        if(node.getChildAt(rowIndex) instanceof TabelleBlatt)
        {
          break;
        }
        else
        {
          return false;
        }
    }
    return editable;
  }


  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    switch(columnIndex)
    {
      case 0 :
        return ((Bewertbar)node.getChildAt(rowIndex)).getTitel();
      case 1 :
        return ((Bewertbar)node.getChildAt(rowIndex)).getZusammenfassung();
      default :
        return ((Bewertbar)node.getChildAt(rowIndex)).getPrioritaet();
    }
  }


  @Override
  public void setValueAt(Object value, int rowIndex, int columnIndex)
  {

    switch(columnIndex)
    {
      case 0 :
        ((Bewertbar)node.getChildAt(rowIndex)).setTitel((String)value);
        break;
      case 1 :
      {
        double zus = (Double)value;

        if(zus >= 1 && zus <= 5)
        {
          ((Bewertbar)node.getChildAt(rowIndex)).setZusammenfassung((Double)value);
        }
        else
        {
          SuperFrame.zeigeInfo("Bitte geben Sie einen Wert\n" + "zwischen 1 und 5 ein.",
                               "Wert ungültig");
        }
        break;
      }
      default :
      {
        double zus = (Double)value;

        if(zus >= 0 && zus <= 10)
        {
          ((Bewertbar)node.getChildAt(rowIndex)).setPrioritaet((Double)value);
        }
        else
        {
          SuperFrame.zeigeInfo("Bitte geben Sie einen Wert\n" + "zwischen 0 und 10 ein.",
                               "Wert ungültig");
        }
      }
    }
  }
}
