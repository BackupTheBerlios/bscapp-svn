/**
 * 
 */
package gui.test;



import java.awt.Dimension;
import java.awt.geom.Point2D;
import javax.swing.JTabbedPane;
import gui.helfer.DiagrammFactory;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class TesteDiagrammFactory extends AndresJFrame
{

  /**
   * @param sofortAnzeigen
   */
  public TesteDiagrammFactory()
  {
    super(false);
    super.setSize(new Dimension(800, 600));

    double[] values =
    {0.2, 4, 10, 0.4, 1, 6};
    String[] labels =
    {"klein, x=+40 ,y=+40",
     "klein, x=+40 ,y=-40",
     "klein, x=-40 ,y=+40",
     "klein, x=-40 ,y=-40",
     "45345",
     "xxxxxxxxxx"};

    JTabbedPane tab = new JTabbedPane();
    center.add(tab);


    // erzeugSimpleBalken( double[] values, String[] labels )
    tab.add("erzeugeSimpleBalken", DiagrammFactory.balkenDiagramm(values,
                                                                  labels));


    // erzeugePieChart( double[] values, String[] labels )
    tab.add("erzeugePieChart", DiagrammFactory.kreisDiagramm(values, labels));


    // erzeugeBubbleChart( Point2D.Double[] koordinaten, int[]
    // groessen, String[] labels )
    Point2D.Double[] koordinaten =
    {new Point2D.Double(40, 40),
     new Point2D.Double(40, - 40),
     new Point2D.Double( - 40, 40),
     new Point2D.Double( - 40, - 40)};

    int[] groessen =
    {50, 50, 50, 50};

    tab.add("erzeugeBubbleChart",
            DiagrammFactory.portfolioDiagramm(koordinaten, groessen, labels));

    zeigeMittig();
  }


  public static void main(String[] args)
  {
    new TesteDiagrammFactory();
  }

}
