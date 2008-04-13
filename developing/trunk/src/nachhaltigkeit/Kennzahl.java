package nachhaltigkeit;



import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.tree.MutableTreeNode;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;



/**
 * @author andre
 */
@ SuppressWarnings( "serial" )
public class Kennzahl extends MyTreeNode
{
	/**
	 * @param bezeichnung
	 */
	public Kennzahl( String bezeichnung )
	{
		super( bezeichnung );
	}
	

	@ Override
	public JPanel gibDiagramm()
	{
		// die daten werden in dieser form definiert:
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue( "sehr zufrieden", new Integer( 99 ) );
		pieDataset.setValue( "zufrieden", new Integer( 46 ) );
		pieDataset.setValue( "wenig zufrieden", new Integer( 34 ) );
		pieDataset.setValue( "Stimmenthaltungen", new Integer( 2 ) );
		
		// erzeuge chart mit hilfe der chartfactory:
		JFreeChart chart;
		chart = ChartFactory.createPieChart( bezeichnung,
		                                     pieDataset,
		                                     true,
		                                     true,
		                                     false );
		
		// // erzeuge farbverlauf im hintergrund:
		// chart.setBackgroundPaint(
		// new GradientPaint(0, 0, Color.white, 0, 1000,
		// Color.darkGray)) ;
		
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
	 * Eine Kennzahl kann keine ChildNodes haben.
	 */
	@ Override
	public void add( MutableTreeNode newChild )
	{}
}
