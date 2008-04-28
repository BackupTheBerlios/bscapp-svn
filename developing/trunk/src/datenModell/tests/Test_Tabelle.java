/**
 * 
 */
package datenModell.tests;



import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import datenModell.Tabelle;
import datenModell.TabelleBlatt;
import junit.framework.TestCase;



/**
 * @author andre
 */
public class Test_Tabelle extends TestCase
{
  Tabelle tabelle;
  List<TabelleBlatt> blätter;


  /*
   * (non-Javadoc)
   * 
   * @see junit.framework.TestCase#setUp()
   */
  protected void setUp() throws Exception
  {
    tabelle = new Tabelle("testtabelle");

    // erstelle einige blätter in einer liste zu testzwecken:
    blätter = new ArrayList<TabelleBlatt>();
    blätter.add((TabelleBlatt)tabelle.getFirstChild());
    for(int i = 0; i < 10; i ++ )
    {
      TabelleBlatt b = new TabelleBlatt("testblatt " + i);
      b.setZusammenfassung(1);
      b.setPrioritaet(0);
      blätter.add(b);
      assertTrue(blätter.get(i).getZusammenfassung() == 1);
      assertTrue(blätter.get(i).getPrioritaet() == 0);
    }
  }


  /**
   * Test method for
   * {@link datenModell.Tabelle#Tabelle(java.lang.String)}.
   */
  public void testTabelle()
  {
    Bericht.klasse("Starte den Test der Klasse " + Tabelle.class.getName());
    Bericht.methode("teste den konstruktor der klasse", this);

    Bericht.sag("prüfe die initialen werte der neu initialisierten klasse");
    assertEquals(tabelle.getZusammenfassung(), 0.0);
    assertEquals(tabelle.getPrioritaet(), 0.0);

    Bericht.sag("teste das betiteln");
    assertNotNull(tabelle);
    assertTrue(tabelle.getTitel().equals("testtabelle"));
    tabelle.setTitel("anderer titel");
    assertFalse(tabelle.getTitel().equals("testtabelle"));
  }


  public void testeWeitergabeZusammenfassgEinesBlattes()
  {
    Bericht.methode("teste die korrekte zusammenfassung bei einem blatt", this);

    Bericht.sag("versuche der tabelle illegalerweise eine zusammenfassung zuzuordnen");
    tabelle.setZusammenfassung(3.0);
    assertNotSame(tabelle.getZusammenfassung(), 3.0);
    assertEquals(tabelle.getZusammenfassung(), 0.0);

    Bericht.sag("ändere das (initiale) TabellenBlatt dieser Tabelle, prüfe dabei richtige ermittlung der werte");
    Bericht.sag("...alle Kombinationen: prior. 1-10 und zusammenf. 1-5 jeweils in 0.5-schritten aufwärts");
    for(double p = 1; p <= 10; p += 0.5) // prioritäten 1-10
    {
      for(double z = 1.0; z <= 5.0; z += 0.5) // zusammenfassungen 1-5
      {
        ((TabelleBlatt)tabelle.getFirstChild()).setPrioritaet(p);
        ((TabelleBlatt)tabelle.getFirstChild()).setZusammenfassung(z);
        assertEquals(tabelle.getZusammenfassung(), z);
      }
    }
  }


  @SuppressWarnings("unchecked")
  public void testeZusammenfassung_01()
  {
    Bericht.methode("teste die berechnung der zusammenfassungen", this);

    // baue ausgangssituation zusammen: (1 child ist schon
    // vorhanden, deswegen 5 mal)
    for(int i = 0; i < 5; i ++ )
    {
      TabelleBlatt b = blätter.get(i);
      tabelle.add(b);
    }

    // prüfe, ob alles gut gegangen ist:
    Enumeration<TabelleBlatt> children = tabelle.children();
    assertTrue(children.hasMoreElements());
    while(children.hasMoreElements())
    {
      assertTrue(blätter.contains(children.nextElement()));
    }

    Set<TabelleBlatt> testbett = new HashSet<TabelleBlatt>();

    Enumeration<TabelleBlatt> e = tabelle.children();
    assertTrue(e.hasMoreElements());

    do
    {
      TabelleBlatt blatt = e.nextElement();
      testbett.add(blatt);
    }
    while(e.hasMoreElements());

    Random random = new Random();
    // random.setSeed(0L);

    for(int i = 0; i < 1000; i ++ )
    {
      String errormsg = "";

      double pMalZsumme = 0.0;
      double priSumme = 0.0;
      int n = 0;

      Enumeration<TabelleBlatt> blttr = tabelle.children();
      while(blttr.hasMoreElements())
      {
        TabelleBlatt blatt = blttr.nextElement();

        // eine zufallszahl zwischen 1 und 5:
        double zusRandom = ((Integer)(random.nextInt(5) + 1)).doubleValue();

        // eine zufallszahl zwischen 1 und 5:
        double priRandom = ((Integer)(random.nextInt(10) + 1)).doubleValue();



        // kontrollwerte:
        pMalZsumme += zusRandom * priRandom;
        priSumme += priRandom;

        // einsetzen ins blatt
        blatt.setZusammenfassung(zusRandom);
        blatt.setPrioritaet(priRandom);
        assertEquals(blatt.getZusammenfassung(), zusRandom);
        assertEquals(blatt.getPrioritaet(), priRandom);


        errormsg += "\np(" + n
                    + ")= "
                    + priRandom
                    + "      z("
                    + n
                    + ")= "
                    + zusRandom
                    + " (sollwerte)";
        errormsg += "\np(" + n
                    + ")= "
                    + blatt.getPrioritaet()
                    + "      z("
                    + n
                    + ")= "
                    + blatt.getZusammenfassung()
                    + " (istwerte)";
        n ++ ;
      }
      errormsg += "\nsummePmalZ= " + pMalZsumme
                  + " / prioritätensumme= "
                  + priSumme
                  + "durchschnittsnote = "
                  + pMalZsumme
                  / priSumme
                  + " (sollwerte)";
      errormsg += "\nzusammenfassung= " + tabelle.getZusammenfassung()
                  + " (istwert)";

      if(tabelle.getZusammenfassung() != pMalZsumme / priSumme)
      {
        tabelle.getZusammenfassung();
      }
      
      assertEquals(errormsg,
                   tabelle.getZusammenfassung(),
                   pMalZsumme / priSumme);
    }
  }
}
