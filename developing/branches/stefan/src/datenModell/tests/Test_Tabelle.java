/**
 * 
 */
package datenModell.tests;



import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import junit.framework.TestCase;
import datenModell.Bereich;
import datenModell.Tabelle;
import datenModell.TabelleBlatt;



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
   @Override
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
      Bericht.klasse(Tabelle.class.getName());
      Bericht.methode("teste den konstruktor der klasse", this);

      Bericht.sag("prüfe initiale werte der neuen instanz");
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
      Bericht.methode("teste die korrekte speicherung bei einem blatt",
                      this);

      Bericht.sag("versuche (illegal) eine zusammenfassung zuzuordnen");
      tabelle.setZusammenfassung(3.0);
      assertNotSame(tabelle.getZusammenfassung(), 3.0);
      assertEquals(tabelle.getZusammenfassung(), 0.0);

      Bericht.sag("ändere initialess Blatt dieser Tabelle, prüfe ermittlung der z-werte");
      Bericht.sag("   alle Kombinationen: p= 1-10 und z= 1-5 jeweils in 0.5-schritten");
      for(double p = 1; p <= 10; p += 0.5) // prioritäten 1-10
      {
         for(double z = 1.0; z <= 5.0; z += 0.5) // zus 1-5
         {
            ((TabelleBlatt)tabelle.getFirstChild()).setPrioritaet(p);
            ((TabelleBlatt)tabelle.getFirstChild()).setZusammenfassung(z);
            assertEquals(tabelle.getZusammenfassung(), z);
         }
      }
   }


   @SuppressWarnings("unchecked")
   public void testeZusammenfassung_1blatt()
   {
      Bericht.methode("teste die berechnung der z mit 6 blättern",
                      this);

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


   }


   @SuppressWarnings("unchecked")
   public void testeZusammenfassung_2blaetter()
   {
      Enumeration e = tabelle.children();
      while(e.hasMoreElements())
      {
         assertEquals(1.0, ((Tabelle)e.nextElement()).getZusammenfassung());
      }
      assertEquals(0.0, tabelle.getZusammenfassung());
      Bericht.sag("testmethoden wird eine toleranz von 1/10^6 erlaubt (rundungsfehler)");
      Bericht.sag("ordne allen blättern denselben wert zu, prüfe durchschnitt.");
      int anzahl = 0;
      for(double i = 1; i < 5.0; i += 0.00004)
      {
         e = tabelle.children();
         while(e.hasMoreElements())
         {
            Tabelle element = (Tabelle)e.nextElement();
            element.setPrioritaet(1);
            element.setZusammenfassung(i);
            assertEquals(i, element.getZusammenfassung());
         }
         anzahl ++ ;
         assertEquals(i, tabelle.getZusammenfassung(), 0.000001);
      }
      Bericht.sag("    " + anzahl
                  + " linear ansteigende werte zw. 1 und 5 getestet");
   }


   @SuppressWarnings("unchecked")
   public void testeZusammenfassung_Xblaetter()
   {
      Random random;
      int anzahl;

      Bericht.sag("teste algorithmus mit 2 blättern, verschiedene z, gleiche p");
      tabelle.removeAllChildren();
      assertEquals(1, tabelle.getChildCount());
      tabelle.add(new TabelleBlatt("zweites"));

      TabelleBlatt eins = (TabelleBlatt)tabelle.getFirstChild();
      TabelleBlatt zwei = (TabelleBlatt)tabelle.getChildAfter(eins);
      eins.setPrioritaet(1);
      zwei.setPrioritaet(1);

      random = new Random(1L);
      anzahl = 0;
      for(double d = 0.0; d <= 4.0; d += 0.00004)
      {
         eins.setPrioritaet(1);
         zwei.setPrioritaet(1);
         eins.setZusammenfassung(1 + d);
         zwei.setZusammenfassung(5 - d);
         assertEquals(3.0, tabelle.getZusammenfassung(), 0.000001);

         int rand1 = random.nextInt(5) + 1;
         int rand2 = random.nextInt(5) + 1;

         eins.setZusammenfassung(rand1);
         zwei.setZusammenfassung(rand2);

         assertEquals((rand1 + rand2) * 0.5,
                      tabelle.getZusammenfassung(),
                      0.000001);
         anzahl ++ ;
      }
      Bericht.sag("    " + anzahl + " zufällige kombinationen wurden getestet.");
   }


   @SuppressWarnings("unchecked")
   public void testeZusammenfassung_ZusammenfZufällig()
   {
      Random random;
      int anzahl;

      Bericht.sag("teste zufällig viele, bewertete blätter derselben priorität.");
      anzahl = 0;

      random = new Random(1L);
      for(int i = 0; i < 100000; i ++ )
      {
         tabelle = new Tabelle("yyy");

         // int zwischen 1 und 5, anzahl
         // der einzufügenden blätter (1 ist schon drin)
         int einzufügen = random.nextInt(5) + 1;// füge x blätter ein
         double summeAllerNoten = 0;
         double anzahlNoten = 0;

         for(int j = 1; j < einzufügen; j ++ )
         {
            TabelleBlatt b = new TabelleBlatt("blatt" + j);
            tabelle.add(b);
         }
         assertEquals(einzufügen, tabelle.getChildCount());

         Enumeration enu = tabelle.children();
         while(enu.hasMoreElements())
         {
            double zufallsnote = random.nextDouble() * 4 + 1;
            summeAllerNoten += zufallsnote;
            anzahlNoten += 1.0;
            TabelleBlatt b = (TabelleBlatt)enu.nextElement();
            b.setZusammenfassung(zufallsnote);
            b.setPrioritaet(3);
         }

         assertEquals(tabelle.getZusammenfassung(),
                      summeAllerNoten / anzahlNoten,
                      0.000001);
         anzahl ++ ;
      }
      Bericht.sag("    " + anzahl + " zufällige kombinationen wurden getestet");
   }


   @SuppressWarnings("unchecked")
   public void testeZufaellig_Anz_Prio_Zus()
   {
      Bericht.sag("teste zufällig viele, zusammengefasste und gewichtete blätter");

      int anzahl = 0;

      // mach 1 million mal:
      for(int i = 0; i < 100000; i ++ )
      {
         anzahl ++ ;
         zufaelligeTabelleMitNurBlaettern();
      }

      Bericht.sag("    " + anzahl + " zufällige kombinationen wurden getestet");
   }


   @SuppressWarnings("unchecked")
   private Tabelle zufaelligeTabelleMitNurBlaettern()
   {
      Random zuf_gen = new Random();

      double sum_prioritäten; // die summe der prioritäten
      double sum_P_mal_Z; // die summe der gewichteten zusammenfas.

      int zuf_anzahl; // die zufällige anzahl der blätter
      double zuf_priorität; // die zufällig erzeugte priorität
      double zuf_zusammenf; // die zufällig erzeugte zusamenfassung

      // initialisiere die ausgangswerte:
      Tabelle tab = new Tabelle("zufall");
      sum_prioritäten = 0;
      sum_P_mal_Z = 0;

      // 0-5 (inkl.) blätter werden eingefügt:
      zuf_anzahl = zuf_gen.nextInt(6);

      // erzeuge die blätter:
      for(int j = 0; j < zuf_anzahl; j ++ )
      {
         TabelleBlatt b = new TabelleBlatt("test");
         tab.add(b);
      }

      // ist die anzahl korrekt?
      assertEquals(zuf_anzahl + 1, tab.getChildCount());

      // hole mir alle blätter dieser tabelle:
      Enumeration<TabelleBlatt> blätter = tab.children();

      // befülle diese blätter mit zufallswerten:
      while(blätter.hasMoreElements())
      {
         zuf_priorität = zuf_gen.nextDouble(); // double: 0-1
         zuf_priorität *= 10; // priorität ist zwischen 0 und 10

         zuf_zusammenf = zuf_gen.nextDouble();// double: 0-1
         zuf_zusammenf *= 4; // 0-4
         zuf_zusammenf += 1; // zusammenfist zwischen 1 und 5

         // speichere die zur kontrolle nötigen werte zwischen:
         double p_Mal_Z = zuf_priorität * zuf_zusammenf;
         sum_P_mal_Z += p_Mal_Z;
         sum_prioritäten += zuf_priorität;

         // speichere die werte im blatt:
         TabelleBlatt b = blätter.nextElement();
         b.setPrioritaet(zuf_priorität);
         b.setZusammenfassung(zuf_zusammenf);

         // garantiere, dass das blatt korrekt bewertet ist:
         assertTrue(b.getZusammenfassung() == zuf_zusammenf);
         assertTrue(b.getPrioritaet() == zuf_priorität);

      } // ende von: while(blätter.hasMoreElements())

      // vergleiche zusammenf der tabelle mit dem:
      double erwarteteZusammenf = sum_P_mal_Z / sum_prioritäten;
      assertEquals(erwarteteZusammenf, tab.getZusammenfassung(), 0.000001);

      zuf_priorität = zuf_gen.nextDouble(); // double: 0-1
      zuf_priorität *= 10; // priorität ist zwischen 0 und 10
      tab.setPrioritaet(zuf_priorität);

      return tab;
   }


   @SuppressWarnings("unchecked")
   public void testeMitZufallsHierarchie()
   {
      Bericht.sag("teste hierarchie mit zufälligen werten und gewichtungen und struktur");

      Random zuf_gen = new Random(1l);

      double sum_prioritäten; // die summe der prioritäten
      double sum_P_mal_Z; // die summe der gewichteten zusammenfas.

      double zuf_priorität; // die zufällig erzeugte priorität
      double zuf_zusammenf; // die zufällig erzeugte zusamenfassung

      int durchgänge = 0;
      for(int n = 0; n < 100000; n ++ )
      {
         durchgänge ++ ;

         Bereich bereich = new Bereich("berecih");
         sum_prioritäten = 0;
         sum_P_mal_Z = 0;

         String error = "";


         // füge zufällig viele tabellen in den bereich ein:
         int anzahlkinder = zuf_gen.nextInt(5) + 1;
         error += "füge: " + anzahlkinder + " kinder ein:";

         for(int i = anzahlkinder; i > 0; i -- )
         {

            Tabelle t;


            // 25 % ein blatt wird eingefügt:
            if(zuf_gen.nextBoolean() && zuf_gen.nextBoolean())
            {
               error += " blatt, ";

               zuf_priorität = zuf_gen.nextDouble(); // double: 0-1
               zuf_priorität *= 10; // priorität ist zwischen 0 und 10
               zuf_zusammenf = zuf_gen.nextDouble();// double: 0-1
               zuf_zusammenf *= 4; // 0-4
               zuf_zusammenf += 1; // zusammenf ist zwischen 1 und 5

               t = new TabelleBlatt("blatt ebene 1");
               t.setZusammenfassung(zuf_zusammenf);
               t.setPrioritaet(zuf_priorität);
            }


            else
            {


               // 37.5 % eine tabelle mit nur blättern wird eingefügt:
               if(zuf_gen.nextBoolean())
               {
                  error += " tab_nur_blätter,";

                  t = zufaelligeTabelleMitNurBlaettern();

                  Enumeration kinder = t.children();
                  while(kinder.hasMoreElements())
                  {
                     zuf_priorität = zuf_gen.nextDouble(); // double:
                     // 0-1
                     zuf_priorität *= 10; // priorität zwischen 0 und
                     // 10
                     zuf_zusammenf = zuf_gen.nextDouble();// double:
                     // 0-1
                     zuf_zusammenf *= 4; // 0-4
                     zuf_zusammenf += 1; // zusammenf zwischen 1 und
                     // 5

                     TabelleBlatt kind = (TabelleBlatt)kinder.nextElement();
                     kind.setPrioritaet(zuf_priorität);
                     kind.setZusammenfassung(zuf_zusammenf);
                  }


               } // ende von: if(zuf_gen.nextBoolean())


               // 37.5 % eine tabelle mit lauter tabellen wird
               // eingefügt:
               else
               {
                  error += " tab_mit_tabellen";

                  t = new Tabelle("tabelle ebene 1");

                  for(int j = zuf_gen.nextInt(5); j > 0; j -- )
                  {
                     t.add(zufaelligeTabelleMitNurBlaettern());
                  }

                  Enumeration enumer = t.children();

                  while(enumer.hasMoreElements())
                  {
                     zuf_priorität = zuf_gen.nextDouble(); // double:
                     // 0-1
                     zuf_priorität *= 10; // priorität zwischen 0 und
                     // 10
                     Tabelle kind = (Tabelle)enumer.nextElement();
                     kind.setPrioritaet(zuf_priorität);
                  }



                  zuf_priorität = zuf_gen.nextDouble(); // 0-1
                  zuf_priorität *= 10; // priorität zwischen 0-10
                  t.setPrioritaet(zuf_priorität);
                  error += "(p=" + t.getPrioritaet()
                           + ", z="
                           + t.getZusammenfassung()
                           + "); ";
               }

            } // ende von else

            // einfügen der tabelle(n)
            bereich.add(t);

            // speichere die zum testen notwendigen werte:
            sum_prioritäten += t.getPrioritaet();
            sum_P_mal_Z += t.getPrioritaet() * t.getZusammenfassung();


         }// ende von: for(int i = zuf_gen.nextInt(5); i > 0; i -- )

         // prüfe, ob die generierte zusammenfassung der erwarteten
         // entspricht.
         double durchschnitt;
         if(sum_prioritäten == 0.0)
         {
            durchschnitt = 0.0;
         }
         else
         {
            durchschnitt = sum_P_mal_Z / sum_prioritäten;
         }

         error += "soll: " + durchschnitt
                  + ",\tist: "
                  + bereich.getZusammenfassung();

         assertEquals(error,
                      durchschnitt,
                      bereich.getZusammenfassung(),
                      0.000001);
         assertTrue(error, bereich.getZusammenfassung() >= 1.0);
         assertTrue(error, bereich.getZusammenfassung() <= 5.0);
      }
      Bericht.sag("    " + durchgänge
                  + " zufällige kombinationen wurden getestet");

      // ende schleife

   }
}
