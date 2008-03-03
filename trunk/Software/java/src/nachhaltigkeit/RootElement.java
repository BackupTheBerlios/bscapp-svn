
package nachhaltigkeit ;

import java.awt.BorderLayout ;
import java.awt.Point ;
import java.util.HashMap ;
import java.util.Map ;

import javax.swing.JPanel ;
import org.jfree.chart.ChartFactory ;
import org.jfree.chart.ChartPanel ;
import org.jfree.chart.JFreeChart ;
import org.jfree.chart.annotations.XYTextAnnotation ;
import org.jfree.chart.axis.NumberAxis ;
import org.jfree.chart.axis.NumberTickUnit ;
import org.jfree.chart.plot.PlotOrientation ;
import org.jfree.chart.plot.XYPlot ;
import org.jfree.data.xy.MatrixSeriesCollection ;
import org.jfree.data.xy.NormalizedMatrixSeries ;
import org.jfree.ui.RectangleInsets ;

/**
 * @author andre
 * 
 */
@ SuppressWarnings("serial")
public class RootElement extends MyTreeNode
{
	/**
	 * @param bezeichnung
	 */
	public RootElement()
	{
		super("Übersicht") ;
	}

	@ Override
	public JPanel gibDiagramm()
	{
		// die daten werden in dieser form definiert:
		Map<Point, String> werte = new HashMap<Point, String>() ;
		for( MyTreeNode node : super.getUntergebeneNodes() )
		{
			if( node instanceof Bereich )
				werte.put(((Bereich)node).getWichtigkeit(),
				            node.getBezeichnung()) ;
		}

		NormalizedMatrixSeries matrix = new NormalizedMatrixSeries("Bereiche",
		                                                           5,
		                                                           5) ;
		for( Point key : werte.keySet() )
		{
			matrix.update(key.x, key.y, 1) ;
		}
		matrix.setScaleFactor(4) ;
		MatrixSeriesCollection dataset = new MatrixSeriesCollection(matrix) ;

		// erzeuge chart mit hilfe der chartfactory:
		JFreeChart chart ;
		chart = ChartFactory.createBubbleChart("Übersicht über die Kennzahlenbereiche",
		                                       "Wichtigkeit für Attraktivität",
		                                       "Wichtigkeit im Vergleich mit anderen Schulen",
		                                       dataset,
		                                       PlotOrientation.VERTICAL,
		                                       false,
		                                       true,
		                                       false) ;

		// // erzeuge farbverlauf im hintergrund:
		// chart.setBackgroundPaint(
		// new GradientPaint(0, 0, Color.white, 0, 1000, Color.darkGray)) ;

		// formatierung des diagrammes:
		XYPlot plot = chart.getXYPlot() ;
		plot.setForegroundAlpha(0.5f) ;
		plot.setAxisOffset(new RectangleInsets(20, 20, 20, 20)) ;

		// einfügen der bezeichnungen ins diagramm:
		for( Point key : werte.keySet() )
		{
			XYTextAnnotation a ;
			// achtung: koordinaten der annotationen müssen vertauscht werden:
			double x = key.y ;
			double y = key.x ;
			a = new XYTextAnnotation(werte.get(key), x, y) ;
			plot.addAnnotation(a) ;
		}

		// formatierung der achsen:
		NumberAxis domainAxis = (NumberAxis)plot.getDomainAxis() ;
		domainAxis.setLowerBound(0.5) ;
		domainAxis.setUpperBound(3.5) ;
		domainAxis.setTickUnit(new NumberTickUnit(1)) ;
		NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis() ;
		rangeAxis.setLowerBound(0.5) ;
		rangeAxis.setUpperBound(3.5) ;
		rangeAxis.setTickUnit(new NumberTickUnit(1)) ;

		// erzeuge ein mit swing interagierendes chart:
		ChartPanel cp = new ChartPanel(chart, true, true, true, true, true) ;
		cp.setPreferredSize(new java.awt.Dimension(500, 270)) ;

		JPanel p = new JPanel(new BorderLayout()) ;
		// setze das chart in das panel das zurückgegeben wird
		p.add(cp, BorderLayout.CENTER) ;
		// zeige überschrift im northbereich des panels an:
		p.add(super.machÜberschrift(), BorderLayout.NORTH) ;
		return p ;
	}
}
