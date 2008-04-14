/**
 * 
 */
package datenModell;



import gui.helfer.DiagrammFactory;
import javax.swing.JPanel;



/**
 * garantiert einem node folgende f�higkeiten:
 * <li> die ausgabe eines diagrammes.
 * <li> das setzen der priorit�t ( gewichtung )
 * <li> das auslesen der priorit�t ( gewichtung )
 * <li> das setzen des zusammenfassungswertes
 * <li> das auslesen des zusammenfassungswertes
 * 
 * @author andre
 */
public interface Bewertbar
{
	/**
	 * erzeugt ein diagramm das, den aktuellen node repr�sentiert.
	 * 
	 * @param typ
	 *            der typ des diagramms laut DiagrammFactory.TYP
	 * @return JPanel, das das diagramm enth�lt.
	 */
	public JPanel getJDiagramm( DiagrammFactory.TYP typ );


	/**
	 * gibt die zusammenfassung des jeweiligen nodes zur�ck. das ist
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
	 * gibt die priorit�t(gewichtung) des aktuellen nodes zur�ck.
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
