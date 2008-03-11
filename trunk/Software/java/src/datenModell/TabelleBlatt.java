package datenModell;



import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;



public class TabelleBlatt extends Tabelle implements Serializable
{
	private static final long serialVersionUID = - 3728988945622867135L;
	

	private Point2D.Double[] werteA;
	private Point2D.Double[] werteB;
	private Point2D.Double[] werteC;
	
	
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
	public void add( MutableTreeNode tabelle )
	{}
}
