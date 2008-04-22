package datenModell;



import gui.helfer.DiagrammFactory;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;



public class Tabelle extends DefaultMutableTreeNode

implements Serializable, Comparable< Tabelle >, Bewertbar
{


	private static final long serialVersionUID = 1074172988316457301L;

	protected double prioritaet;


	public Tabelle( String titel )
	{
		super( titel );
		prioritaet = 1.0;
	}


	public String getTitel()
	{
		return (String)super.getUserObject();
	}


	public void setTitel( String titel )
	{
		super.setUserObject( titel );
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
			return getTitel().compareTo( t.getTitel() );
		}
		// wenn beide kein blatt sind...
		if( ! thisIstBlatt && ! tIstBlatt )
		{
			return getTitel().compareTo( t.getTitel() );
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
	public void setUserObject( Object userObject )
	{
		// um sicherzugehen dass nur ein string als "titel" definiert
		// werden kann...
		if( userObject instanceof String )
		{
			super.setUserObject( userObject );
		}
	}


	@ Override
	public double getPrioritaet()
	{
		return prioritaet;
	}


	@ Override
	public double getZusammenfassung()
	{
		double summePmalZ = 0;
    double summeP = 0;

    // für jedes einzelne meiner kinder:
    // multipliziere priorität (P) mit der zusammenfassung (Z);
    // zum schluss nimm die summe aller P*Z
    // und dividiere sie durch die summe aller prioritäten:
    for(Object o : children)
    {
      Tabelle t = (Tabelle)o;
      summePmalZ += t.getPrioritaet() * t.getZusammenfassung();
      summeP += t.getPrioritaet();
    }

    return summePmalZ / summeP;
	}


	@ Override
	public void setPrioritaet( double prioritaet )
	{
		this.prioritaet = prioritaet;
	}


	@ Override
	public void setZusammenfassung( double zusammenfassung )
	{
	// eine tabelle ermittelt autom. eine zusammenf. ihrer children!
	// nur tabelleblatt-instanzen eine zusammenf. direkt zuordnen!
	// es kann nur die priorität gesetzt werden!
	}
}
