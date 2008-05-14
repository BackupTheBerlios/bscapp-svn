package benutzerModell;



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
