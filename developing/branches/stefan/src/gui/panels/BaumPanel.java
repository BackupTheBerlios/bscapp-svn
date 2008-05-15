/**
 * 
 */
package gui.panels;



import gui.frames.FrameLeser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import datenModell.Auswertung;



/**
 * @author andre
 */
@SuppressWarnings("serial")
public class BaumPanel extends JPanel implements TreeSelectionListener
{
  private DefaultMutableTreeNode wurzel, selection;
  @SuppressWarnings("unused")
  private FrameLeser frame;
  private DefaultTreeModel model;
  public final JTree baum;


  public BaumPanel(FrameLeser frame)
  {
    super(new BorderLayout());
    this.frame = frame;
    baum = new JTree();
    aktualisiereBaum();
    Dimension minimumsize = new Dimension(200, 500);
    JScrollPane scroller = new JScrollPane(baum);
    scroller.setPreferredSize(minimumsize);
    this.add(scroller, BorderLayout.CENTER);
  }



  /** @see javax.swing.event.TreeSelectionListener#valueChanged */
  @Override
  public void valueChanged(TreeSelectionEvent e)
  {
    selection = (DefaultMutableTreeNode)baum.getLastSelectedPathComponent();

    if(selection == null)
      return;

    frame.wertepanel.setNode(selection);
    System.out.println("selection: " + printPathOfSelection());
  }


  public String printPathOfSelection()
  {
    if(selection == null)
      return "";

    String path = "";
    TreeNode[] nodes = selection.getPath();
    for(TreeNode node : nodes)
    {
      DefaultMutableTreeNode n = (DefaultMutableTreeNode)node;
      path += "/" + n;
    }
    return path;
  }


  /**
   * @return the selection
   */
  public DefaultMutableTreeNode getSelection()
  {
    return selection;
  }


  public void aktualisiereBaum()
  {
    wurzel = Auswertung.getInstanz();

    model = new DefaultTreeModel(wurzel);

    baum.setModel(model);
    baum.getSelectionModel()
        .setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

    for(TreeSelectionListener l : baum.getTreeSelectionListeners())
      baum.removeTreeSelectionListener(l);

    baum.addTreeSelectionListener(this);
    baum.setExpandsSelectedPaths(true);
    reload();
  }



  /**
   * @param path
   * @see javax.swing.JTree#expandPath(javax.swing.tree.TreePath)
   */
  public void expandPath(TreePath path)
  {
    baum.expandPath(path);
  }



  /**
   * @param node
   * @see javax.swing.JTree#setSelectionPath(javax.swing.tree.TreePath)
   */
  public void setSelection(DefaultMutableTreeNode node)
  {
    reload();
    TreePath p = new TreePath(node.getPath());
    baum.setSelectionPath(p);
    baum.expandPath(p);
  }



  /**
   * @see javax.swing.tree.DefaultTreeModel#reload()
   */
  public void reload()
  {
    model.reload();
  }



  /**
   * @param node
   * @see javax.swing.tree.DefaultTreeModel#reload(javax.swing.tree.TreeNode)
   */
  public void reload(TreeNode node)
  {
    model.reload(node);
  }
}
