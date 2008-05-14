package benutzerModell;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



/**
 * BenutzerDatenbank erstelle eine HashMap<String, Leser>, hat
 * Methoden um die Datenbank zuverwalten.
 * 
 * @author Pinter
 */

public class BenutzerDatenbank implements Serializable
{

  /**
   * 
   */
  private static final long serialVersionUID = 737661576479271163L;

  private Map<String, Leser> benutzerDatenbank;

  private static BenutzerDatenbank bd;
  private static final Administrator ROOT = new Administrator("root", "123");
  private static final Administrator TEST_ADMIN = new Administrator("testadmin",
                                                                    "123");
  private static final Schreiber TEST_SCHREIBER = new Schreiber("testschreiber",
                                                                "123");
  private static final Leser TEST_LESER = new Leser("testleser", "123");
  private static final String BD_DATEINAME = "benutzerdb.user";


  /**
   * erzeugt die benutzerDatenbank
   */
  private BenutzerDatenbank()
  {
    benutzerDatenbank = new HashMap<String, Leser>();

    // root nicht auskommentieren!
    benutzerDatenbank.put("root", ROOT);

    // wird auskommentiert, da nur zum testen
    benutzerDatenbank.put("testadmin", TEST_ADMIN);
    benutzerDatenbank.put("testschreiber", TEST_SCHREIBER);
    benutzerDatenbank.put("testleser", TEST_LESER);
  }


  /**
   * erstellt eine Statische Benutzerdatenbank die nur einmal erzeugt
   * werden kann.
   * 
   * @return bd -> Benutzerdatenbank
   */
  public static BenutzerDatenbank datenBankFactory()
  {
    if(bd == null)
    {
      bd = ladeAusDatei();
    }

    if(bd == null)
    {
      bd = new BenutzerDatenbank();
      speichereInDatei();
    }

    return bd;
  }


  /**
   * 
   */
  private static void speichereInDatei()
  {
    if(bd == null)
    {
      return;
    }

    File f = new File(BD_DATEINAME);

    ObjectOutputStream oos;

    try
    {
      oos = new ObjectOutputStream(new FileOutputStream(f));
      oos.writeObject(bd);
      oos.flush();
      oos.close();
      System.out.println("user gepeichert unter: " + f.getAbsolutePath());
    }
    catch(Exception exc)
    {
      exc.printStackTrace();
      return;
    }
  }


  /**
   * @return
   */
  private static BenutzerDatenbank ladeAusDatei()
  {
    File f = new File(BD_DATEINAME);

    if( ! f.exists())
    {
      return null;
    }

    ObjectInputStream ois;
    Object read;

    try
    {
      ois = new ObjectInputStream(new FileInputStream(f));
      read = ois.readObject();
      ois.close();
    }
    catch(Exception exc)
    {
      exc.printStackTrace();
      return null;
    }

    if(read instanceof BenutzerDatenbank)
    {
      System.out.println("user geladen von: " + f.getAbsolutePath());
      return (BenutzerDatenbank)read;
    }
    else
    {
      return null;
    }
  }


  /**
   * fügt der Datenbank einen User hinzu
   * 
   * @param benutzername-String
   * @param leser-Objekt
   */
  public void hinzufuegen(String benutzername, Leser leser)
  {
    benutzerDatenbank.put(benutzername, leser);
    speichereInDatei();
  }


  /**
   * Zum ermitteln, ob der user existiert
   * 
   * @param benutzername-String
   * @return true wenn Benutzer in der Datenbank, false wenn Benutzer
   *         nicht in der Datenbank
   */

  public boolean findBenutzer(String benutzername)
  {
    for(String s : benutzerDatenbank.keySet())
    {
      if(benutzername.equalsIgnoreCase(benutzerDatenbank.get(s)
                                                        .getBenutzername()))
      {
        return true;
      }
    }
    return false;
  }


  /**
   * löscht einen Benutzer aus der Datenbank
   * 
   * @param benutzername-String
   */

  public void loeschen(String benutzername)
  {
    // root wird nie gelöscht!
    if(benutzername.equalsIgnoreCase(ROOT.getBenutzername()))
      return;

    benutzerDatenbank.remove(benutzername);
  }


  /**
   * Setzt die Log_Variable auf True, wenn der Benutzer im System
   * vorhanden ist
   * 
   * @param benutzername
   *          String
   * @param passwort
   *          String
   * @return wenn das einloggen funktioniert dann wird der Leser
   *         zurückgegeben
   */
  public Leser einloggen(String benutzername, String passwort)
  {
    Leser leser = benutzerDatenbank.get(benutzername);
    if(leser != null)
    {
      if(passwort.equals(leser.getPasswort()))
      {
        leser.setLog();
        return leser;
      }
      else
      {
        System.out.println("Passwort falsch!");
        return null;
      }
    }
    else
    {
      System.out.println("Benutzer unbekannt");
      return null;
    }
  }


  /**
   * Ändert das Passwort ohne kontrolle des Orginalpasswortes wichtige
   * für Administratoren
   * 
   * @param benutzername -
   *          String
   * @param passwort -
   *          String
   */
  public void kennwortAendern(String benutzername, String passwort)
  {
    Leser le = null;
    le = getLeser(benutzername);
    le.setPasswort(passwort);
  }


  /**
   * Gibt das Leser-Objekt zurück
   * 
   * @param benutzername -
   *          String Benutzername den man suchen will
   * @return User
   */
  public Leser getLeser(String benutzername)
  {
    return benutzerDatenbank.get(benutzername);
  }


  /**
   * @return
   */
  public Map<String, Leser> getBenutzerDatenbank()
  {
    return benutzerDatenbank;
  }


}
