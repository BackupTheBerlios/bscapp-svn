package nachh_ALT_igkeit;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.VerticalAlignment;



/**
 * @author andre
 */
@ SuppressWarnings( "serial" )
public class UnterrichtsQualtiaet extends Kennzahl
{
	
	/**
	 * @param bezeichnung
	 */
	public UnterrichtsQualtiaet( String bezeichnung )
	{
		super( bezeichnung );
	}
	
	// create a dataset...
	private double[][] data = new double[][]
	{
		{
		        1.0, 4.0, 3.0, 5.0, 5.0, 7.0, 7.0, 8.0
		}
	// ,
	// {5.0, 7.0, 6.0, 8.0, 4.0, 4.0, 2.0, 1.0}
	};
	
	private CategoryDataset dataset = DatasetUtilities.createCategoryDataset( "Series ",
	                                                                          "Type ",
	                                                                          data );
	
	
	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *            the dataset.
	 * @return The chart.
	 */
	private JFreeChart createChart( final CategoryDataset dataset )
	{
		
		final JFreeChart chart = ChartFactory.createAreaChart( "Area Chart", // chart
		                                                       // title
		                                                       "Category", // domain
		                                                       // axis
		                                                       // label
		                                                       "Value", // range
		                                                       // axis
		                                                       // label
		                                                       dataset, // data
		                                                       PlotOrientation.VERTICAL, // orientation
		                                                       true, // include
		                                                       // legend
		                                                       true, // tooltips
		                                                       false // urls
		);
		
		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
		
		// set the background color for the chart...
		// final StandardLegend legend = (StandardLegend)
		// chart.getLegend();
		// legend.setAnchor(StandardLegend.SOUTH);
		
		chart.setBackgroundPaint( Color.white );
		final TextTitle subtitle = new TextTitle( "An area chart demonstration.  We use this " + "subtitle as an example of what happens when you get a really long title or "
		                                          + "subtitle." );
		subtitle.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
		subtitle.setPosition( RectangleEdge.TOP );
		// subtitle.setSpacer(new Spacer(Spacer.RELATIVE, 0.05, 0.05,
		// 0.05,
		// 0.05));
		subtitle.setVerticalAlignment( VerticalAlignment.BOTTOM );
		chart.addSubtitle( subtitle );
		
		final CategoryPlot plot = chart.getCategoryPlot();
		plot.setForegroundAlpha( 0.5f );
		
		// plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0,
		// 5.0, 5.0));
		plot.setBackgroundPaint( Color.lightGray );
		plot.setDomainGridlinesVisible( true );
		plot.setDomainGridlinePaint( Color.white );
		plot.setRangeGridlinesVisible( true );
		plot.setRangeGridlinePaint( Color.white );
		
		final CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions( CategoryLabelPositions.UP_45 );
		domainAxis.setLowerMargin( 0.0 );
		domainAxis.setUpperMargin( 0.0 );
		domainAxis.addCategoryLabelToolTip( "Type 1",
		                                    "The first type." );
		domainAxis.addCategoryLabelToolTip( "Type 2",
		                                    "The second type." );
		domainAxis.addCategoryLabelToolTip( "Type 3",
		                                    "The third type." );
		
		final NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
		rangeAxis.setStandardTickUnits( NumberAxis.createIntegerTickUnits() );
		rangeAxis.setLabelAngle( 0 * Math.PI / 2.0 );
		// OPTIONAL CUSTOMISATION COMPLETED.
		
		return chart;
		
	}
	

	@ Override
	public JPanel gibDiagramm()
	{
		// create the chart...
		final JFreeChart chart = createChart( dataset );
		final ChartPanel chartPanel = new ChartPanel( chart );
		
		JPanel p = new JPanel( new BorderLayout() );
		// zeige überschrift im northbereich des panels an:
		p.add( super.machÜberschrift(), BorderLayout.NORTH );
		// setze das chart in das panel das zurückgegeben wird
		p.add( chartPanel, BorderLayout.CENTER );
		return p;
	}
}
