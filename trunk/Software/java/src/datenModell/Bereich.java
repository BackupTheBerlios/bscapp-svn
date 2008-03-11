package datenModell;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Bereich implements Serializable, Comparable< Bereich >
{
	private static final long serialVersionUID = 1237738469520669948L;
	

	private String titel;
	private List< Tabelle > tabellen;
	
	
	public Bereich( String titel )
	{
		super();
		this.titel = titel;
		tabellen = new ArrayList< Tabelle >();
	}
	

	public String getTitel()
	{
		return titel;
	}
	

	public List< Tabelle > getTabellen()
	{
		return tabellen;
	}
	

	public void setTitel( String titel )
	{
		this.titel = titel;
	}
	

	public boolean addTabelle( Tabelle tabelle )
	{
		boolean hinzugefügt = tabellen.add( tabelle );
		
		if( hinzugefügt )
		{
			Collections.sort( tabellen );
		}
		
		return hinzugefügt;
	}
	

	public boolean removeTabelle( Tabelle tabelle )
	{
		return tabellen.remove( tabelle );
	}
	

	@ Override
	public int compareTo( Bereich b )
	{
		return titel.compareTo( b.getTitel() );
	}
}
