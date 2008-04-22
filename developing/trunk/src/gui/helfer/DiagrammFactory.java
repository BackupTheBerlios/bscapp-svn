package gui.helfer;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;
import com.objectplanet.chart.NonFlickerPanel;
import com.objectplanet.chart.PieChart;
import com.objectplanet.chart.ext.PlotterChart;



/**
 * Hilfsklasse zum erzeugen von diagrammen.
 * 
 * @author andre
 */
@SuppressWarnings("serial")
public class DiagrammFactory
{
  /**
   * die erlaubten diagrammtypen
   * 
   * @author andre
   */
  public static enum TYP
  {
    BALKENDIAGRAMM, KREISDIAGRAMM, PORTFOLIO
  }

  private static JPanel ERROR_DIAGRAMM = new JPanel()
  {
    {
      add(new JLabel("Error:\nvalues.length != labels.length"));
    }
  };


  /**
   * erzeugt ein balkendiagramm
   * 
   * @param values
   *          die werte
   * @param labels
   *          die beschriftungen der balken
   * @return das diagramm
   */
  @SuppressWarnings("serial")
  public static JPanel balkenDiagramm(double[] values, String[] labels)
  {

    if(values.length != labels.length)
    {
      return new JPanel()
      {
        {
          add(new JLabel("Error:\nvalues.length != labels.length"));
        }
      };
    }

    BarChart barchart = new BarChart();
    barchart.setSampleCount(values.length);
    barchart.setSampleValues(0, values);

    Color[] colors = new Color[1];
    colors[0] = Color.blue;

    barchart.setSampleColors(colors);
    barchart.setBackground(Color.white);

    double max = 0.0;
    for(double d : values)
    {
      if(d > max)
      {
        max = d;
      }
    }
    barchart.setRange(0, max);

    if(values.length == labels.length)
    {
      barchart.setSampleLabels(labels);
      barchart.setBarLabelsOn(true);
    }

    JPanel panel = new JPanel(new BorderLayout());
    panel.add(barchart, BorderLayout.CENTER);
    return panel;
  }


  /**
   * erzeugt ein kreisdiagramm
   * 
   * @param values
   *          die werte
   * @param labels
   *          die beschriftungen der kreissegmente
   * @return das diagramm
   */
  @SuppressWarnings("serial")
  public static JPanel kreisDiagramm(double[] values, String[] labels)
  {

    if(values.length != labels.length)
    {
      return ERROR_DIAGRAMM;
    }

    Color[] farben = getFarbArray(values.length);

    PieChart piechart = new PieChart();
    piechart.setSampleCount(values.length);
    piechart.setSampleValues(0, values);
    piechart.setSampleLabels(labels);
    piechart.setSampleLabelsOn(true);
    piechart.setSampleLabelStyle(Chart.POINTING);
    piechart.setValueLabelsOn(true);
    piechart.setValueLabelStyle(Chart.POINTING);
    piechart.setPercentLabelsOn(true);
    piechart.setPercentLabelStyle(Chart.INSIDE);
    piechart.setSampleColors(farben);

    NonFlickerPanel nfp = new NonFlickerPanel(new BorderLayout());
    nfp.add("Center", piechart);

    JPanel panel = new JPanel(new BorderLayout());
    panel.add(nfp, BorderLayout.CENTER);
    return panel;
  }


  /**
   * erzeugt eine portfolioansicht
   * 
   * @param koordinaten
   *          die datenpunkte in form eines Point2D.Double[]
   * @param groessen
   *          die größe der datenpunkte in form eines int[]
   * @param labels
   *          die beschriftung der datenpunkte
   * @return das diagramm
   */
  @SuppressWarnings("serial")
  public static JPanel portfolioDiagramm(Point2D.Double[] koordinaten,
                                         int[] groessen,
                                         String[] labels)
  {

    if(koordinaten.length != labels.length || koordinaten.length != groessen.length)
    {
      return ERROR_DIAGRAMM;
    }

    PlotterChart plotterchart = new PlotterChart();
    plotterchart.setSeriesCount(koordinaten.length);

    for(int i = 0; i < koordinaten.length; i ++ )
    {
      double x = koordinaten[i].x;
      double y = koordinaten[i].y;

      double[][] punkt = new double[][]
      {
      {x, y}};

      plotterchart.setPlots(i, punkt, groessen[i]);
      plotterchart.setPlotStyle(i, PlotterChart.PLOT_STYLE_CIRCLE_OPAQUE);
      plotterchart.setConnectedLinesOn(i, true);

      double labelX = .5;
      double labelY = .5;

      labelX += x / 200;

      labelY -= y / 200;

      String zufallstring = Double.toString((new Random()).nextDouble());

      plotterchart.setLabel(zufallstring, labels[i], labelX, labelY);
    }

    plotterchart.setSeriesColors(getFarbArray(koordinaten.length));
    plotterchart.setXMaxValueLineCount( - 1);
    plotterchart.setXUpperRange(100);
    plotterchart.setXLowerRange( - 100);
    plotterchart.setYUpperRange(100);
    plotterchart.setYLowerRange( - 100);

    NonFlickerPanel nfp = new NonFlickerPanel(new BorderLayout());
    nfp.add("Center", plotterchart);

    JPanel panel = new JPanel(new BorderLayout());
    panel.add(nfp, BorderLayout.CENTER);
    return panel;
  }


  /**
   * gibt ein array aus farben zurück.
   * 
   * @param anzahlFarben
   *          die gewünschte länge des arrays
   * @return das array
   */
  private static Color[] getFarbArray(int anzahlFarben)
  {
    Color[] standardfarben =
    {Color.blue,
     Color.green,
     Color.red,
     Color.yellow,
     Color.cyan,
     Color.magenta,
     Color.orange};

    Color[] farbArray = new Color[anzahlFarben];
    Random random = new Random();

    for(int i = 0; i < anzahlFarben; i ++ )
    {
      if(i < standardfarben.length)
      {
        farbArray[i] = standardfarben[i];
      }
      else
      {
        Color c = new Color(random.nextInt(256),
                            random.nextInt(256),
                            random.nextInt(256));
        farbArray[i] = c;
      }
    }

    return farbArray;
  }
}
