/**
 * 
 */
package datenModell.tests;



import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
      Bericht.klasse(TabelleBlatt.class.getName());
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


   public void testWertzuweisungen()
   {
      List<Point2D.Double> vergleichswerte = new ArrayList<Point2D.Double>();
      List<Point2D.Double> testwerte = new ArrayList<Point2D.Double>();

      Random r = new Random(1L);

      Bericht.methode("teste das zuwesen von daten", this);
      Bericht.sag("versuche änderungen an zufälligen datenreihen durchzuführen");

      int anzahl = 0;
      for(int n = 0; n < 1000; n ++ )
      {
         anzahl ++ ;

         blatt = new TabelleBlatt("test");
         testwerte.clear();
         vergleichswerte.clear();

         switch(r.nextInt(3))
         {
            case 0 :
               testwerte = blatt.getWerteA();
               break;
            case 1 :
               testwerte = blatt.getWerteB();
               break;
            default :
               testwerte = blatt.getWerteC();
               break;
         }

         for(int i = r.nextInt(1000); i < 1000; i ++ )
         {
            double x = 1000000 - r.nextDouble() * 2000000;
            double y = 1000000 - r.nextDouble() * 2000000;

            testwerte.add(new Point2D.Double(x, y));
            vergleichswerte.add(new Point2D.Double(x, y));
         }

         for(int i = 0; i < vergleichswerte.size(); i ++ )
         {
            Point2D.Double testP = vergleichswerte.get(i);
            Point2D.Double verglP = vergleichswerte.get(i);

            assertEquals(testP.x, verglP.x);
            assertEquals(testP.y, verglP.y);
         }
      }

      Bericht.sag("    " + anzahl
                  + " mal zufällige anzahl mit zuf. werten geprüft.");
   }
}
