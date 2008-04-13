package factories;



import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import com.objectplanet.chart.BarChart;



public class DiagrammFactory
{
	public static JPanel erzeugSimpleBalken( double[] values, String[] labels )
	{
		BarChart bc = new BarChart();
		bc.setSampleCount( values.length );
		bc.setSampleValues( 0, values );

		Color[] colors = new Color[ 1 ];
		colors[ 0 ] = Color.blue;

		bc.setSampleColors( colors );
		bc.setBackground( Color.white );

		double max = 0.0;
		for( double d : values )
		{
			if( d > max )
			{
				max = d;
			}
		}
		bc.setRange( 0, max );

		JPanel panel = new JPanel( new BorderLayout() );
		panel.add( bc, BorderLayout.CENTER );
		return panel;
	}
}
