package datenModell;



import gui.helfer.DiagrammFactory;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;



public class Tabelle extends DefaultMutableTreeNode

implements Serializable, Comparable< Tabelle >, Bewertbar
{


	private static final long serialVersionUID = 1074172988316457301L;


	protected String titel;
	protected double zusammenfassung;
	protected double prioritaet;


	public Tabelle( String titel )
	{
		super( titel );
		this.titel = titel;
		zusammenfassung = 1.0;
		prioritaet = 1.0;
	}


	public String getTitel()
	{
		return titel;
	}


	public void setTitel( String titel )
	{
		this.titel = titel;
	}


	@ Override
	public void add( MutableTreeNode tabelle )
	{
		if( tabelle instanceof Tabelle )
		{
			super.add( tabelle );
		}
	}


	@ Override
	public int compareTo( Tabelle t )
	{
		boolean thisIstBlatt = this instanceof TabelleBlatt;
		boolean tIstBlatt = t instanceof TabelleBlatt;

		// wenn beide ein blatt sind...
		if( thisIstBlatt && tIstBlatt )
		{
			return titel.compareTo( t.getTitel() );
		}

		// wenn beide kein blatt sind...
		if( ! thisIstBlatt && ! tIstBlatt )
		{
			return titel.compareTo( t.getTitel() );
		}

		// wenn nur "this" ein blatt ist...
		if( thisIstBlatt && ! tIstBlatt )
		{
			return - 1;
		}
		// wenn nur "t" ein blatt ist...
		else
		{
			return 1;
		}
	}


	@ SuppressWarnings( "serial" )
	@ Override
	public JPanel getJDiagramm( DiagrammFactory.TYP typ )
	{
		double[] values = new double[ super.getChildCount() ];
		String[] labels = new String[ super.getChildCount() ];

		for( int i = 0 ; i < super.getChildCount() ; i ++ )
		{
			Object o = super.getChildAt( i );
			values[ i ] = ( (Bewertbar)o ).getZusammenfassung();
			labels[ i ] = ( (Tabelle)o ).getTitel();
		}


		switch( typ )
		{
			case BALKENDIAGRAMM :
				return DiagrammFactory.balkenDiagramm( values, labels );

			case KREISDIAGRAMM :
				return DiagrammFactory.kreisDiagramm( values, labels );
		}


		return new JPanel()
		{
			{
				add( new JLabel( "PORTFOLIO-Darstellung hier nicht erlaubt!" ) );
			}
		};
	}


	@ Override
	public double getPrioritaet()
	{
		return prioritaet;
	}


	@ Override
	public double getZusammenfassung()
	{
		return zusammenfassung;
	}


	@ Override
	public void setPrioritaet( double prioritaet )
	{
		this.prioritaet = prioritaet;
	}


	@ Override
	public void setZusammenfassung( double zusammenfassung )
	{
		this.zusammenfassung = zusammenfassung;
	}
}
