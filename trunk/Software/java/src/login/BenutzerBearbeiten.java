/**
 * 
 */
package login;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;



/**
 * @author andre
 */
@ SuppressWarnings( "serial" )
public class BenutzerBearbeiten extends JFrame
{
	private JTable table;
	private JLabel überschrift = new JLabel( "Hier werden Benutzerkonten angelegt und bearbeitet." );
	private JButton löschen, ändernPasswort, neu, gruppeÄndern;
	@ SuppressWarnings( "unused" )
	private JTextField statusLeiste = new JTextField( "Status: " );
	
	
	/**
	 * @throws HeadlessException
	 */
	public BenutzerBearbeiten() throws HeadlessException
	{
		super( "Benutzer bearbeiten" );
		super.addWindowListener( new WindowAdapter()
		{
			@ Override
			public void windowClosing( WindowEvent e )
			{
				System.exit( 0 );
			}
		} );
		super.setContentPane( createContentPane() );
		super.setPreferredSize( new Dimension( 400, 200 ) );
		super.pack();
		super.setLocation( getCenterOfScreen() );
		super.setVisible( true );
	}
	

	public static void main( String[] args )
	{
		new BenutzerBearbeiten();
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
		JPanel panel = new JPanel( new BorderLayout() );
		TableSorter ts = new TableSorter( new MyTableModel() );
		table = new JTable( ts );
		table.setFillsViewportHeight( true );
		ts.setTableHeader( table.getTableHeader() );
		JScrollPane srcoll = new JScrollPane( table );
		panel.add( srcoll );
		return panel;
	}
	

	private JPanel createNORTH()
	{
		JPanel panel = new JPanel( new BorderLayout() );
		panel.add( überschrift );
		return panel;
	}
	

	private JPanel createEAST()
	{
		JPanel panel = new JPanel( new GridLayout( 0, 1 ) );
		JPanel p = new JPanel( new BorderLayout() );
		// private JButton löschen, ändernPasswort, neu, gruppeÄndern;
		löschen = new JButton( "Benutzer löschen" );
		ändernPasswort = new JButton( "Passwort ändern" );
		neu = new JButton( "neuer Benutzer" );
		gruppeÄndern = new JButton( "Gruppe ändern" );
		
		panel.add( neu );
		panel.add( ändernPasswort );
		panel.add( löschen );
		panel.add( gruppeÄndern );
		p.add( panel, BorderLayout.SOUTH );
		
		return p;
	}
	

	private JPanel createSOUTH()
	{
		JPanel panel = new JPanel( new BorderLayout() );
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
		
		return new Point( screenW / 2 - windowW / 2, screenH / 2
		                                             - windowH
		                                             / 2 );
	}
	
	@ SuppressWarnings( "serial" )
	private class MyTableModel extends AbstractTableModel
	{
		private String[] colNames =
		{
		        "Benutzername", "Benuzergruppe"
		};
		
		
		public MyTableModel()
		{}
		

		public int getColumnCount()
		{
			return colNames.length;
		}
		

		@ Override
		public String getColumnName( int col )
		{
			return colNames[ col ];
		}
		

		public int getRowCount()
		{
			return 0;
		}
		

		public Object getValueAt( int row, int col )
		{
			return new Object();
		}
		

		@ Override
		public Class< ? > getColumnClass( int col )
		{
			return Object.class;
		}
		

		@ Override
		public boolean isCellEditable( int rowIndex, int columnIndex )
		{
			return false;
		}
	}
}
