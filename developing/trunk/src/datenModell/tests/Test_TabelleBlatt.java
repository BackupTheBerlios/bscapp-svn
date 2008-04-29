/**
 * 
 */
package datenModell.tests;



import junit.framework.TestCase;
import datenModell.Bewertbar;
import datenModell.TabelleBlatt;



/**
 * @author andre
 */
public class Test_TabelleBlatt extends TestCase
{
  private TabelleBlatt blatt;
  private Bewertbar bewertbar;


  /*
   * (non-Javadoc)
   * 
   * @see junit.framework.TestCase#setUp()
   */
  protected void setUp() throws Exception
  {
    blatt = new TabelleBlatt("testblatt");
    bewertbar = blatt;
  }


  /**
   * Test method for {@link datenModell.TabelleBlatt#TabelleBlatt()}.
   */
  public void testTabelleBlatt()
  {
    Bericht.klasse( TabelleBlatt.class.getName());
    Bericht.methode("teste den konstruktor der klasse", this);

    Bericht.sag("die instanz darf nach dem erstellen nicht null sein");
    bewertbar = blatt;
    assertTrue(bewertbar.getTitel().equals("testblatt"));

    Bericht.sag("prüfe die initialen werte der neu initialisierten klasse");
    assertTrue(bewertbar.getPrioritaet() == 0);
    assertTrue(bewertbar.getZusammenfassung() == 1);


  }


  /**
   * Test method for
   * {@link datenModell.TabelleBlatt#getZusammenfassung()}.
   */
  public void testGetZusammenfassung()
  {
    Bericht.methode("teste das zusammenfassen der werte", this);
    Bericht.sag("versuche, die werte zu ändern: mit gültigen werten");
    for(double d = 0.0; d <= 10.0; d += 0.5)
    {
      bewertbar.setPrioritaet(d);
      assertTrue(bewertbar.getPrioritaet() == d);
    }
    for(double d = 1.0; d <= 5.0; d += 0.5)
    {
      bewertbar.setZusammenfassung(d);
      assertTrue(bewertbar.getZusammenfassung() == d);
    }
    
    Bericht.sag("versuche, die werte zu ändern: mit ungültigen werten < 0");
    bewertbar.setPrioritaet( - 10);
    bewertbar.setZusammenfassung( - 10);
    assertFalse(bewertbar.getPrioritaet() == - 10);
    assertFalse(bewertbar.getZusammenfassung() == - 10);

    Bericht.sag("versuche, die werte zu ändern: mit ungültigen werten > 10");
    bewertbar.setPrioritaet(100);
    bewertbar.setZusammenfassung(100);
    assertFalse(bewertbar.getPrioritaet() == 100);
    assertFalse(bewertbar.getZusammenfassung() == 100);
  }
}
