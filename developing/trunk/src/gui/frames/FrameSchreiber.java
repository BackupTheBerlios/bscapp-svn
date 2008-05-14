/**
 * 
 */
package gui.frames;



import gui.helfer2.Befehl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import datenModell.Auswertung;
import datenModell.Bereich;
import datenModell.Bewertbar;
import datenModell.Tabelle;
import datenModell.TabelleBlatt;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class FrameSchreiber extends FrameLeser
{
  protected JMenu jmenuelement;
  protected JMenuItem elementAdd, elementRemove, elementSetDiagramm,
      elementSetParent, elementSetPioritaet, elementSetTitel,
      elementSetZusammenf;
  protected JMenuItem dateiSpeichern, dateiSpeichernUnter, dateiNeu;


  public FrameSchreiber()
  {
    super();
    initJMenuSchreiber();
  }


  /** @see gui.frames.FrameLeser#actionPerformed */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    Befehl b = Befehl.toBefehl(e.getActionCommand());

    if(b == null)
    {
      return;
    }

    super.actionPerformed(e);

    switch(b)
    {
      case ELEMENT_ADD :
        ELEMENT_ADD();
        return;
      case ELEMENT_REMOVE :
        ELEMENT_REMOVE();
        return;
      case ELEMENT_SET_DIAGRAMM :
        ELEMENT_SET_DIAGRAMM();
        return;
      case ELEMENT_SET_PARENT :
        ELEMENT_SET_PARENT();
        return;
      case ELEMENT_SET_PRIORITAET :
        ELEMENT_SET_PRIORITAET();
        return;
      case ELEMENT_SET_TITEL :
        ELEMENT_SET_TITEL();
        return;
      case ELEMENT_SET_ZUSAMMENFASSUNG :
        ELEMENT_SET_ZUSAMMENFASSUNG();
        return;
      case FILE_SAVE :
        speichere();
        return;
      case FILE_NEW :
        neueDateiAnlegen();
        return;
      case FILE_SAVE_AS :
        speichernUnter();
        return;
    }
  }


  private void ELEMENT_SET_ZUSAMMENFASSUNG()
  {
    String msgtitel = "Zusammenfassung zuweisen";
    DefaultMutableTreeNode node = baumpanel.getSelection();

    if(node == null)
    {
      String msg = "Kein Element ausgewählt.\nBitte wählen Sie ein Element aus!";
      zeigeInfo(msg, msgtitel);
      return;
    }

    if( ! (node instanceof TabelleBlatt))
    {
      String msg = "Sie können diesem Element keine Bewertung zusweisen.\n(TabelleBlättern vorbehalten)";
      zeigeInfo(msg, msgtitel);
      return;
    }

    final JSpinner spinner = new JSpinner(new SpinnerNumberModel(((Bewertbar)node).getZusammenfassung(),
                                                                 1.0,
                                                                 5.0,
                                                                 0.1));
    JPanel frage = new JPanel(new GridLayout(0, 1))
    {
      {
        add(new JLabel("Bitte den neuen Wert hier auswählen:"));
        add(new JPanel(new GridLayout(1, 0))
        {
          {
            add(new JLabel("Zahl zwischen 1 und 5:"));
            add(spinner);
            setBorder(new EmptyBorder(9, 9, 9, 9));
          }
        });
        add(new JLabel("Klicken Sie auf ja um den Wert zuzuweisen:"));
      }
    };

    if( ! frageTrueFalse(frage, msgtitel))
    {
      return;
    }

    ((Bewertbar)node).setZusammenfassung((Double)spinner.getValue());
  }


  private void ELEMENT_SET_TITEL()
  {
    String msgtitel = "Titel Ändern";
    final DefaultMutableTreeNode node = baumpanel.getSelection();

    if(node == null)
    {
      String msg = "Kein Element ausgewählt.\nBitte wählen Sie ein Element aus!";
      zeigeInfo(msg, msgtitel);
      return;
    }

    msgtitel += ": " + node.getClass().getSimpleName()
                + " "
                + node.getUserObject().toString();

    final JTextField name = new JTextField(15)
    {
      {
        setText(node.getUserObject().toString());
        setBorder(new EmptyBorder(9, 9, 9, 9));
      }
    };

    JPanel frage = new JPanel(new BorderLayout())
    {
      {
        add(new JLabel("Bitte geben Sie den neuen Namen an:"),
            BorderLayout.NORTH);
        add(name, BorderLayout.CENTER);
        add(new JLabel("Klicken Sie auf ja, um den Titel zu ändern:"),
            BorderLayout.SOUTH);
      }
    };

    if(frageTrueFalse(frage, msgtitel))
    {
      node.setUserObject(name.getText());
      baumpanel.aktualisiereBaum();
    }
  }


  private void ELEMENT_SET_PRIORITAET()
  {
    DefaultMutableTreeNode node = baumpanel.getSelection();

    // prüfe ob die operation erlaubt ist:

    String msgtitel = "Priorität zuweisen";

    if(node == null)
    {
      String msg = "Kein Element ausgewählt.\nBitte wählen Sie ein Element aus!";
      zeigeInfo(msg, msgtitel);
      return;
    }

    if(node instanceof Auswertung)
    {
      String msg = "Dem obersten Element kann keine Priorität zugewiesen werden.\n";
      zeigeInfo(msg, msgtitel);
      return;
    }

    final JSpinner spinner = new JSpinner(new SpinnerNumberModel(((Bewertbar)node).getZusammenfassung(),
                                                                 0.0,
                                                                 10.0,
                                                                 0.25));
    JPanel frage = new JPanel(new GridLayout(0, 1))
    {
      {
        add(new JLabel("Bitte den neuen Wert hier eingeben:"));

        add(new JPanel(new GridLayout(1, 0))
        {
          {
            add(new JLabel("Zahl zwischen 0 und 10:"));
            add(spinner);
            setBorder(new EmptyBorder(9, 9, 9, 9));
          }
        });

        add(new JLabel("Klicken Sie auf ja den Wert zuzuweisen:"));
      }
    };

    if( ! frageTrueFalse(frage, "Neues Blatt"))
    {
      return;
    }

    ((Bewertbar)node).setZusammenfassung((Double)spinner.getValue());
  }


  private void ELEMENT_SET_PARENT()
  {
    DefaultMutableTreeNode zuverschieben = baumpanel.getSelection();

    // prüfe ob die operation erlaubt ist:

    String msgtitel = "Element verschieben";

    if(zuverschieben == null)
    {
      String msg = "Kein Element ausgewählt.\nBitte wählen Sie ein Element aus!";
      zeigeInfo(msg, msgtitel);
      return;
    }

    if(zuverschieben instanceof Auswertung)
    {
      String msg = "Sie können das oberste Element nicht verschieben!";
      zeigeInfo(msg, msgtitel);
      return;
    }

    if(zuverschieben instanceof Bereich)
    {
      String msg = "Elemente des Typs Bereich kommen nur in der 1. Ebene vor.\nSie können nicht verschoben werden.";
      zeigeInfo(msg, msgtitel);
      return;
    }

    if(zuverschieben.getParent().getChildCount() <= 1)
    {
      String msg = "Element kann nicht verschoben werden." + "\n"
                   + "Der Eltern-Knoten wäre leer wenn dieser\nKnoten verschoben würde.\n"
                   + "Bitte fügen Sie vorher einen neuen Knoten in den Eltern-Knoten ein.";
      zeigeInfo(msg, msgtitel);
      return;
    }


    final JTree tree = new JTree(new DefaultTreeModel(Auswertung.getInstanz()));

    JPanel frage = new JPanel(new BorderLayout())
    {
      {
        add(new JLabel("Bitte wählen Sie den neuen Eltern-Knoten:"),
            BorderLayout.NORTH);
        add(new JScrollPane(tree)
        {
          {
            setBorder(new EmptyBorder(9, 9, 9, 9));
            setPreferredSize(new Dimension(100, 200));
          }
        }, BorderLayout.CENTER);
        add(new JLabel("Klicken Sie auf ja, um das Element zu verschieben:"),
            BorderLayout.SOUTH);
      }
    };

    boolean zielOK = false;
    DefaultMutableTreeNode ziel;

    // ########################################################
    do
    {

      // ++++++++++++++++++++++++++++++++++++++++++++++++++++++
      do
      {
        if(frageTrueFalse(frage, msgtitel))
        {
          ziel = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        }
        else
        {
          return;
        }
      }
      while(ziel == null);
      // ++++++++++++++++++++++++++++++++++++++++++++++++++++++

      // prüfe ob die operation erlaubt ist:

      if(ziel instanceof Auswertung)
      {
        String msg = "Das oberste Element darf nur Kindknoten vom Typ Bereich enthalten!";
        zeigeInfo(msg, msgtitel);
        continue;
      }

      if(ziel.getChildCount() >= 6)
      {
        String msg = "Der Elternknoten hat bereits die\nmaximale Anzahl an Kindknoten!";
        zeigeInfo(msg, msgtitel);
        continue;
      }

      zielOK = true;
    }
    while( ! zielOK);
    // ########################################################

    zuverschieben.setParent(ziel);
    baumpanel.aktualisiereBaum();
  }


  private void ELEMENT_SET_DIAGRAMM()
  {}


  private void ELEMENT_REMOVE()
  {
    DefaultMutableTreeNode node = baumpanel.getSelection();

    // prüfe ob die operation erlaubt ist:

    String msgtitel = "Element entfernen";

    if(node == null)
    {
      String msg = "Kein Element ausgewählt.\nBitte wählen Sie ein Element aus!";
      zeigeInfo(msg, msgtitel);
      return;
    }

    if(node instanceof Auswertung)
    {
      String msg = "Oberstes Element kann nicht entfernt werden.";
      zeigeInfo(msg, msgtitel);
      return;
    }

    if(node instanceof Bereich)
    {
      elementRemove(node);
    }

    else if(node.getParent().getChildCount() <= 1)
    {
      String msg = "Element kann nicht entfernt werden." + "\n"
                   + "Der Eltern-Knoten wäre leer wenn dieser\nKnoten entfernt würde.\n"
                   + "Bitte fügen Sie vorher einen neuen Knoten in den Eltern-Knoten ein.";
      zeigeInfo(msg, msgtitel);
      return;
    }
    else
    {
      elementRemove(node);
    }

  }


  private void elementRemove(DefaultMutableTreeNode node)
  {
    if(frageTrueFalse("Wollen Sie " + node.getClass().getSimpleName()
                      + " "
                      + node.getUserObject().toString()
                      + " wirklich entfernen?", "Element entfernen"))
    {
      node.removeFromParent();
      baumpanel.aktualisiereBaum();
    }
  }


  private void ELEMENT_ADD()
  {
    DefaultMutableTreeNode node = baumpanel.getSelection();

    // prüfe ob die operation erlaubt ist:

    String msgtitel = "Neues Element einfügen";

    if(node == null)
    {
      String msg = "Kein Element ausgewählt.\nBitte wählen Sie ein Element aus!";
      zeigeInfo(msg, msgtitel);
      return;
    }

    if(node instanceof TabelleBlatt)
    {
      String msg = "Element kann keine Unterelemente besitzen.\nSie müssen das Element erst in\n ein Tabellenelement konvertieren";
      zeigeInfo(msg, msgtitel);
      return;
    }

    if(node.getChildCount() > 5)
    {
      String message = "Keine weiteren Unterelemente erlaubt.\nSie müssen mindestens 1 Unterelement entfernen.";
      zeigeInfo(message, msgtitel);
      return;
    }

    // führe jeweilige operation durch:

    if(node instanceof Auswertung)
    {
      addBereich(node);
    }

    if(node instanceof Bereich || node instanceof Tabelle)
    {
      addTabOderBlatt(node);
    }

    baumpanel.aktualisiereBaum();
  }


  private void addBereich(DefaultMutableTreeNode node)
  {
    final JTextField name = new JTextField(15)
    {
      {
        setText("neuer Bereich");
        setBorder(new EmptyBorder(9, 9, 9, 9));
      }
    };

    JPanel frage = new JPanel(new GridLayout(0, 1))
    {
      {
        add(new JLabel("Bitte den Namen des Bereiches\n hier eingeben:"));
        add(name);
        add(new JLabel("\nKlicken Sie auf ja um den Bereich einzufügen!"));
      }
    };

    if( ! frageTrueFalse(frage, "Neuer Bereich"))
    {
      return;
    }

    Bereich b = new Bereich(name.getText());
    node.add(b);
    baumpanel.setSelection(b);
  }


  private void addTabOderBlatt(DefaultMutableTreeNode node)
  {
    String msgtitel = "Neues Element einfügen";

    boolean macheinblatt = false;
    boolean ausgewaehlt = false;

    final JRadioButton buttTabelle = new JRadioButton("Tabelle");
    final JRadioButton buttTabelleBlatt = new JRadioButton("TabelleBlatt");

    new ButtonGroup()
    {
      {
        add(buttTabelle);
        add(buttTabelleBlatt);
      }
    };

    JPanel frage = new JPanel(new GridLayout(0, 1))
    {
      {
        add(new JLabel("Bitte den Typ des UnterElements angeben:"));
        add(buttTabelle);
        add(buttTabelleBlatt);
        add(new JLabel("Klicken Sie auf ja um fortzufahren:"));
      }
    };

    do
    {
      if( ! frageTrueFalse(frage, msgtitel))
      {
        return;
      }

      if(buttTabelle.isSelected())
      {
        ausgewaehlt = true;
        macheinblatt = false;
      }

      if(buttTabelleBlatt.isSelected())
      {
        ausgewaehlt = true;
        macheinblatt = true;
      }
    }
    while( ! ausgewaehlt);

    if(macheinblatt)
    {
      addBlatt(node);
    }
    else
    {
      addTabelle(node);
    }
  }


  private void addBlatt(DefaultMutableTreeNode node)
  {
    final JTextField name = new JTextField(15)
    {
      {
        setText("neues Blatt");
        setBorder(new EmptyBorder(9, 9, 9, 9));
      }
    };

    JPanel frage = new JPanel(new GridLayout(0, 1))
    {
      {
        add(new JLabel("Bitte den Namen des TabelleBlattes\n hier eingeben:"));
        add(name);
        add(new JLabel("Klicken Sie auf ja um das TabelleBlatt einzufügen:"));
      }
    };

    if( ! frageTrueFalse(frage, "Neues Blatt"))
    {
      return;
    }

    TabelleBlatt t = new TabelleBlatt(name.getText());
    node.add(t);
    baumpanel.setSelection(t);
  }


  private void addTabelle(DefaultMutableTreeNode node)
  {
    final JTextField name = new JTextField(15)
    {
      {
        setText("neue Tabelle");
        setBorder(new EmptyBorder(9, 9, 9, 9));
      }
    };

    JPanel frage = new JPanel(new GridLayout(0, 1))
    {
      {
        add(new JLabel("Bitte den Namen der Tabelle\n hier eingeben:"));
        add(name);
        add(new JLabel("Klicken Sie auf ja um die Tabelle einzufügen:"));
      }
    };

    if( ! frageTrueFalse(frage, "Neue Tabelle"))
    {
      return;
    }

    Tabelle t = new Tabelle(name.getText());
    node.add(t);
    baumpanel.setSelection(t);
  }


  private void neueDateiAnlegen()
  {
    if( ! frageTrueFalse("Wollen " + "Sie ein neues BSC-Projekt anlegen?\n"
                         + "(ungespeicherte Änderungen gehen verloren"
                         + ")", "Neues Projekt anlegen"))
    {
      return;
    }

    final JTextField projektname = new JTextField(15)
    {
      {
        setText("NeuesProjekt");
        setBorder(new EmptyBorder(9, 9, 9, 9));
      }
    };

    betitle(projektname, "Name des Projekts:");

    JPanel frage = new JPanel(new BorderLayout())
    {
      {
        add(new JLabel("Wollen Sie den Projektnamen ändern?"),
            BorderLayout.NORTH);
        add(projektname, BorderLayout.CENTER);
        setBackground(Color.white);
      }
    };

    if(frageTrueFalse(frage, "Neues Projekt anlegen"))
    {
      Auswertung.setInstanz(null);
      Auswertung.setTitel(projektname.getText());

      baumpanel.aktualisiereBaum();
    }
  }


  private final void initJMenuSchreiber()
  {
    final ActionListener listener = this;

    jmenubar = new JMenuBar();

    // datei

    dateiNeu = new JMenuItem("Datei neu...")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.FILE_NEW.toString());
      }
    };

    dateiSpeichern = new JMenuItem("Datei speichern")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.FILE_SAVE.toString());
      }
    };

    dateiSpeichernUnter = new JMenuItem("Datei speichern unter...")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.FILE_SAVE_AS.toString());
      }
    };

    jmenudatei = new JMenu("Datei")
    {
      {
        add(dateiNeu);
        add(dateiOeffnen);
        add(dateiSpeichern);
        add(dateiSpeichernUnter);
        add(dateiInfo);
        add(dateiBeenden);
      }
    };

    jmenubar.add(jmenudatei);

    // element

    elementAdd = new JMenuItem("Element hier erstellen")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.ELEMENT_ADD.toString());
      }
    };

    elementRemove = new JMenuItem("Element entfernen")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.ELEMENT_REMOVE.toString());
      }
    };

    elementSetParent = new JMenuItem("Element verschieben")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.ELEMENT_SET_PARENT.toString());
      }
    };

    elementSetTitel = new JMenuItem("Element umbenennen")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.ELEMENT_SET_TITEL.toString());
      }
    };

    elementSetDiagramm = new JMenuItem("Diagrammtyp festlegen")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.ELEMENT_SET_DIAGRAMM.toString());
      }
    };

    elementSetZusammenf = new JMenuItem("Bewertung festlegen")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.ELEMENT_SET_ZUSAMMENFASSUNG.toString());
      }
    };

    elementSetPioritaet = new JMenuItem("Priorität festlegen")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.ELEMENT_SET_PRIORITAET.toString());
      }
    };

    jmenuelement = new JMenu("Element")
    {
      {
        add(elementAdd);
        add(elementSetParent);
        add(elementSetTitel);
        add(elementRemove);
        add(elementSetDiagramm);
        add(elementSetPioritaet);
        add(elementSetZusammenf);
      }
    };

    jmenubar.add(jmenuelement);

    setJMenuBar(jmenubar);
  }


  private void speichernUnter()
  {
    file = null;
    speichere();
  }


  private synchronized void speichere(File f)
  {

    String s = f.getAbsolutePath();
    s += ! s.contains(".bsc") ? ".bsc" : "";

    file = new File(s);

    try
    {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
      oos.writeObject(Auswertung.getInstanz());
      oos.flush();
      oos.close();
    }
    catch(Exception exc)
    {
      zeigeException("Fehler" + " beim" + " Speichern der datei:\n" + f, exc);
    }
  }


  private void speichere()
  {
    if(file != null)
    {
      speichere(file);
      return;
    }

    JFileChooser jfc = new JFileChooser();
    jfc.setFileFilter(new FileNameExtensionFilter("BSC-Dateien", "bsc"));
    jfc.showSaveDialog(this);
    File f = jfc.getSelectedFile();

    if(f != null)
    {
      speichere(f);
    }
  }
}
