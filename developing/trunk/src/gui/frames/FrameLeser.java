/**
 * 
 */
package gui.frames;



import gui.helfer2.Befehl;
import gui.panels.BaumPanel;
import gui.panels.WertTabellePanel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import datenModell.Auswertung;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class FrameLeser extends SuperFrame
{
  public final BaumPanel baumpanel;
  public final WertTabellePanel wertepanel;
  protected DefaultMutableTreeNode selectednode;
  protected JMenuBar jmenubar;
  protected JMenu jmenudatei;
  protected JMenuItem dateiOeffnen, dateiInfo, dateiBeenden;
  protected File file;
  protected final JTabbedPane tabbedpane = new JTabbedPane();


  public FrameLeser()
  {
    super();
    baumpanel = new BaumPanel(this);
    west.add(baumpanel);
    initMenuLeser();
    setJMenuBar(jmenubar);
    wertepanel = new WertTabellePanel(this);
    center.add(tabbedpane);
    tabbedpane.add("Werte", wertepanel);
  }


  public void refreshHard()
  {
    Dimension dim = getSize();
    setPreferredSize(dim);
    Point pos = getLocation();
    pack();
    setLocation(pos);
  }


  /** @see gui.frames.SuperFrame#actionPerformed */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    Befehl b = Befehl.toBefehl(e.getActionCommand());

    if(b == null)
    {
      return;
    }

    switch(b)
    {
      case FILE_LOAD :
        FILE_LOAD();
        return;
      case FILE_EXIT :
        FILE_EXIT();
        return;
      case FILE_ABOUT :
        FILE_ABOUT();
        return;
    }
  }


  private final void FILE_LOAD()
  {
    JFileChooser jfc = new JFileChooser();
    jfc.setFileFilter(new FileNameExtensionFilter("BSC-Dateien", "bsc"));
    jfc.showOpenDialog(this);
    File filenew = jfc.getSelectedFile();

    if(filenew == null)
    {
      return;
    }

    Auswertung a = null;

    File fileold = file;
    file = filenew;

    try
    {
      ObjectInputStream ois;
      ois = new ObjectInputStream(new FileInputStream(file));
      a = (Auswertung)ois.readObject();
      ois.close();
      Auswertung.setInstanz(a);
      baumpanel.aktualisiereBaum();
    }
    catch(Exception exc)
    {
      SuperFrame.zeigeException("Fehler beim Laden der datei:\n" + filenew, exc);
      file = fileold;
      baumpanel.aktualisiereBaum();
    }
  }


  private void FILE_EXIT()
  {
    getWindowListeners()[0].windowClosing(null);
  }


  private void FILE_ABOUT()
  {
    String s = "BSC-Applikation\n\tVersion: 1.0" + "\n"
               + "\tDatum: 2008/05/23\n\n"
               + "Projektentwicklung 4akdvk\n"
               + "Kolleg für EDV Schwerpunkt:\n"
               + "Kommerzielle EDV-Technik\n"
               + "HTL Spengergasse 1050 Wien\n"
               + "Schuljahr: 2007/2008\n"
               + "\n"
               + "Projektteam:\n"
               + "- Hölzl Stefan\n"
               + "- Pinter Jürgen\n"
               + "- Polak Nicole\n"
               + "- Ragg Andre\n"
               + "\n"
               + "Betreuungslehrer:\n"
               + "- DI Marihart\n"
               + "- Mag. Pater";
    SuperFrame.zeigeInfo(s, "Programminfo");
  }


  private final void initMenuLeser()
  {
    final ActionListener listener = this;

    jmenubar = new JMenuBar();

    dateiOeffnen = new JMenuItem("Datei öffnen...")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.FILE_LOAD.toString());
      }
    };

    dateiInfo = new JMenuItem("Info")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.FILE_ABOUT.toString());
      }
    };

    dateiBeenden = new JMenuItem("Beenden")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.FILE_EXIT.toString());
      }
    };

    jmenudatei = new JMenu("Datei")
    {
      {
        add(dateiOeffnen);
        add(dateiInfo);
        add(dateiBeenden);
      }
    };

    jmenubar.add(jmenudatei);
    super.setJMenuBar(jmenubar);
  }
}
