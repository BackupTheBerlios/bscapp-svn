
package nachhaltigkeit ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 * @author   andre
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
			Bereich bereichA = new Bereich("Bereich A") ;
			Bereich bereichB = new Bereich("Bereich B") ;
			Bereich bereichC = new Bereich("Bereich C") ;
			Bereich bereichD = new Bereich("Bereich D") ;
			Bereich bereichE = new Bereich("Bereich E") ;
			rootElement.add(bereichA) ;
			rootElement.add(bereichB) ;
			rootElement.add(bereichC) ;
			rootElement.add(bereichD) ;
			rootElement.add(bereichE) ;

			// füge Kennzahlen in Bereiche ein:
			Kennzahl kennzahlA1 = new Kennzahl("Kennzahl A1") ;
			Kennzahl kennzahlA2 = new Kennzahl("Kennzahl A2") ;
			Kennzahl kennzahlA3 = new Kennzahl("Kennzahl A3") ;
			Kennzahl kennzahlB1 = new Kennzahl("Kennzahl B1") ;
			Kennzahl kennzahlB2 = new Kennzahl("Kennzahl B2") ;
			Kennzahl kennzahlB3 = new Kennzahl("Kennzahl B3") ;
			Kennzahl kennzahlC1 = new Kennzahl("Kennzahl C1") ;
			Kennzahl kennzahlC2 = new Kennzahl("Kennzahl C2") ;
			Kennzahl kennzahlD1 = new Kennzahl("Kennzahl D1") ;
			Kennzahl kennzahlE1 = new Kennzahl("Kennzahl E1") ;
			bereichA.add(kennzahlA1) ;
			bereichA.add(kennzahlA2) ;
			bereichA.add(kennzahlA3) ;
			bereichB.add(kennzahlB1) ;
			bereichB.add(kennzahlB2) ;
			bereichB.add(kennzahlB3) ;
			bereichC.add(kennzahlC1) ;
			bereichC.add(kennzahlC2) ;
			bereichD.add(kennzahlD1) ;
			bereichE.add(kennzahlE1) ;
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
			jScrollPaneTree.setPreferredSize(new Dimension(160, 300)) ;
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
			jPanelChart.setPreferredSize(new Dimension(500, 300));
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
		this.setMinimumSize(new Dimension(680, 420));
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
