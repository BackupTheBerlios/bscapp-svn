package datenModell;



import gui.helfer.DiagrammFactory.TYP;
import java.awt.geom.Point2D;
import java.io.Serializable;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;



/**
 * Ein bereich ist die 2. ebene in der baumstruktur.
 * 
 * @author andre
 */
public class Bereich extends DefaultMutableTreeNode implements
                                                   Serializable,
                                                   Comparable<Bereich>,
                                                   Bewertbar
{
   private static final long serialVersionUID = 1237738469520669948L;

   private Point2D.Double koordinate;
   private double prioritaet;


   public Bereich(String titel)
   {
      super(titel);
      koordinate = new Point2D.Double();
      add(new Tabelle("neu"));
   }


   /**
    * Gibt den titel des bereichs zurück
    * 
    * @return den titel des bereichs
    */
   public String getTitel()
   {
      return (String)super.getUserObject();
   }


   /**
    * Setzt den titel des bereichs
    * 
    * @param titel
    */
   public void setTitel(String titel)
   {
      super.setUserObject(titel);
   }


   /**
    * Gibt die position des bereichs in der portfoliodarstellung
    * zurück.
    * 
    * @return die koordinate in form eines Point2D.Double - objekts
    */
   public Point2D.Double getKoordinate()
   {
      return koordinate;
   }


   /**
    * setzt die koordinate des bereichs ( die position auf der
    * portfoliodarstellung ) zurück.
    * 
    * @param koordinate
    *           die position des bereichs; die X- und Y-Koordinaten
    *           müssen beide zwischen -100 und +100 liegen.
    */
   public void setKoordinate(Point2D.Double koordinate)
   {
      boolean xOK = false;
      boolean yOK = false;

      if(koordinate != null)
      {
         xOK = koordinate.x <= 100 && koordinate.x >= - 100;
         yOK = koordinate.y <= 100 && koordinate.y >= - 100;
      }

      if(xOK && yOK)
      {
         this.koordinate = koordinate;
      }
   }


   /**
    * gibt die größe zurück, mit der dieser bereich im portfolio
    * dargestellt wird.
    * 
    * @return die größe
    */
   public int getGroessePortfolio()
   {
      return 10;
   }


   @Override
   public void add(MutableTreeNode tabelle)
   {
      if(tabelle instanceof Tabelle)
      {
         super.add(tabelle);
      }
   }


   @Override
   public void remove(MutableTreeNode tabelle)
   {
      super.remove(tabelle);
   }


   @Override
   public int compareTo(Bereich b)
   {
      return getTitel().compareTo(b.getTitel());
   }


   /*
    * (non-Javadoc)
    * 
    * @see datenModell.Bewertbar#getJDiagramm(gui.helfer.DiagrammFactory.TYP)
    */
   @Override
   public JPanel getJDiagramm(TYP typ)
   {
      // TODO Auto-generated method stub
      return null;
   }


   /*
    * (non-Javadoc)
    * 
    * @see datenModell.Bewertbar#getPrioritaet()
    */
   @Override
   public double getPrioritaet()
   {
      return prioritaet;
   }


   /*
    * (non-Javadoc)
    * 
    * @see datenModell.Bewertbar#getZusammenfassung()
    */
   @Override
   public double getZusammenfassung()
   {
      double summePmalZ = 0;
      double summeP = 0;

      // für jedes einzelne meiner kinder:
      // multipliziere priorität (P) mit der zusammenfassung (Z);
      // zum schluss nimm die summe aller P*Z
      // und dividiere sie durch die summe aller prioritäten:
      for(Object o : children)
      {
         Tabelle t = (Tabelle)o;
         summePmalZ += t.getPrioritaet() * t.getZusammenfassung();
         summeP += t.getPrioritaet();
      }

      return summePmalZ / summeP;
   }


   /*
    * (non-Javadoc)
    * 
    * @see datenModell.Bewertbar#setPrioritaet(double)
    */
   @Override
   public void setPrioritaet(double prioritaet)
   {
      if(prioritaet >= 0 && prioritaet <= 10)
      {
         this.prioritaet = prioritaet;
      }
   }


   /*
    * (non-Javadoc)
    * 
    * @see datenModell.Bewertbar#setZusammenfassung(double)
    */
   @Override
   public void setZusammenfassung(double zusammenfassung)
   {
   // ein bereich ermittelt autom. eine zusammenf. ihrer children!
   // nur tabelleblatt-instanzen eine zusammenf. direkt zuordnen!
   // es kann nur die priorität gesetzt werden!
   }
}
