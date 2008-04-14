package datenModell;



import java.awt.geom.Point2D;
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
		super( titel );
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


	/**
	 * Gibt die position des bereichs in der portfoliodarstellung
	 * zurück.
	 * 
	 * @return die koordinate in form eines Point2D.Double - objekts
	 */
	public Point2D.Double getKoordinatePortfolio()
	{
		return null;
	}


	/**
	 * gibt die größe zurück, mit der dieser bereich im portfolio
	 * dargestellt wird.
	 * 
	 * @return die größe
	 */
	public int getGroessePortfolio()
	{
		return 0;
	}
}
