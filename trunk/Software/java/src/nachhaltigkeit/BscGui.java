
package nachhaltigkeit ;

import java.awt.BorderLayout ;
import java.awt.Color ;
import java.awt.Dimension ;
import java.awt.Font ;
import java.awt.Point ;
import java.awt.Toolkit ;
import javax.swing.BorderFactory ;
import javax.swing.JFrame ;
import javax.swing.JPanel ;
import javax.swing.JScrollPane ;
import javax.swing.JTree ;
import javax.swing.SwingUtilities ;
import javax.swing.border.TitledBorder ;
import javax.swing.event.TreeSelectionEvent ;
import javax.swing.event.TreeSelectionListener ;
import javax.swing.tree.DefaultMutableTreeNode ;
import javax.swing.tree.TreeSelectionModel ;

/**
 * @author andre
 */
public class BscGui extends JFrame implements TreeSelectionListener
{
	private static final long serialVersionUID = 1L ;
	private JPanel jContentPane = null ;
	private JTree jTree = null ;
	private JScrollPane jScrollPaneTree = null ;
	private JPanel jPanelChart = null ;
	private RootElement rootElement ;

	/**
	 * This method initializes jTree
	 * 
	 * @return javax.swing.JTree
	 */
	private JTree getJTree()
	{
		if( jTree == null )
		{
			rootElement = new RootElement() ;
			// füge die Bereich in bscRoot ein:
			Bereich bKunden = new Bereich("Kunden") ;
			Bereich bEntwicklung = new Bereich("Lernen und Entwicklung") ;
			Bereich bInterneProzesse = new Bereich("Interne Prozesse") ;
			Bereich bFinanzen = new Bereich("Finanzen") ;

			/*
			 * TODO: konstruktor von bereich modifizieren, dass er eine
			 * wichtigkeit erwartet
			 */
			// setze wichtigkeit der kunden in die bereiche ein:
			bKunden.setWichtigkeit(new Point(1, 3)) ;
			bEntwicklung.setWichtigkeit(new Point(2, 2)) ;
			bInterneProzesse.setWichtigkeit(new Point(2, 1)) ;
			bFinanzen.setWichtigkeit(new Point(3, 1)) ;

			rootElement.add(bKunden) ;
			rootElement.add(bEntwicklung) ;
			rootElement.add(bInterneProzesse) ;
			rootElement.add(bFinanzen) ;

			// füge Kennzahlen in Bereiche ein:
			AnzahlSchueler kAnzahlSchueler = new AnzahlSchueler("Anzahl der Schüler ") ;
			Kennzahl kZufriedenheitSchueler = new Kennzahl("Zufriedenheit der Schüler ") ;
			UnterrichtsQualtiaet kUnterrichtsQualitaet = new UnterrichtsQualtiaet("Qualität des Unterrichts") ;
			Kennzahl kKrankenstandLehrer = new Kennzahl("Krankenstände der Lehrer") ;
			Kennzahl kKarenzLehrer = new Kennzahl("Karenz") ;
			Kennzahl kFortbildungLehrer = new Kennzahl("Fortbildung der Lehrer") ;
			Kennzahl kEnergieverbrauch = new Kennzahl("Gesamtenergieverbrauch") ;
			Kennzahl kHeizverbrauch = new Kennzahl("Heizungsverbrauch") ;
			Kennzahl kBudgettoepfe = new Kennzahl("Budgettöpfe der Spengergasse") ;
			bKunden.add(kAnzahlSchueler) ;
			bKunden.add(kZufriedenheitSchueler) ;
			bKunden.add(kUnterrichtsQualitaet) ;
			bEntwicklung.add(kKrankenstandLehrer) ;
			bEntwicklung.add(kKarenzLehrer) ;
			bEntwicklung.add(kFortbildungLehrer) ;
			bInterneProzesse.add(kEnergieverbrauch) ;
			bInterneProzesse.add(kHeizverbrauch) ;
			bFinanzen.add(kBudgettoepfe) ;
			jTree = new JTree(rootElement) ;
			jTree.addTreeSelectionListener(this) ;
			jTree.getSelectionModel()
			     .setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION) ;
			jTree.setRootVisible(true) ;
		}
		return jTree ;
	}

	/**
	 * This method initializes jScrollPaneTree
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneTree()
	{
		if( jScrollPaneTree == null )
		{
			jScrollPaneTree = new JScrollPane() ;
			jScrollPaneTree.setPreferredSize(new Dimension(200, 300)) ;
			jScrollPaneTree.setBorder(BorderFactory.createTitledBorder(null,
			                                                           "Ebenen:",
			                                                           TitledBorder.DEFAULT_JUSTIFICATION,
			                                                           TitledBorder.DEFAULT_POSITION,
			                                                           new Font("Dialog",
			                                                                    Font.BOLD,
			                                                                    12),
			                                                           new Color(51,
			                                                                     51,
			                                                                     51))) ;
			jScrollPaneTree.setViewportView(getJTree()) ;
		}
		return jScrollPaneTree ;
	}

	/**
	 * This method initializes jPanelChart
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelChart()
	{
		if( jPanelChart == null )
		{
			jPanelChart = new JPanel() ;
			jPanelChart.setLayout(new BorderLayout()) ;
			jPanelChart.setBorder(BorderFactory.createTitledBorder(null,
			                                                       "Diagramm:",
			                                                       TitledBorder.DEFAULT_JUSTIFICATION,
			                                                       TitledBorder.DEFAULT_POSITION,
			                                                       new Font("Dialog",
			                                                                Font.BOLD,
			                                                                12),
			                                                       new Color(51,
			                                                                 51,
			                                                                 51))) ;
			jPanelChart.setPreferredSize(new Dimension(500, 300)) ;
		}
		return jPanelChart ;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				BscGui thisClass = new BscGui() ;
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
				thisClass.setVisible(true) ;
			}
		}) ;
	}

	/**
	 * This is the default constructor
	 */
	public BscGui()
	{
		super() ;
		initialize() ;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize()
	{
		// try
		// {
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
		// }
		// catch( Exception e )
		// {}
		this.setSize(680, 420) ;
		this.setMinimumSize(new Dimension(680, 420)) ;
		this.setLocation(this.mitteDesBildschirms()) ;
		this.setContentPane(getJContentPane()) ;
		this.setContentPane(getJContentPane()) ;
		this.setTitle("BSC Gui") ;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane()
	{
		if( jContentPane == null )
		{
			jContentPane = new JPanel() ;
			jContentPane.setLayout(new BorderLayout()) ;
			jContentPane.setPreferredSize(new Dimension(0, 0)) ;
			jContentPane.add(getJScrollPaneTree(), BorderLayout.WEST) ;
			jContentPane.add(getJPanelChart(), BorderLayout.CENTER) ;
		}
		return jContentPane ;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.event.TreeSelectionListener#valueChanged(javax.swing.event.TreeSelectionEvent)
	 */
	public void valueChanged(TreeSelectionEvent e)
	{
		// Returns the last path element of the selection.
		// This method is useful only when the selection model allows a single
		// selection.
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent() ;
		if( node != null )
		{
			jPanelChart.removeAll() ;
			jPanelChart.add(((MyTreeNode)node).gibDiagramm()) ;
			super.setPreferredSize(super.getSize()) ;
			super.pack() ;
		}
	}

	private Point mitteDesBildschirms()
	{
		int screenW = Toolkit.getDefaultToolkit().getScreenSize().width ;
		int screenH = Toolkit.getDefaultToolkit().getScreenSize().height ;

		int windowW = super.getSize().width ;
		int windowH = super.getSize().height ;

		return new Point((screenW / 2) - (windowW / 2),
		                 (screenH / 2) - (windowH / 2)) ;
	}
}
