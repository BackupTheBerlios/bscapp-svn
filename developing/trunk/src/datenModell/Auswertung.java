package datenModell;



import java.io.Serializable;
import javax.swing.tree.DefaultMutableTreeNode;



public class Auswertung extends DefaultMutableTreeNode implements
                                                      Serializable
{
	private static final long serialVersionUID = - 208812670706157608L;
	

	private String titel;
	

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
		super("Auswertung");
		titel = "Auswertung";
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
	 * @param bereich
	 */
	public static void addBereich( Bereich bereich )
	{
		DefaultMutableTreeNode thisNode = getInstanz();
		thisNode.add( bereich );
	}
	

	/**
	 * @param bereich
	 */
	public static void removeBereich( Bereich bereich )
	{
		DefaultMutableTreeNode thisNode = getInstanz();
		thisNode.remove( bereich );
	}
}
