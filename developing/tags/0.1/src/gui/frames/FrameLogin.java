package gui.frames;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import benutzerModell.Administrator;
import benutzerModell.BenutzerDatenbank;
import benutzerModell.Leser;
import benutzerModell.Schreiber;



@SuppressWarnings("serial")
public final class FrameLogin extends SuperFrame
{
  private final JTextField name = new JTextField();
  private final JPasswordField passwort = new JPasswordField();

  private static GridLayout GRID_LAYOUT = new GridLayout(0, 1, 5, 5);
  private static Border EMPTY_BORDER = new EmptyBorder(5, 5, 5, 5);



  public FrameLogin()
  {
    size = new Dimension(400, 300);
    setResizable(false);

    final ActionListener listener = this;

    north.add(new JLabel("Willkommen bei der BSC-Applikation!")
    {
      {
        Font font = getFont();
        Font ueberschrift = new Font(font.getName(),
                                     font.getStyle(),
                                     font.getSize() * 2);
        setFont(ueberschrift);
        setBorder(EMPTY_BORDER);
      }
    }, BorderLayout.CENTER);

    center.add(new JPanel(GRID_LAYOUT)
    {
      {
        add(new JPanel(GRID_LAYOUT)
        {
          {
            add(new JLabel("Benutzername eingeben:"));
            add(name);
            setBorder(EMPTY_BORDER);
          }
        });

        add(new JPanel(GRID_LAYOUT)
        {
          {
            add(new JLabel("Passwort eingeben:"));
            add(passwort);
            setBorder(EMPTY_BORDER);
          }
        });

        setBorder(EMPTY_BORDER);
      }
    }, BorderLayout.CENTER);

    south.add(new JPanel(new BorderLayout())
    {
      {

        add(new JPanel(GRID_LAYOUT)
        {
          {
            add(new JButton("Anmelden")
            {
              {
                addActionListener(listener);
                setActionCommand("ANMELDEN");
                setBorder(EMPTY_BORDER);
              }
            });

            add(new JButton("Beenden")
            {
              {
                addActionListener(listener);
                setActionCommand("BEENDEN");
                setBorder(EMPTY_BORDER);
              }
            });

            setBorder(EMPTY_BORDER);
          }
        }, BorderLayout.EAST);


      }
    });
  }


  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getActionCommand().equals("ANMELDEN"))
    {
      anmelden();
    }

    else if(e.getActionCommand().equals("BEENDEN"))
    {
      getWindowListeners()[0].windowClosing(null);
    }
  }


  /**
   * 
   */
  private void anmelden()
  {
    String sname = name.getText();
    String spasswort = new String(passwort.getPassword());

    String err = "";
    String title = "Benutzer anmelden";

    if(sname == null || spasswort == null)
    {
      err = "Bitte Name und Passwort eingeben.";
      zeigeError(err, title);
      return;
    }

    if(sname.length() == 0)
    {
      err = "Der Name darf nicht leer sein.";
      zeigeError(err, title);
      return;
    }

    Map<String, Leser> map;
    map = BenutzerDatenbank.datenBankFactory().getBenutzerDatenbank();

    Leser l = map.get(sname);

    if(l == null)
    {
      err = "Der angegebene Benutzer existiert nicht.";
      zeigeError(err, title);
      return;
    }

    FrameLeser fl = null;

    if(l instanceof Administrator)
    {
      fl = new FrameAdmin();
    }

    else if(l instanceof Schreiber)
    {
      fl = new FrameSchreiber();
    }

    else
    {
      fl = new FrameLeser();
    }

    fl.zeige();
    super.setVisible(false);
  }


  /**
   * @param args
   */
  public static void main(String[] args)
  {
    FrameLogin login = new FrameLogin();
    login.zeige();
  }
}
