/**
 * 
 */
package gui.frames;



import gui.helfer.Befehl;
import gui.panels.UserEditPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import benutzerModell.Administrator;
import benutzerModell.BenutzerDatenbank;
import benutzerModell.Leser;
import benutzerModell.Schreiber;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class FrameAdmin extends FrameSchreiber
{
  private JMenu jmenuuser;
  private JMenuItem userAdd, userRemove, userSetGruppe, userSetPasswort;
  public final UserEditPanel userpanel = new UserEditPanel();


  public FrameAdmin()
  {
    super();
    initJMenuAdmin();
    tabbedpane.add("Benutzer", userpanel);
  }


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
      case USER_ADD :
        USER_ADD();
        return;
      case USER_REMOVE :
        USER_REMOVE();
        return;
      case USER_SET_GRUPPE :
        USER_SET_GRUPPE();
        return;
      case USER_SET_PASSWORT :
        USER_SET_PASSWORT();
        return;
    }
  }


  private final void initJMenuAdmin()
  {
    final ActionListener listener = this;

    userAdd = new JMenuItem("Benutzer erstellen...")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.USER_ADD.toString());
      }
    };

    userRemove = new JMenuItem("Benutzer löschen")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.USER_REMOVE.toString());
      }
    };

    userSetGruppe = new JMenuItem("Benutzergruppe ändern")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.USER_SET_GRUPPE.toString());
      }
    };

    userSetPasswort = new JMenuItem("Benutzerpasswort ändern")
    {
      {
        addActionListener(listener);
        setActionCommand(Befehl.USER_SET_PASSWORT.toString());
      }
    };

    jmenuuser = new JMenu("Benutzer")
    {
      {
        add(userAdd);
        add(userRemove);
        add(userSetGruppe);
        add(userSetPasswort);
      }
    };

    jmenubar.add(jmenuuser);
  }


  /**
   * 
   */
  private void USER_SET_PASSWORT()
  {
  // TODO Auto-generated method stub

  }


  /**
   * 
   */
  private void USER_SET_GRUPPE()
  {
  // TODO Auto-generated method stub

  }


  /**
   * 
   */
  private void USER_REMOVE()
  {
  // TODO Auto-generated method stub

  }


  /**
   * 
   */
  private void USER_ADD()
  {
    final JRadioButton leserbutt = new JRadioButton("Leser");
    final JRadioButton schreiberbutt = new JRadioButton("Schreiber");
    final JRadioButton adminbutt = new JRadioButton("Administrator");

    final JTextField name = new JTextField();
    final JPasswordField pass1 = new JPasswordField();
    final JPasswordField pass2 = new JPasswordField();

    String title = "Benutzer erstellen";

    new ButtonGroup()
    {
      {
        add(leserbutt);
        add(schreiberbutt);
        add(adminbutt);
      }
    };

    JPanel frage = new JPanel(new GridLayout(0, 1))
    {
      {
        add(new JLabel("Geben Sie den Namen an:"));
        add(name);
        add(new JLabel("Wählen Sie die Benutzergruppe:"));
        add(leserbutt);
        add(schreiberbutt);
        add(adminbutt);
        add(new JLabel("Geben Sie das Passwort ein:"));
        add(pass1);
        add(new JLabel("Bestätigen Sie das Passwort:"));
        add(pass2);
        add(new JLabel("Möchten Sie den Benutzer einzufügen?"));
      }
    };

    for(;;)
    {
      if( ! frageTrueFalse(frage, title))
      {
        return;
      }

      if(name.getText() == null)
      {
        zeigeInfo("Der Name darf nicht leer sein.", title);
        continue;
      }

      if(name.getText().length() == 0)
      {
        zeigeInfo("Der Name darf nicht leer sein.", title);
        continue;
      }

      if( ! (leserbutt.isSelected() || schreiberbutt.isSelected() || adminbutt.isSelected()))
      {
        zeigeInfo("Es muss eine Gruppe ausgewählt werden.", title);
        continue;
      }

      if(pass1.getPassword() == null)
      {
        zeigeInfo("Das Passwort darf nicht leer sein.", title);
        continue;
      }

      if(pass1.getPassword().length == 0)
      {
        zeigeInfo("Das Passwort darf nicht leer sein.", title);
        continue;
      }

      String p1 = new String(pass1.getPassword());
      String p2 = new String(pass2.getPassword());

      if( ! p1.equals(p2))
      {
        zeigeInfo("Die Passwörter sind nicht gleich.", title);
        pass1.setText("");
        pass2.setText("");
        continue;
      }

      if(BenutzerDatenbank.datenBankFactory().findBenutzer(name.getText()))
      {
        zeigeInfo("Den Benutzer gibt es bereits.", title);
        name.setText(name.getText() + "_1");
        name.setSelectionStart(0);
        name.setSelectionEnd(name.getText().length());
        continue;
      }

      break;
    }

    Leser neu = null;

    if(leserbutt.isSelected())
    {
      neu = new Leser(name.getText(), new String(pass1.getPassword()));
    }
    
    if(schreiberbutt.isSelected())
    {
      neu = new Schreiber(name.getText(), new String(pass1.getPassword()));
    }
    
    if(adminbutt.isSelected())
    {
      neu = new Administrator(name.getText(), new String(pass1.getPassword()));
    }

    if(neu == null)
    {
      return;
    }

    BenutzerDatenbank.datenBankFactory().hinzufuegen(name.getText(), neu);
    super.refreshHard();
  }
}
