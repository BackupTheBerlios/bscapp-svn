
package nachhaltigkeit ;

import java.awt.Font ;
import java.util.ArrayList ;
import java.util.List ;

import javax.swing.JPanel ;
import javax.swing.JTextField ;
import javax.swing.tree.DefaultMutableTreeNode ;
import javax.swing.tree.MutableTreeNode ;

/**
 * @author andre
 * 
 */
public abstract class MyTreeNode extends DefaultMutableTreeNode
{
	private static final Font SMALL_FONT = new Font("Dialog", Font.BOLD, 10) ;

	private List<MyTreeNode> untergebeneNodes = new ArrayList<MyTreeNode>(3) ;
	protected String bezeichnung ;

	/**
	 * @param userObject
	 */
	public MyTreeNode(String bezeichnung)
	{
		super(bezeichnung) ;
		this.bezeichnung = bezeichnung ;
	}

	protected JTextField machÜberschrift()
	{
		// zeige überschrift im northbereich des panels an:
		JTextField überschrift = new JTextField() ;
		überschrift.setFont(SMALL_FONT) ;
		überschrift.setText("Dieses Diagramm wurde von " + bezeichnung
		                    + " gezeichnet.") ;
		überschrift.setEditable(false) ;
		return überschrift ;
	}

	/**
	 * Diese Methode wird von allen Elementen im jTree implementiert. Wenn ein
	 * Element angeklickt wird dann wird durch dessen Implementierung ein
	 * entsprechendes Diagramm gezeichnet und als JPanel zurückgegeben.
	 * @author andre
	 */
	public abstract JPanel gibDiagramm() ;

	/**
	 * @return the bezeichnung
	 */
	public String getBezeichnung()
	{
		return this.bezeichnung ;
	}

	/**
	 * @return the untergebeneNodes
	 */
	public List<MyTreeNode> getUntergebeneNodes()
	{
		return this.untergebeneNodes ;
	}

	@ Override
	public void add(MutableTreeNode newChild)
	{
		super.add(newChild) ;
		if( newChild instanceof MyTreeNode )
		{
			untergebeneNodes.add((MyTreeNode)newChild) ;
		}
	}
}
