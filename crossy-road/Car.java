// Import classes
import javax.swing.ImageIcon;

/** [Car.java]
  * Desc: The class of the cars
  * @author Emily Xie
  * @version Jun 2022
  */

public class Car extends Vehicle {
    // Variables
    public final ImageIcon[] CARS_LEFT = { 
        new ImageIcon("images/yellow_car_left.png"),
        new ImageIcon("images/orange_car_left.png"),
        new ImageIcon("images/truck_left.png")
    };
    public final ImageIcon[] CARS_RIGHT = { 
        new ImageIcon("images/yellow_car_right.png"),
        new ImageIcon("images/orange_car_right.png"),
        new ImageIcon("images/truck_right.png")
    };
    
    /**
     * Car
     * This constructor creates a new Car object.
     * @param y An int of the y-value of the car
     */
    public Car (int y) {
        // int x, int y, int speed, int width, int direction, ImageIcon image
        super(0, y, 2, 1, Utility.generateRandomNumber(Utility.LEFT, Utility.RIGHT), null); 
        // Set image depending on height and direction
        image = getCarImage(getDirection());
        width = image.getImage().getWidth(null);
        
        // Set the direction of the car based on the starting position
        if (getDirection() == Utility.LEFT) {
            x = Frame.WIDTH;
        } else {
            x = -getWidth();
        }
    }
    
    /**
     * getCarImage
     * This method randomly chooses a car image from the ImageIcon array.
     * @return A random image of a car facing right if the direction is right, otherwise a random image of a car facing left
     */
    public ImageIcon getCarImage(int direction) {
        if (direction == Utility.RIGHT) { 
            int rand = Utility.generateRandomNumber(0, CARS_RIGHT.length - 1);
            return CARS_RIGHT[rand];
        } else {
            int rand = Utility.generateRandomNumber(0, CARS_LEFT.length - 1);
            return CARS_LEFT[rand];
        }
    }
}