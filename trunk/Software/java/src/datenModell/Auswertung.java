package datenModell;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;



public class Auswertung implements Serializable
{
	private static final long serialVersionUID = - 208812670706157608L;
	

	private String titel;
	private List< Bereich > bereiche;
	

	private static Auswertung INSTANZ;
	
	
	public static Auswertung getInstanz()
	{
		if( INSTANZ == null )
		{
			INSTANZ = new Auswertung();
		}
		return INSTANZ;
	}
	

	/**
	 * @param titel
	 */
	private Auswertung()
	{
		super();
		titel = "Auswertung";
		bereiche = new ArrayList< Bereich >();
	}
	

	/**
	 * @return
	 */
	public static String getTitel()
	{
		return getInstanz().titel;
	}
	

	/**
	 * @param titel
	 */
	public static void setTitel( String titel )
	{
		getInstanz().titel = titel;
	}
	

	/**
	 * @return
	 */
	public static List< Bereich > getBereiche()
	{
		return getInstanz().bereiche;
	}
	

	/**
	 * @param bereich
	 * @return
	 */
	public static boolean addBereich( Bereich bereich )
	{
		boolean hinzugefügt = getInstanz().bereiche.add( bereich );
		
		if( hinzugefügt )
		{
			Collections.sort( getInstanz().bereiche );
		}
		
		return hinzugefügt;
	}
	

	/**
	 * @param bereich
	 * @return
	 */
	public static boolean removeBereich( Bereich bereich )
	{
		return getInstanz().bereiche.remove( bereich );
	}
	

	public static MutableTreeNode getTree()
	{
		DefaultMutableTreeNode root = new DefaultMutableTreeNode( getInstanz() );
		
		for( Bereich b : getInstanz().bereiche )
		{	

		}
		
		return root;
	}
}
