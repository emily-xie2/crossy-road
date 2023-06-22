// Import classes
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/** [Road.java]
  * Desc: The class of the road
  * @author Emily Xie
  * @version Jun 2022
  */

public class Road extends Land {
    /**
     * Road
     * This constructor creates a new Road object
     * @param color An object of the color of the road
     * @param pos An int of the position of the road
     */
    public Road(Color color, int pos) {
        // Color color, int pos, String type
        super(color, pos, "Road");
        // Create a new car
        Car car = new Car(getPos() * Frame.SQUARE);
        objects.add(car);
    }
    
    public void draw(Graphics g) {
        super.draw(g);
        updateObjectPos();
        
        // Draw the road
        for (int i = 0; i < Frame.WIDTH; i += Frame.SQUARE) {
            g.drawImage((new ImageIcon("images/road.png")).getImage(), i, getPos() * Frame.SQUARE, null);
        }
        
        // Draw the cars
        for(int e = 0; e < objects.size(); e++) {
            ((Car) objects.get(e)).moveVehicle();
            (objects.get(e)).draw(g);
            
            // Checks if the car is outside the frame and removes if it is
            if ((objects.get(e)).getX()  > Frame.WIDTH || (objects.get(e)).getX() + (objects.get(e)).getWidth()  < 0) {
                objects.remove(0);
                objects.add(new Car(getPos() * Frame.SQUARE));

            }
        }
    }
}