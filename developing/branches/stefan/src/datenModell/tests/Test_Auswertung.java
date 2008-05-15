/**
 * 
 */
package datenModell.tests;



import java.util.ArrayDeque;
import java.util.Enumeration;
import java.util.Queue;
import datenModell.Auswertung;
import datenModell.Bereich;
import junit.framework.TestCase;



/**
 * @author andre
 */
public class Test_Auswertung extends TestCase
{

  private Auswertung a = Auswertung.getInstanz();


  /*
   * (non-Javadoc)
   * 
   * @see junit.framework.TestCase#setUp()
   */
  protected void setUp() throws Exception
  {
    super.setUp();
  }


  /*
   * (non-Javadoc)
   * 
   * @see junit.framework.TestCase#tearDown()
   */
  protected void tearDown() throws Exception
  {
    super.tearDown();
  }


  /**
   * Test method for {@link datenModell.Auswertung#getInstanz()}.
   */
  public void testGetInstanz()
  {
    Bericht.klasse(Auswertung.class.getName());
    Bericht.methode("teste den konstruktor der klasse", this);
    Bericht.sag("die instanz darf nach dem erstellen nicht null sein");
    assertNotNull(Auswertung.getInstanz());

    String titel = Auswertung.getTitel();

    Bericht.sag("teste das betiteln");
    assertEquals(Auswertung.getTitel().equals("Top"), true);
    Auswertung.setTitel("andererTitel");
    assertTrue(Auswertung.getTitel().equals("andererTitel"));
    Auswertung.setTitel(titel);
  }


  /**
   * Test method for
   * {@link datenModell.Auswertung#addBereich(datenModell.Bereich)}.
   */
  @SuppressWarnings("unchecked")
  public void testAddBereich()
  {
    Bericht.methode("teste das hinzufügen von neuen bereichen", this);
    Queue<Bereich> queue = new ArrayDeque<Bereich>(6);

    Bericht.sag("versuche 6 neue bereiche anzulegen");
    for(int i = 0; i < 6; i ++ )
    {
      Bereich b = new Bereich("bereich_" + i);
      Auswertung.addBereich(b);
      assertTrue(a.getChildCount() == (i + 1));
      queue.offer(b);
    }

    Bericht.sag("überprüfe die neuen bereiche, ob sie korrekt eingefügt wurden");
    Enumeration<Bereich> children = a.children();
    while(children.hasMoreElements())
    {
      Bereich child = (Bereich)children.nextElement();
      assertEquals(child, queue.poll());
    }

    Bericht.sag("versuche 3 weitere bereiche einzufügen, was nicht erfolgen darf");
    for(int i = 0; i < 3; i ++ )
    {
      int childcount = a.getChildCount();
      Auswertung.addBereich(new Bereich("ungültig_" + i));
      assertTrue(a.getChildCount() == childcount);
    }
  }


  /**
   * Test method for
   * {@link datenModell.Auswertung#removeBereich(datenModell.Bereich)}.
   */
  public void testRemoveBereich()
  {
    Bericht.methode("teste das entfernen von bereichen", this);
    assertTrue(a.getChildCount() != 0);

    Bericht.sag("lösche alle bereiche aus dem datenmodell");
    do
    {
      int childcount = a.getChildCount();
      Auswertung.removeBereich((Bereich)a.getFirstChild());
      assertTrue(a.getChildCount() != childcount);
    }
    while(a.getChildCount() != 0);

    Bericht.sag("das datenmodell darf jetzt keine berichte mehr enthalten");
    assertTrue(a.getChildCount() == 0);
  }
}
