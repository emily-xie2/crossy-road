// Import classes
import javax.swing.ImageIcon;

/** [Log.java]
  * Desc: The class of the logs
  * @author Emily Xie
  * @version Jun 2022
  */

public class Log extends Object {
    // Variables
    public final ImageIcon LOG = new ImageIcon("images/log.png");
    private int direction;
    private int speed;
    
    /**
     * Log
     * This constructor creates a new Log object.
     * @param x An int of the x value
     * @param y An int of the y value
     */
    public Log(int x, int y) {
        // int width, int height, int x, int y, boolean isKillable, ImageIcon image
        super(3 * Frame.SQUARE, Frame.SQUARE, x, y, false, null);
        image = LOG;
        speed = 1;
        
        // Reposition the x value if it is 0
        if(getX() == 0) {
            setX(-getWidth() - Utility.generateRandomNumber(0, getWidth() + (getWidth() / 4)));
        }
        if (x == Frame.WIDTH) {
            direction = Utility.LEFT;
        } else {
            direction = Utility.RIGHT;
        }
    }
    
    /**
     * moveLog
     * This method moves the logs.
     */
    public void moveLog() {
        if (direction == Utility.LEFT) {
            x -= speed;
        } else {
            x += speed;
        }
    }
    
    // Getters
    /**
     * getDirection
     * This method gets the direction of the logs.
     * @return direction An int of the direction of the log
     */
    public int getDirection() {
        return direction;
    }
    
    /**
     * getSpeed
     * This method gets the speed of the logs.
     * @return speed An int of the speed of the log
     */
    public int getSpeed() {
        return speed;
    }
}