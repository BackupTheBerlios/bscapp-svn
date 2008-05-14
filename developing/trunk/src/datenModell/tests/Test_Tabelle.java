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
   List<TabelleBlatt> bl�tter;


   /*
    * (non-Javadoc)
    * 
    * @see junit.framework.TestCase#setUp()
    */
   @Override
   protected void setUp() throws Exception
   {
      tabelle = new Tabelle("testtabelle");

      // erstelle einige bl�tter in einer liste zu testzwecken:
      bl�tter = new ArrayList<TabelleBlatt>();
      bl�tter.add((TabelleBlatt)tabelle.getFirstChild());
      for(int i = 0; i < 10; i ++ )
      {
         TabelleBlatt b = new TabelleBlatt("testblatt " + i);
         b.setZusammenfassung(1);
         b.setPrioritaet(0);
         bl�tter.add(b);
         assertTrue(bl�tter.get(i).getZusammenfassung() == 1);
         assertTrue(bl�tter.get(i).getPrioritaet() == 0);
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

      Bericht.sag("pr�fe initiale werte der neuen instanz");
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

      Bericht.sag("�ndere initialess Blatt dieser Tabelle, pr�fe ermittlung der z-werte");
      Bericht.sag("   alle Kombinationen: p= 1-10 und z= 1-5 jeweils in 0.5-schritten");
      for(double p = 1; p <= 10; p += 0.5) // priorit�ten 1-10
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
      Bericht.methode("teste die berechnung der z mit 6 bl�ttern",
                      this);

      // baue ausgangssituation zusammen: (1 child ist schon
      // vorhanden, deswegen 5 mal)
      for(int i = 0; i < 5; i ++ )
      {
         TabelleBlatt b = bl�tter.get(i);
         tabelle.add(b);
      }

      // pr�fe, ob alles gut gegangen ist:
      Enumeration<TabelleBlatt> children = tabelle.children();
      assertTrue(children.hasMoreElements());
      while(children.hasMoreElements())
      {
         assertTrue(bl�tter.contains(children.nextElement()));
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
      Bericht.sag("ordne allen bl�ttern denselben wert zu, pr�fe durchschnitt.");
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

      Bericht.sag("teste algorithmus mit 2 bl�ttern, verschiedene z, gleiche p");
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
      Bericht.sag("    " + anzahl + " zuf�llige kombinationen wurden getestet.");
   }


   @SuppressWarnings("unchecked")
   public void testeZusammenfassung_ZusammenfZuf�llig()
   {
      Random random;
      int anzahl;

      Bericht.sag("teste zuf�llig viele, bewertete bl�tter derselben priorit�t.");
      anzahl = 0;

      random = new Random(1L);
      for(int i = 0; i < 100000; i ++ )
      {
         tabelle = new Tabelle("yyy");

         // int zwischen 1 und 5, anzahl
         // der einzuf�genden bl�tter (1 ist schon drin)
         int einzuf�gen = random.nextInt(5) + 1;// f�ge x bl�tter ein
         double summeAllerNoten = 0;
         double anzahlNoten = 0;

         for(int j = 1; j < einzuf�gen; j ++ )
         {
            TabelleBlatt b = new TabelleBlatt("blatt" + j);
            tabelle.add(b);
         }
         assertEquals(einzuf�gen, tabelle.getChildCount());

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
      Bericht.sag("    " + anzahl + " zuf�llige kombinationen wurden getestet");
   }


   @SuppressWarnings("unchecked")
   public void testeZufaellig_Anz_Prio_Zus()
   {
      Bericht.sag("teste zuf�llig viele, zusammengefasste und gewichtete bl�tter");

      int anzahl = 0;

      // mach 1 million mal:
      for(int i = 0; i < 100000; i ++ )
      {
         anzahl ++ ;
         zufaelligeTabelleMitNurBlaettern();
      }

      Bericht.sag("    " + anzahl + " zuf�llige kombinationen wurden getestet");
   }


   @SuppressWarnings("unchecked")
   private Tabelle zufaelligeTabelleMitNurBlaettern()
   {
      Random zuf_gen = new Random();

      double sum_priorit�ten; // die summe der priorit�ten
      double sum_P_mal_Z; // die summe der gewichteten zusammenfas.

      int zuf_anzahl; // die zuf�llige anzahl der bl�tter
      double zuf_priorit�t; // die zuf�llig erzeugte priorit�t
      double zuf_zusammenf; // die zuf�llig erzeugte zusamenfassung

      // initialisiere die ausgangswerte:
      Tabelle tab = new Tabelle("zufall");
      sum_priorit�ten = 0;
      sum_P_mal_Z = 0;

      // 0-5 (inkl.) bl�tter werden eingef�gt:
      zuf_anzahl = zuf_gen.nextInt(6);

      // erzeuge die bl�tter:
      for(int j = 0; j < zuf_anzahl; j ++ )
      {
         TabelleBlatt b = new TabelleBlatt("test");
         tab.add(b);
      }

      // ist die anzahl korrekt?
      assertEquals(zuf_anzahl + 1, tab.getChildCount());

      // hole mir alle bl�tter dieser tabelle:
      Enumeration<TabelleBlatt> bl�tter = tab.children();

      // bef�lle diese bl�tter mit zufallswerten:
      while(bl�tter.hasMoreElements())
      {
         zuf_priorit�t = zuf_gen.nextDouble(); // double: 0-1
         zuf_priorit�t *= 10; // priorit�t ist zwischen 0 und 10

         zuf_zusammenf = zuf_gen.nextDouble();// double: 0-1
         zuf_zusammenf *= 4; // 0-4
         zuf_zusammenf += 1; // zusammenfist zwischen 1 und 5

         // speichere die zur kontrolle n�tigen werte zwischen:
         double p_Mal_Z = zuf_priorit�t * zuf_zusammenf;
         sum_P_mal_Z += p_Mal_Z;
         sum_priorit�ten += zuf_priorit�t;

         // speichere die werte im blatt:
         TabelleBlatt b = bl�tter.nextElement();
         b.setPrioritaet(zuf_priorit�t);
         b.setZusammenfassung(zuf_zusammenf);

         // garantiere, dass das blatt korrekt bewertet ist:
         assertTrue(b.getZusammenfassung() == zuf_zusammenf);
         assertTrue(b.getPrioritaet() == zuf_priorit�t);

      } // ende von: while(bl�tter.hasMoreElements())

      // vergleiche zusammenf der tabelle mit dem:
      double erwarteteZusammenf = sum_P_mal_Z / sum_priorit�ten;
      assertEquals(erwarteteZusammenf, tab.getZusammenfassung(), 0.000001);

      zuf_priorit�t = zuf_gen.nextDouble(); // double: 0-1
      zuf_priorit�t *= 10; // priorit�t ist zwischen 0 und 10
      tab.setPrioritaet(zuf_priorit�t);

      return tab;
   }


   @SuppressWarnings("unchecked")
   public void testeMitZufallsHierarchie()
   {
      Bericht.sag("teste hierarchie mit zuf�lligen werten und gewichtungen und struktur");

      Random zuf_gen = new Random(1l);

      double sum_priorit�ten; // die summe der priorit�ten
      double sum_P_mal_Z; // die summe der gewichteten zusammenfas.

      double zuf_priorit�t; // die zuf�llig erzeugte priorit�t
      double zuf_zusammenf; // die zuf�llig erzeugte zusamenfassung

      int durchg�nge = 0;
      for(int n = 0; n < 100000; n ++ )
      {
         durchg�nge ++ ;

         Bereich bereich = new Bereich("berecih");
         sum_priorit�ten = 0;
         sum_P_mal_Z = 0;

         String error = "";


         // f�ge zuf�llig viele tabellen in den bereich ein:
         int anzahlkinder = zuf_gen.nextInt(5) + 1;
         error += "f�ge: " + anzahlkinder + " kinder ein:";

         for(int i = anzahlkinder; i > 0; i -- )
         {

            Tabelle t;


            // 25 % ein blatt wird eingef�gt:
            if(zuf_gen.nextBoolean() && zuf_gen.nextBoolean())
            {
               error += " blatt, ";

               zuf_priorit�t = zuf_gen.nextDouble(); // double: 0-1
               zuf_priorit�t *= 10; // priorit�t ist zwischen 0 und 10
               zuf_zusammenf = zuf_gen.nextDouble();// double: 0-1
               zuf_zusammenf *= 4; // 0-4
               zuf_zusammenf += 1; // zusammenf ist zwischen 1 und 5

               t = new TabelleBlatt("blatt ebene 1");
               t.setZusammenfassung(zuf_zusammenf);
               t.setPrioritaet(zuf_priorit�t);
            }


            else
            {


               // 37.5 % eine tabelle mit nur bl�ttern wird eingef�gt:
               if(zuf_gen.nextBoolean())
               {
                  error += " tab_nur_bl�tter,";

                  t = zufaelligeTabelleMitNurBlaettern();

                  Enumeration kinder = t.children();
                  while(kinder.hasMoreElements())
                  {
                     zuf_priorit�t = zuf_gen.nextDouble(); // double:
                     // 0-1
                     zuf_priorit�t *= 10; // priorit�t zwischen 0 und
                     // 10
                     zuf_zusammenf = zuf_gen.nextDouble();// double:
                     // 0-1
                     zuf_zusammenf *= 4; // 0-4
                     zuf_zusammenf += 1; // zusammenf zwischen 1 und
                     // 5

                     TabelleBlatt kind = (TabelleBlatt)kinder.nextElement();
                     kind.setPrioritaet(zuf_priorit�t);
                     kind.setZusammenfassung(zuf_zusammenf);
                  }


               } // ende von: if(zuf_gen.nextBoolean())


               // 37.5 % eine tabelle mit lauter tabellen wird
               // eingef�gt:
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
                     zuf_priorit�t = zuf_gen.nextDouble(); // double:
                     // 0-1
                     zuf_priorit�t *= 10; // priorit�t zwischen 0 und
                     // 10
                     Tabelle kind = (Tabelle)enumer.nextElement();
                     kind.setPrioritaet(zuf_priorit�t);
                  }



                  zuf_priorit�t = zuf_gen.nextDouble(); // 0-1
                  zuf_priorit�t *= 10; // priorit�t zwischen 0-10
                  t.setPrioritaet(zuf_priorit�t);
                  error += "(p=" + t.getPrioritaet()
                           + ", z="
                           + t.getZusammenfassung()
                           + "); ";
               }

            } // ende von else

            // einf�gen der tabelle(n)
            bereich.add(t);

            // speichere die zum testen notwendigen werte:
            sum_priorit�ten += t.getPrioritaet();
            sum_P_mal_Z += t.getPrioritaet() * t.getZusammenfassung();


         }// ende von: for(int i = zuf_gen.nextInt(5); i > 0; i -- )

         // pr�fe, ob die generierte zusammenfassung der erwarteten
         // entspricht.
         double durchschnitt;
         if(sum_priorit�ten == 0.0)
         {
            durchschnitt = 0.0;
         }
         else
         {
            durchschnitt = sum_P_mal_Z / sum_priorit�ten;
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
      Bericht.sag("    " + durchg�nge
                  + " zuf�llige kombinationen wurden getestet");

      // ende schleife

   }
}
