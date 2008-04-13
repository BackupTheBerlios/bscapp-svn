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



public class DiagrammFactory
{
	/**
	 * @param values
	 * @param labels
	 * @return
	 */
	@ SuppressWarnings( "serial" )
	public static JPanel balkenDiagramm( double[] values, String[] labels )
	{

		if( values.length != labels.length )
		{
			return new JPanel()
			{
				{
					add( new JLabel( "Error:\nvalues.length != labels.length" ) );
				}
			};
		}

		BarChart barchart = new BarChart();
		barchart.setSampleCount( values.length );
		barchart.setSampleValues( 0, values );

		Color[] colors = new Color[ 1 ];
		colors[ 0 ] = Color.blue;

		barchart.setSampleColors( colors );
		barchart.setBackground( Color.white );

		double max = 0.0;
		for( double d : values )
		{
			if( d > max )
			{
				max = d;
			}
		}
		barchart.setRange( 0, max );

		if( values.length == labels.length )
		{
			barchart.setSampleLabels( labels );
			barchart.setBarLabelsOn( true );
		}

		JPanel panel = new JPanel( new BorderLayout() );
		panel.add( barchart, BorderLayout.CENTER );
		return panel;
	}


	@ SuppressWarnings( "serial" )
	public static JPanel kreisDiagramm( double[] values, String[] labels )
	{

		if( values.length != labels.length )
		{
			return new JPanel()
			{
				{
					add( new JLabel( "Error:\nvalues.length != labels.length" ) );
				}
			};
		}

		Color[] farben = getFarbArray( values.length );

		PieChart piechart = new PieChart();
		piechart.setSampleCount( values.length );
		piechart.setSampleValues( 0, values );
		piechart.setSampleLabels( labels );
		piechart.setSampleLabelsOn( true );
		piechart.setSampleLabelStyle( Chart.POINTING );
		piechart.setValueLabelsOn( true );
		piechart.setValueLabelStyle( Chart.POINTING );
		piechart.setPercentLabelsOn( true );
		piechart.setPercentLabelStyle( Chart.INSIDE );
		piechart.setSampleColors( farben );

		NonFlickerPanel nfp = new NonFlickerPanel( new BorderLayout() );
		nfp.add( "Center", piechart );

		JPanel panel = new JPanel( new BorderLayout() );
		panel.add( nfp, BorderLayout.CENTER );
		return panel;
	}


	@ SuppressWarnings( "serial" )
	public static JPanel portfolioDiagramm( Point2D.Double[] koordinaten,
	                                        int[] groessen,
	                                        String[] labels )
	{

		if( koordinaten.length != labels.length || koordinaten.length != groessen.length )
		{
			return new JPanel()
			{
				{
					add( new JLabel( "Error:\n" + "koordinaten.length != labels.length \n"
					                 + "|| koordinaten.length != groessen.length " ) );
				}
			};
		}

		PlotterChart plotterchart = new PlotterChart();
		plotterchart.setSeriesCount( koordinaten.length );

		for( int i = 0 ; i < koordinaten.length ; i ++ )
		{
			double x = koordinaten[ i ].x;
			double y = koordinaten[ i ].y;

			double[][] punkt = new double[][]
			{
			{ x, y } };

			plotterchart.setPlots( i, punkt, groessen[ i ] );
			plotterchart.setPlotStyle( i, PlotterChart.PLOT_STYLE_CIRCLE_OPAQUE );
			plotterchart.setConnectedLinesOn( i, true );

			double labelX = .5;
			double labelY = .5;

			labelX += x / 200;

			labelY -= y / 200;

			String zufallstring = Double.toString( ( new Random() ).nextDouble() );

			System.out.println( "x=" + x
			                    + ", y="
			                    + y
			                    + ", labelx="
			                    + labelX
			                    + ", labely="
			                    + labelY );

			plotterchart.setLabel( zufallstring, labels[ i ], labelX, labelY );
		}

		plotterchart.setSeriesColors( getFarbArray( koordinaten.length ) );
		plotterchart.setXMaxValueLineCount( - 1 );
		plotterchart.setXUpperRange( 100 );
		plotterchart.setXLowerRange( - 100 );
		plotterchart.setYUpperRange( 100 );
		plotterchart.setYLowerRange( - 100 );

		NonFlickerPanel nfp = new NonFlickerPanel( new BorderLayout() );
		nfp.add( "Center", plotterchart );

		JPanel panel = new JPanel( new BorderLayout() );
		panel.add( nfp, BorderLayout.CENTER );
		return panel;
	}


	private static Color[] getFarbArray( int anzahlFarben )
	{
		Color[] standardfarben =
		{ Color.blue,
		 Color.green,
		 Color.red,
		 Color.yellow,
		 Color.cyan,
		 Color.magenta,
		 Color.orange };

		Color[] farbArray = new Color[ anzahlFarben ];
		Random random = new Random();

		for( int i = 0 ; i < anzahlFarben ; i ++ )
		{
			if( i < standardfarben.length )
			{
				farbArray[ i ] = standardfarben[ i ];
			}
			else
			{
				Color c = new Color( random.nextInt( 256 ),
				                     random.nextInt( 256 ),
				                     random.nextInt( 256 ) );
				farbArray[ i ] = c;
			}
		}

		return farbArray;
	}
}
