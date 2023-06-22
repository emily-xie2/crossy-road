// Import classes
import javax.swing.ImageIcon;

/** [Train.java]
  * Desc: The class of the trains
  * @author Emily Xie
  * @version Jun 2022
  */

public class Train extends Vehicle {
    // Variables
    public final ImageIcon TRAIN = new ImageIcon("images/train.png");
    
    /**
     * Train
     * This constructor creates a new Train object
     * @param x An int of the x-value
     */
    public Train(int x) {
        // int x, int y, int speed, int width, int direction, ImageIcon image
        super(Frame.WIDTH, 0, 5, Utility.generateRandomNumber(Utility.LEFT, Utility.RIGHT), Utility.generateRandomNumber(Utility.LEFT, Utility.RIGHT), null);
        image = TRAIN;
        width = image.getImage().getWidth(null);
    }
}