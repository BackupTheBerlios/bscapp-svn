/**
 * 
 */
package datenModell;



import javax.swing.JPanel;



/**
 * Garantiert die f�higkeit der ausgabe eines diagramms.
 * 
 * @author andre
 */
public interface Diagrammable
{
	/**
	 * erzeugt ein diagramm der Instanz der Implementation
	 * 
	 * @return JPanel, das das diagramm enth�lt.
	 */
	public JPanel getJDiagramm();
}
