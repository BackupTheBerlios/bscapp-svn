package datenModell;



import java.io.Serializable;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;



public class Tabelle extends DefaultMutableTreeNode implements
                                                   Serializable,
                                                   Comparable< Tabelle >
{
	

	private static final long serialVersionUID = 1074172988316457301L;
	

	protected String titel;
	protected double verdichtung;
	protected double bewertung;
	
	
	public Tabelle( String titel )
	{
		super();
		this.titel = titel;
		verdichtung = 0.0;
		bewertung = 0.0;
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
	

	public double getVerdichtung()
	{
		return verdichtung;
	}
	

	public void setVerdichtung( double verdichtung )
	{
		this.verdichtung = verdichtung;
	}
	

	public double getBewertung()
	{
		return bewertung;
	}
	

	public void setBewertung( double bewertung )
	{
		this.bewertung = bewertung;
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
}
