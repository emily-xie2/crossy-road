// Import classes
import javax.swing.ImageIcon;

/** [Tree.java]
  * Desc: The class of the trees
  * @author Emily Xie
  * @version Jun 2022
  */

public class Tree extends Object {
    // Variables
    public final ImageIcon TREE = new ImageIcon("images/tree.png");
    
    /**
     * Tree
     * This constructor creates a new Tree object
     * @param x An int of the x-value
     * @param y An int of the y-value
     */
    public Tree(int x, int y) {
        // int width, int height, int x, int y, boolean isKillable, ImageIcon image
        super(Frame.SQUARE, Frame.SQUARE, x, y, false, null);
        image = TREE;
    }
}