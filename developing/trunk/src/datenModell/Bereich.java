package datenModell;



import gui.helfer.DiagrammFactory.TYP;
import java.awt.geom.Point2D;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;



public class Bereich extends DefaultMutableTreeNode implements
                                                   Serializable,
                                                   Comparable<Bereich>,
                                                   Bewertbar
{
  private static final long serialVersionUID = 1237738469520669948L;
  
  private Point2D.Double koordinate;
  private double prioritaet;


  public Bereich(String titel)
  {
    super(titel);
    koordinate = new Point2D.Double();
  }


  public String getTitel()
  {
    return (String)super.getUserObject();
  }


  public void setTitel(String titel)
  {
    super.setUserObject(titel);
  }


  /**
   * @return the koordinate
   */
  public Point2D.Double getKoordinate()
  {
    return koordinate;
  }


  /**
   * Gibt die position des bereichs in der portfoliodarstellung
   * zurück.
   * 
   * @return die koordinate in form eines Point2D.Double - objekts
   */
  public void setKoordinate(Point2D.Double koordinate)
  {
    this.koordinate = koordinate;
  }


  /**
   * gibt die größe zurück, mit der dieser bereich im portfolio
   * dargestellt wird.
   * 
   * @return die größe
   */
  public int getGroessePortfolio()
  {
    return 10;
  }


  @Override
  public void add(MutableTreeNode tabelle)
  {
    if(tabelle instanceof Tabelle)
    {
      super.add(tabelle);
    }
  }


  @Override
  public void remove(MutableTreeNode tabelle)
  {
    super.remove(tabelle);
  }


  @Override
  public int compareTo(Bereich b)
  {
    return getTitel().compareTo(b.getTitel());
  }


  /* (non-Javadoc)
   * @see datenModell.Bewertbar#getJDiagramm(gui.helfer.DiagrammFactory.TYP)
   */
  @Override
  public JPanel getJDiagramm(TYP typ)
  {
    // TODO Auto-generated method stub
    return null;
  }


  /* (non-Javadoc)
   * @see datenModell.Bewertbar#getPrioritaet()
   */
  @Override
  public double getPrioritaet()
  {
    return 0;
  }


  /* (non-Javadoc)
   * @see datenModell.Bewertbar#getZusammenfassung()
   */
  @Override
  public double getZusammenfassung()
  {
    // TODO Auto-generated method stub
    return 0;
  }


  /* (non-Javadoc)
   * @see datenModell.Bewertbar#setPrioritaet(double)
   */
  @Override
  public void setPrioritaet(double prioritaet)
  {
    // TODO Auto-generated method stub
    
  }


  /* (non-Javadoc)
   * @see datenModell.Bewertbar#setZusammenfassung(double)
   */
  @Override
  public void setZusammenfassung(double zusammenfassung)
  {
    // TODO Auto-generated method stub
    
  }
}
