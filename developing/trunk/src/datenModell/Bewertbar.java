/**
 * 
 */
package datenModell;



import gui.helfer.DiagrammFactory;
import javax.swing.JPanel;



/**
 * garantiert einem node folgende fähigkeiten:
 * <li> die ausgabe eines diagrammes.
 * <li> das setzen der priorität ( gewichtung )
 * <li> das auslesen der priorität ( gewichtung )
 * <li> das setzen des zusammenfassungswertes
 * <li> das auslesen des zusammenfassungswertes
 * 
 * @author andre
 */
public interface Bewertbar
{
	/**
	 * erzeugt ein diagramm das, den aktuellen node repräsentiert.
	 * 
	 * @param typ
	 *            der typ des diagramms laut DiagrammFactory.TYP
	 * @return JPanel, das das diagramm enthält.
	 */
	public JPanel getJDiagramm( DiagrammFactory.TYP typ );


	/**
	 * gibt die zusammenfassung des jeweiligen nodes zurück. das ist
	 * ein herunterbrechen aller werte des nodes auf einen einzigen
	 * double-wert
	 * 
	 * @return die zusammenfassung
	 */
	public double getZusammenfassung();


	/**
	 * setzt die zusammenfassung des aktuellen nodes. das ist ein
	 * herunterbrechen aller werte des nodes auf einen einzigen
	 * double-wert
	 * 
	 * @param zusammenfassung
	 *            die neue zusammenfassung
	 */
	public void setZusammenfassung( double zusammenfassung );


	/**
	 * gibt die priorität(gewichtung) des aktuellen nodes zurück.
	 * diese bestimmt, wie viel die zusammenfassung des nodes im
	 * vergleich zu seinen geschwisternodes wiegt.
	 * 
	 * @return prioritaet des nodes
	 */
	public double getPrioritaet();


	/**
	 * setzt die prioritaet des aktuellen nodes auf den angegebenen
	 * wert. diese bestimmt, wie viel die zusammenfassung des nodes im
	 * vergleich zu seinen geschwisternodes wiegt.
	 */
	public void setPrioritaet( double prioritaet );
}
