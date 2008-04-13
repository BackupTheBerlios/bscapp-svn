/**
 * 
 */
package gui;



import gui.helfer.MeinGuiTool;
import javax.swing.JTree;
import datenModell.Auswertung;
import datenModell.Bereich;



/**
 * @author andre
 */
@ SuppressWarnings( "serial" )
public class BSCGui extends MeinGuiTool
{
	private Auswertung auswertung;
	private JTree jtree;


	public BSCGui()
	{
		super();
		auswertung = Auswertung.getInstanz();
		auswertung.add( new Bereich("bereich 1") );
		jtree = new JTree( auswertung );
		
		west.add(jtree);
		super.zeige();
	}
}
