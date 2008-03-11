package factories;



import java.awt.Color;
import javax.swing.JPanel;
import com.objectplanet.chart.*;



public class DiagrammFactory
{
	public static JPanel erzeugSimpleBalken( double[] values,
	                                         String[] labels )
	{
		JPanel panel = new JPanel();
		
		BarChart bc = new BarChart();
		bc.setSampleCount( values.length );
		bc.setSampleValues( 0, values );
		
		Color[] colors = new Color[ 1 ];
		colors[ 0 ] = Color.blue;
		
		bc.setSampleColors( colors );
		

		return panel;
	}
}
