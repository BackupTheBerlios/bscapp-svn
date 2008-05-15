package benutzerModell;



/**
 * Administrator darf alles was auch der Leser darf, aber er hatt noch
 * einige andren Methoden um die BSC zu verwalten und natürlich auch
 * um die Benutzer der Software zu verwalten
 * 
 * @author Pinter
 */

public class Administrator extends Schreiber
{
  /**
   * 
   */
  private static final long serialVersionUID = - 5578118123503649304L;


  public Administrator(String benutzername, String passwort)
  {
    super(benutzername, passwort);
    gruppe = Gruppe.ADMINISTRATOR;
  }


  /**
   * fügt einen neuen Benutzer zur Datenbank hinzu
   * 
   * @param benutzername -
   *          string
   * @param leser -
   *          Leser Objekt
   */

  public void hinzufuegen(String benutzername, Leser leser)
  {
    BenutzerDatenbank.datenBankFactory().hinzufuegen(benutzername, leser);
  }


  /**
   * löscht einen Benutzer aus der Datenbank
   * 
   * @param benutzername -
   *          String
   */
  public void loeschen(String benutzername)
  {
    BenutzerDatenbank.datenBankFactory().loeschen(benutzername);
  }


  /**
   * ändern des Passwortes des Administrators
   */
  @Override
  public void passwortAendern(String altesPasswort, String neuesPasswort)
  {
    super.passwortAendern(altesPasswort, neuesPasswort);
  }


  public void kennwortAendernBenutzer(String benutzername, String passwort)
  {
    BenutzerDatenbank.datenBankFactory()
                     .kennwortAendern(benutzername, passwort);
  }

}
