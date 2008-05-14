/**
 * 
 */
package gui;



import gui.frames.FrameAdmin;
import gui.frames.FrameLeser;
import gui.frames.FrameSchreiber;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 * @author andre
 */
public class StartBscGui
{


  @SuppressWarnings("serial")
  public static void main(String[] args)
  {
    // JA ICH WEISS DAS DIESER STIL SCHEISSE IST!


    // ein neues jframe:
    new JFrame("Bitte Modus wählen:")
    {
      {


        // mit folgendem contentpane:
        setContentPane(new JPanel(new GridLayout(0, 1))
        {
          {


            // ein knopf für leser:
            add(new JButton("leser")
            {
              {
                addActionListener(new ActionListener()
                {
                  public void actionPerformed(ActionEvent e)
                  {
                    new FrameLeser()
                    {
                      {
                        zeige();
                      }
                    };
                  }
                });
              }
            });



            // ein knopf für schreiber:
            add(new JButton("schreiber")
            {
              {
                addActionListener(new ActionListener()
                {
                  public void actionPerformed(ActionEvent e)
                  {
                    new FrameSchreiber()
                    {
                      {
                        zeige();
                      }
                    };
                  }
                });
              }
            });



            // ein knopf für admins:
            add(new JButton("admin")
            {
              {
                addActionListener(new ActionListener()
                {
                  public void actionPerformed(ActionEvent e)
                  {
                    new FrameAdmin()
                    {
                      {
                        zeige();
                      }
                    };
                  }
                });
              }
            });



          }
        });
        // fertig mit dem contentpane des jframes!



        // formatieren des jframes:
        setPreferredSize(new Dimension(200, 200));
        pack();
        setLocation(200, 200);



        // und anzeigen des jframes:
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



      }
    };
    // fertig mit dem jframe!



  }
  // fertig mit public static void main(String[] args)



}
