/**
 * 
 */
package login;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 * @author andre
 */
@ SuppressWarnings( "serial" )
public class AnmeldeBildschirm extends JFrame
{
	private JTextField namensfeld;
	private JTextField passwort;
	private JLabel willkommen = new JLabel( "Willkommen blabla" );
	
	private JButton login, hilfe;
	
	
	public AnmeldeBildschirm()
	{
		super( "Login" );
		namensfeld = new JTextField( 10 );
		passwort = new JTextField( 10 );
		login = new JButton( "anmelden" );
		hilfe = new JButton( "hilfe" );
		

		super.addWindowListener( new WindowAdapter()
		{
			public void windowClosing( WindowEvent e )
			{
				System.exit( 0 );
			}
		} );
		
		super.setContentPane( createContentPane() );
		super.setPreferredSize( new Dimension( 200, 200 ) );
		super.pack();
		super.setLocation( getCenterOfScreen() );
		super.setVisible( true );
	}
	

	private JPanel createContentPane()
	{
		JPanel panel = new JPanel( new BorderLayout() );
		panel.add( createCENTER(), BorderLayout.CENTER );
		panel.add( createNORTH(), BorderLayout.NORTH );
		panel.add( createEAST(), BorderLayout.EAST );
		panel.add( createSOUTH(), BorderLayout.SOUTH );
		panel.add( createWEST(), BorderLayout.WEST );
		return panel;
	}
	

	private JPanel createCENTER()
	{
		JPanel panel = new JPanel( new GridLayout( 0, 1 ) );
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.add( namensfeld );
		p2.add( passwort );
		
		p1.setBorder( BorderFactory.createTitledBorder( "Benutzername:" ) );
		p2.setBorder( BorderFactory.createTitledBorder( "Kennwort:" ) );
		
		panel.add( p1 );
		panel.add( p2 );
		return panel;
	}
	

	private JPanel createNORTH()
	{
		JPanel panel = new JPanel( new BorderLayout() );
		panel.add( this.willkommen );
		return panel;
	}
	

	private JPanel createEAST()
	{
		JPanel panel = new JPanel( new BorderLayout() );
		return panel;
	}
	

	private JPanel createSOUTH()
	{
		JPanel panel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		panel.add( login );
		panel.add( hilfe );
		return panel;
	}
	

	private JPanel createWEST()
	{
		JPanel panel = new JPanel( new BorderLayout() );
		return panel;
	}
	

	private Point getCenterOfScreen()
	{
		int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		int windowW = super.getSize().width;
		int windowH = super.getSize().height;
		
		return new Point( ( screenW / 2 ) - ( windowW / 2 ),
		                  ( screenH / 2 ) - ( windowH / 2 ) );
	}
	

	public static void main( String[] args )
	{
		new AnmeldeBildschirm();
	}
	
}
