package benutzerModell;


/**
 * 
 * Der Schreiber erbt von der Klasse Leser(er verwendet somit die gleichen Methoden). Er 
 * unterscheid sich zum Leser nur dadurch das er auch Daten eingeben, löschen und speichern 
 * darf.
 * 
 * @author Pinter
 *
 */

public class Schreiber extends Leser
{
  /**
   * 
   */
  private static final long serialVersionUID = - 8844245982725310403L;

  public Schreiber(String benutzername, String passwort)
  {
    super(benutzername, passwort);
    gruppe = Gruppe.SCHREIBER;
  }
}
