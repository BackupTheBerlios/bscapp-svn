package datenModell;



import java.io.Serializable;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;



public class Bereich extends DefaultMutableTreeNode implements
                                                   Serializable,
                                                   Comparable< Bereich >
{
	private static final long serialVersionUID = 1237738469520669948L;
	

	private String titel;
	
	
	public Bereich( String titel )
	{
		super();
		this.titel = titel;
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
	public void remove( MutableTreeNode tabelle )
	{
		super.remove( tabelle );
	}
	

	@ Override
	public int compareTo( Bereich b )
	{
		return titel.compareTo( b.getTitel() );
	}
}
