package datenModell;



import gui.helfer.DiagrammFactory;
import java.awt.geom.Point2D;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.MutableTreeNode;



/**
 * ein tabellenblatt ist die unterste ebene des datenmodells. hier
 * werden die daten gespeichert. es hält bis zu 3 arrays mit des typs
 * Point2D.Double, ein String[], das die labels zu den datenpunkten
 * hält.
 * 
 * @author andre
 */
public class TabelleBlatt extends Tabelle implements Serializable, Bewertbar
{
	private static final long serialVersionUID = - 3728988945622867135L;


	private Point2D.Double[] werteA;
	private Point2D.Double[] werteB;
	private Point2D.Double[] werteC;

	private String[] labels;


	public TabelleBlatt( String titel )
	{
		super( titel );
	}


	public Point2D.Double[] getWerteA()
	{
		return werteA;
	}


	public Point2D.Double[] getWerteB()
	{
		return werteB;
	}


	public Point2D.Double[] getWerteC()
	{
		return werteC;
	}


	public void setWerteA( Point2D.Double[] werteA )
	{
		this.werteA = werteA;
	}


	public void setWerteB( Point2D.Double[] werteB )
	{
		this.werteB = werteB;
	}


	public void setWerteC( Point2D.Double[] werteC )
	{
		this.werteC = werteC;
	}


	@ Override
	public final void add( MutableTreeNode tabelle )
	{
	// niemand darf an ein blatt etwas anhängen!
	}


	@ SuppressWarnings( "serial" )
	@ Override
	public JPanel getJDiagramm( DiagrammFactory.TYP typ )
	{
		double[] werte = new double[ werteA.length ];

		
		for( int i = 0 ; i < werteA.length ; i ++ )
		{
			werte[ i ] = werteA[ i ].x;
		}

		
		switch( typ )
		{
			case BALKENDIAGRAMM :
				return DiagrammFactory.balkenDiagramm( werte, labels );

			case KREISDIAGRAMM :
				return DiagrammFactory.kreisDiagramm( werte, labels );
		}

		
		return new JPanel()
		{
			{
				add( new JLabel( "PORTFOLIO-Darstellung hier nicht erlaubt!" ) );
			}
		};
	}
}
