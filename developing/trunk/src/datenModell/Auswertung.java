package datenModell;



import gui.helfer.DiagrammFactory.TYP;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;



/**
 * Diese als Singleton implementierte Klasse stellt die oberste Ebene
 * der Baumes dar. Wenn die gesamte Struktur des Baumes serialisiert
 * werden soll, muss lediglich dieses Objekt serialisiert werden. Um
 * das Element zu laden muss nur der Singleton mit dem
 * deserialisierten
 * 
 * @author andre
 */
public class Auswertung extends DefaultMutableTreeNode implements Serializable
{
  private static final long serialVersionUID = - 208812670706157608L;
  private static Auswertung INSTANZ;


  /**
   * gibt die einzige existierende Auswertung zurück. Falls diese noch
   * null sein sollte, wird erst eine instanz angelegt.
   * 
   * @return den Singleton von Auswertung
   */
  public static Auswertung getInstanz()
  {
    if(INSTANZ == null)
    {
      INSTANZ = new Auswertung();
    }
    return INSTANZ;
  }


  public static void setInstanz(Auswertung auswertung)
  {
    INSTANZ = auswertung;
  }


  private Auswertung()
  {
    super("Übersicht");
  }



  /**
   * Gibt den titel zurück
   * 
   * @return den titel des bereichs
   */
  public static String getTitel()
  {
    return (String)getInstanz().getUserObject();
  }


  /**
   * @param titel
   */
  public static void setTitel(String titel)
  {
    getInstanz().setUserObject(titel);
  }


  /**
   * fügt dem root-element einen neuen bereich hinzu. sofern es noch
   * nicht mehr als 5 bereiche enthält. (maximal 6 bereiche sind ok)
   * 
   * @param bereich
   *          der neue bereich
   */
  public static void addBereich(Bereich bereich)
  {
    Auswertung a = getInstanz(); // zum debuggen wirds
    // referenziert.

    if(a.getChildCount() < 6)
    {
      a.add(bereich);
      System.out.println(Auswertung.class.getSimpleName() + ": Bereich "
                         + bereich
                         + " wurde eingefügt.");
    }
  }


  /**
   * @param bereich
   */
  public static void removeBereich(Bereich bereich)
  {
    DefaultMutableTreeNode thisNode = getInstanz();
    thisNode.remove(bereich);
  }


  @SuppressWarnings("unchecked")
  public JPanel getJDiagramm()
  {
    return null;
  }


  @Override
  public void setUserObject(Object userObject)
  {
    // um sicherzugehen dass nur ein string als "titel" definiert
    // werden kann...
    if(userObject instanceof String)
    {
      super.setUserObject(userObject);
    }
  }


  public JPanel getJDiagramm(TYP typ)
  {
    // TODO Auto-generated method stub
    return null;
  }
}
