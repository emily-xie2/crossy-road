// Import classes
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

/** [Utility.java]
  * Desc: The class for the frame holding the game elements
  * @author Emily Xie
  * @version Jun 2022
  */

public class Utility {
    // Colors
    public static final Color GRASS_COLOR = new Color(0,204,0);
    public static final Color WATER_COLOR = new Color(51,153,255);
    public static final Color ROAD_COLOR = new Color(153,153,153);
    public static final Color BACKGROUND = new Color(104, 205, 235);
    
    // Font
    public static final Font FONT = new Font("Courier", Font.PLAIN, 18);
    
    // Integers of the direction
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int FORWARD = 3;
    
    /**
     * generateRandomNumber
     * This method generates a random number between two values inclusive
     * @param min An int of the minimum value
     * @param max An int of the maximum value
     * @return number An int of the randomly generated number
     */
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        int number = random.nextInt(max - min + 1) + min;
        return number;
    }
}