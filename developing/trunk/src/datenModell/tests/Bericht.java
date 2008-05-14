/**
 * 
 */
package datenModell.tests;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;



/**
 * @author andre
 */
public class Bericht
{
  private static StringBuffer buffer = new StringBuffer();
  private static PrintWriter printw = null;
  private static int zeilennummer = 0;
  private static boolean istinitial = true;
  private static Date startzeit;


  public static void start()
  {
    startzeit = new Date();
    istinitial = true;
    buffer = new StringBuffer();
    zeilennummer = 0;
    out(formatiere("STARTE TESTLAUF..."));
    out("");
  }


  public static void klasse(String msg)
  {
    if(istinitial)
    {
      istinitial = false;
    }
    else
    {
      out(formatiere("|___ Ende der TestKlasse."));
      out("");
    }
    
    out(formatiere("Start der TestKlasse; Klasse zu testen: " + msg));
    out("                    |");
  }


  public static void methode(String msg, Object sender)
  {
    out(formatiere("|___" + msg.toUpperCase()
                   + " @ "
                   + sender.getClass().getSimpleName()));
  }


  public static void sag(String msg)
  {
    out(formatiere("|     " + msg));
  }


  public static void sag()
  {
    String nr = nummer();

    System.out.println(nr);
    buffer.append("\n" + nr);

    if(printw != null)
    {
      printw.println(nr);
      printw.flush();
    }
  }


  public static String ende()
  {
    out(formatiere("|___ Ende der TestKlasse."));
    out("");
    long start = startzeit.getTime();
    long jetzt = new Date().getTime();
    double dauer = jetzt - start;
    double sekunden = dauer / 1000.0;
    out(formatiere("TESTLAUF BEENDET. Dauer: " + sekunden + " sekunden"));

    String bericht = buffer.toString();

    buffer = new StringBuffer();
    zeilennummer = 0;
    if(printw != null)
    {
      printw.flush();
      printw.close();
      printw = null;
    }
    return bericht;
  }


  public static void setLogdatei()
  {
    JFileChooser jfc = new JFileChooser();
    jfc.showDialog(null, "logfile auswählen");
    File logfile = jfc.getSelectedFile();

    if(logfile != null)
      try
      {
        printw = new PrintWriter(logfile);
      }
      catch(FileNotFoundException exc)
      {
        exc.printStackTrace();
      }
  }


  private static void out(String zeile)
  {
    String nr = nummer();
    System.out.println(nr + zeile);
    buffer.append("\n" + nr + zeile);

    if(printw != null)
    {
      printw.println(nr + zeile);
    }
  }


  private static String nummer()
  {
    zeilennummer ++ ;

    if(zeilennummer < 100)
    {
      if(zeilennummer < 10)
      {
        return "  " + zeilennummer + "  ";
      }
      return " " + zeilennummer + "  ";
    }
    return "" + zeilennummer + "  ";
  }


  private static String formatiere(String s)
  {
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    return(format.format(date) + " " + s);
  }


  public static String getBerichtAlsString()
  {
    return buffer.toString();
  }
}
