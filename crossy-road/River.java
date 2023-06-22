// Import classes
import java.awt.Color;
import java.awt.Graphics;

/** [River.java]
  * Desc: The class of the cars
  * @author Emily Xie
  * @version Jun 2022
  */

public class River extends Land {
    
    /**
     * River
     * This constructor creates a new River object
     * @param color An object of the color of the river
     * @param pos An int of the position of the river
     */
    public River(Color color, int pos) {
        // Color color, int pos, String type
        super(color, pos, "River"); 
        // Add a new log
        objects.add(new Log(Utility.generateRandomNumber(0, 1) * Frame.WIDTH, getPos() * Frame.SQUARE)); 
    }
    
    public void draw(Graphics g) {
        super.draw(g);
        updateObjectPos();
        
        // Draw the log
        for (int e = 0; e < objects.size(); e++) {
            ((Log) objects.get(e)).moveLog();
            (objects.get(e)).draw(g);
            
            // Check if the log is offscreen and remove it if it is
            if ((objects.get(e)).getX() > Frame.WIDTH || (objects.get(e)).getX() + (objects.get(e)).getWidth() + 10 < 0) {
                objects.remove(0);
                objects.add(new Log(Utility.generateRandomNumber(0, 1) * Frame.WIDTH, getPos() * Frame.SQUARE));
            }
        }
    }
}