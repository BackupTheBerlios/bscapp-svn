package benutzerModell;



import java.io.Serializable;
import java.util.HashSet;



public class Leser implements Serializable
{

  /**
   * 
   */
  private static final long serialVersionUID = 1646957071352770096L;


  public enum Gruppe
  {
    LESER, SCHREIBER, ADMINISTRATOR;

    @Override
    public String toString()
    {
      switch(this)
      {
        case ADMINISTRATOR :
          return "Administrator";
        case SCHREIBER :
          return "Schreiber";
        default :
          return "Leser";
      }
    }
  }

  protected Gruppe gruppe;

  private HashSet<String> setPasswort;

  private String benutzername;

  private String passwort;

  private boolean log;


  /**
   * Erstelle eine Leser-Objekt
   * 
   * @param benutzername
   *          Eingabe eines Benutzernamen-String
   * @param passwort
   *          Eingabe eines Passworte-String
   */
  public Leser(String benutzername, String passwort)
  {
    this.benutzername = benutzername;
    this.passwort = passwort;
    log = false;
    setPasswort = new HashSet<String>();
    setPasswort.add(passwort);
    this.gruppe = Gruppe.LESER;
  }


  public Gruppe getGruppe()
  {
    return gruppe;
  }


  /**
   * setzt einen neuen Benutzernamen
   * 
   * @param benutzername
   */
  public void setBenutzername(String benutzername)
  {
    this.benutzername = benutzername;
  }


  /**
   * @return benutzername;
   */

  public String getBenutzername()
  {
    return benutzername;
  }


  /**
   * @return Passwort des Benutzers
   */
  public String getPasswort()
  {
    return passwort;
  }


  /**
   * Setzt ein neues Passwort
   * 
   * @param passwort
   * @return neues Passwort-Benutzer
   */
  public String setPasswort(String passwort)
  {
    setPasswort.add(passwort);
    return this.passwort = passwort;
  }


  /**
   * setzt die log-Variable auf true, Benutzer am System angemeldet
   */
  public void setLog()
  {
    log = true;
  }


  /**
   * gibt zurück ob Benutzer angemeldet ist
   * 
   * @return true -> Benutzer angemeldet false -> Benutzer nicht
   *         angemeldet
   */
  public boolean getLog()
  {
    return log;
  }


  /**
   * settz das Datenfeld Log auf false
   * 
   * @return log-Datenfeld
   */

  public boolean ausLoggen()
  {
    return log = false;
  }


  public void passwortAendern(String altesPasswort, String neuesPasswort)
  {
    if(log == true)
    {
      if(getPasswort().equals(altesPasswort))
      {

        if(setPasswort.contains(neuesPasswort))
        {
          System.out.println("altes und neues Passwort gleich");

        }
        else
        {
          setPasswort(neuesPasswort);
        }
      }
      else
      {
        System.out.println("Falsches Passwort!");
      }
    }
    else
    {
      System.out.println("Bite einloggen");
    }

  }


}
