package nachhaltigkeit;



import java.awt.BorderLayout;
import java.awt.Point;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 * @author andre
 */
@ SuppressWarnings( "serial" )
public class Bereich extends MyTreeNode
{
	/**
	 * Point(int attraktivität, int imVergleich);
	 */
	private Point wichtigkeit;
	
	
	/**
	 * @param bezeichnung
	 */
	public Bereich( String bezeichnung )
	{
		super( bezeichnung );
		wichtigkeit = new Point();
	}
	

	@ Override
	public JPanel gibDiagramm()
	{
		// die daten werden in dieser form definiert:
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue( - 4, "Wertung", "Kennzahl 1" );
		dataset.setValue( 7, "Wertung", "Kennzahl 2" );
		dataset.setValue( 8, "Wertung", "Kennzahl 3" );
		
		// eine andere möglichkeit, daten einzubinden:
		
		// String[] seriesNames = new String[] {"2001", "2002"};
		// String[] categoryNames = new String[] {"First Quarter",
		// "Second
		// Quater"}; Number[][] categoryData = new Integer[][]
		// {{new Integer(20), new Integer(35)}, {new Integer(40), new
		// Integer(60)}}; CategoryDataset categoryDataset =
		// new DefaultCategoryDataset (seriesNames, categoryNames,
		// categoryData); JFreeChart chart = ChartFactory.
		// createVerticalBarChart3D ("Sample Category Chart", /*
		// Title*/
		// "Quarters", /* X-Axis label*/ "Sales", /* Y-Axis label*/
		// categoryDataset, /* Dataset*/ true /* Show legend*/ );
		
		// erzeuge chart mit hilfe der chartfactory:
		JFreeChart chart;
		chart = ChartFactory.createBarChart( bezeichnung,
		                                     "Kennzahlen",
		                                     "Wertung",
		                                     dataset,
		                                     PlotOrientation.VERTICAL,
		                                     false,
		                                     true,
		                                     false );
		
		// // erzeuge farbverlauf im hintergrund:
		// chart.setBackgroundPaint(
		// new GradientPaint(0, 0, Color.white, 0, 1000,
		// Color.darkGray)) ;
		
		// // ein bild des charts erzeugt man so:
		// BufferedImage image = chart.createBufferedImage(500, 300) ;
		// JLabel lblChart = new JLabel() ;
		// lblChart.setIcon(new ImageIcon(image)) ;
		
		// erzeuge ein mit swing interagierendes chart:
		ChartPanel cp = new ChartPanel( chart,
		                                true,
		                                true,
		                                true,
		                                true,
		                                true )
		/* {{setPreferredSize(new java.awt.Dimension(500, 270));}} */;
		
		JPanel p = new JPanel( new BorderLayout() );
		// zeige überschrift im northbereich des panels an:
		p.add( super.machÜberschrift(), BorderLayout.NORTH );
		// setze das chart in das panel das zurückgegeben wird
		p.add( cp, BorderLayout.CENTER );
		return p;
	}
	

	/**
	 * @return the wichtigkeit
	 */
	public Point getWichtigkeit()
	{
		return wichtigkeit;
	}
	

	/**
	 * @param wichtigkeit
	 *            the wichtigkeit to set
	 */
	public void setWichtigkeit( Point wichtigkeit )
	{
		this.wichtigkeit = wichtigkeit;
	}
	
}
