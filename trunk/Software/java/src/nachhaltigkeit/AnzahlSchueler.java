
package nachhaltigkeit ;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory ;
import org.jfree.chart.ChartPanel ;
import org.jfree.chart.JFreeChart ;
import org.jfree.data.time.Day ;
import org.jfree.data.time.TimeSeries ;
import org.jfree.data.time.TimeSeriesCollection ;
import org.jfree.data.xy.XYDataset ;

/**
 * @author andre
 * 
 */
@ SuppressWarnings("serial")
public class AnzahlSchueler extends Kennzahl
{

	/**
	 * @param bezeichnung
	 */
	public AnzahlSchueler(String bezeichnung)
	{
		super(bezeichnung) ;
	}

	@ Override
	public JPanel gibDiagramm()
	{
		JFreeChart chart = ChartFactory.createTimeSeriesChart("Anzahl Sch�ler",
		                                                      "Jahr",
		                                                      "Anzahl Sch�ler",
		                                                      createDataset(),
		                                                      false,
		                                                      false,
		                                                      false) ;
		
		
		// erzeuge ein mit swing interagierendes chart:
		ChartPanel cp = new ChartPanel(chart, true, true, true, true, true)
		/* {{setPreferredSize(new java.awt.Dimension(500, 270));}} */;

		JPanel p = new JPanel(new BorderLayout()) ;
		// zeige �berschrift im northbereich des panels an:
		p.add(super.mach�berschrift(), BorderLayout.NORTH) ;
		// setze das chart in das panel das zur�ckgegeben wird
		p.add(cp, BorderLayout.CENTER) ;
		return p ;
	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return A sample dataset.
	 */
	private XYDataset createDataset()
	{
		final TimeSeries series = new TimeSeries("Random Data") ;

		Day j04 = new Day(1, 1, 2004) ;
		Day j05 = new Day(1, 1, 2005) ;
		Day j06 = new Day(1, 1, 2006) ;
		Day j07 = new Day(1, 1, 2007) ;

		series.add(j04, 987) ;
		series.add(j05, 1099) ;
		series.add(j06, 945) ;
		series.add(j07, 877) ;

		return new TimeSeriesCollection(series) ;
	}

}