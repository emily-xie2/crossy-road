// Import classes
import javax.swing.ImageIcon;

/** [Rock.java]
  * Desc: The class of the rocks
  * @author Emily Xie
  * @version Jun 2022
  */

public class Rock extends Object {
    // Variables
    public final ImageIcon ROCK = new ImageIcon("images/rock.png");
    
    /**
     * Rock
     * This constructor creates a new Rock object
     * @param x An int of the x-value
     * @param y An int of the y-value
     */
    public Rock(int x, int y) {
        // int width, int height, int x, int y, boolean isKillable, ImageIcon image
        super(Frame.SQUARE, Frame.SQUARE, x, y, false, null);
        image = ROCK;
    }
}