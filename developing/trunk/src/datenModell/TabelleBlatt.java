package datenModell;



import gui.helfer2.DiagrammFactory;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.MutableTreeNode;



/**
 * ein tabellenblatt ist die unterste ebene des datenmodells. hier und
 * nur hier werden die daten gespeichert. es hält bis zu 3 Lists mit
 * typs Point2D.Double, eine List(String), das die labels zu den
 * datenpunkten hält.
 * 
 * @author andre
 */
public class TabelleBlatt extends Tabelle implements Serializable, Bewertbar
{
  private static final long serialVersionUID = - 3728988945622867135L;

  private List<Point2D.Double> werteA;
  private List<Point2D.Double> werteB;
  private List<Point2D.Double> werteC;
  private List<String> labels;
  private double zusammenfassung;


  /**
   * Erzeugt ein neues TabelleBlatt-Objekt und instanziiert die Listen
   * mit den werten
   * 
   * @param titel
   */
  public TabelleBlatt(String titel)
  {
    super(titel);
    zusammenfassung = 1;
    werteA = new ArrayList<Point2D.Double>(0);
    werteB = new ArrayList<Point2D.Double>(0);
    werteC = new ArrayList<Point2D.Double>(0);
    labels = new ArrayList<String>(0);
  }


  /**
   * @return die liste mit datenpunkten von liste A
   */
  public List<Point2D.Double> getWerteA()
  {
    return werteA;
  }


  /**
   * @return die liste mit datenpunkten von liste B
   */
  public List<Point2D.Double> getWerteB()
  {
    return werteB;
  }


  /**
   * @return die liste mit datenpunkten von liste C
   */
  public List<Point2D.Double> getWerteC()
  {
    return werteC;
  }


  /**
   * ersetzt die liste mit datenpunkten von liste A mit der
   * angegebenen liste
   * 
   * @param werteA
   *          die neue liste mit datenpunkten
   */
  public void setWerteA(List<Point2D.Double> werteA)
  {
    this.werteA = werteA;
  }


  /**
   * ersetzt die liste mit datenpunkten von liste B mit der
   * angegebenen liste
   * 
   * @param werteB
   *          die neue liste mit datenpunkten
   */
  public void setWerteB(List<Point2D.Double> werteB)
  {
    this.werteB = werteB;
  }


  /**
   * ersetzt die liste mit datenpunkten von liste C mit der
   * angegebenen liste
   * 
   * @param werteC
   *          die neue liste mit datenpunkten
   */
  public void setWerteC(List<Point2D.Double> werteC)
  {
    this.werteC = werteC;
  }


  @Override
  public final void add(MutableTreeNode tabelle)
  {
  // niemand darf an ein blatt etwas anhängen!
  }


  @Override
  public double getZusammenfassung()
  {
    return zusammenfassung;
  }


  @Override
  public void setZusammenfassung(double zusammenfassung)
  {
    if(zusammenfassung >= 1 && zusammenfassung <= 5)
    {
      this.zusammenfassung = zusammenfassung;
    }
  }


  @SuppressWarnings("serial")
  @Override
  public JPanel getJDiagramm(DiagrammFactory.TYP typ)
  {
    double[] werte = new double[werteA.size()];
    String[] beschriftung = new String[werteA.size()];


    for(int i = 0; i < werteA.size(); i ++ )
    {
      werte[i] = werteA.get(i).x;
      beschriftung[i] = labels.get(i);
    }


    switch(typ)
    {
      case BALKENDIAGRAMM :
        return DiagrammFactory.balkenDiagramm(werte, beschriftung);

      case KREISDIAGRAMM :
        return DiagrammFactory.kreisDiagramm(werte, beschriftung);
    }


    return new JPanel()
    {
      {
        add(new JLabel("PORTFOLIO-Darstellung hier nicht erlaubt!"));
      }
    };
  }


  /**
   * @return the labels
   */
  public List<String> getLabels()
  {
    return labels;
  }
}
