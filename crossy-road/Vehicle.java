// Import classes
import javax.swing.ImageIcon;

/** [Vehicle.java]
  * Desc: The class of all the vehicles
  * @author Emily Xie
  * @version Jun 2022
  */

public class Vehicle extends Object {
    // Variables
    private int speed;
    private int direction;
    
    /**
     * Vehicle
     * This constructor creates a new Vehicle object
     * @param x An int of the x-value of the vehicle
     * @param y An int of the y-value of the vehicle
     * @param speed An int of the speed of the vehicle
     * @param width An int of the width of the vehicle
     * @param direction An int of the direction of the vehicle
     * @param image An ImageIcon of the image of the vehicle
     */
    public Vehicle(int x, int y, int speed, int width, int direction, ImageIcon image) {
        // int width, int height, int x, int y, boolean isKillable, ImageIcon image
        super(width, Frame.SQUARE, x, y, true, image);
        this.speed = speed;
        this.direction = direction;
    }
    
    /**
     * moveVehicle
     * This method moves the vehicle depending on the direction
     */
    public void moveVehicle() {
        if (direction == Utility.LEFT) {
            super.x -= speed;
        } else {
            super.x += speed;
        }
    }
    
    // Getters and setters
    /**
     * getSpeed
     * This method gets the speed of the vehicle
     * @return speed An int of the speed of the vehicle
     */
    public int getSpeed() {
        return speed;
    }
    
    /**
     * getDirection
     * This method gets the direction of the vehicle
     * @return direction An int of the direction of the vehicle
     */
    public int getDirection() {
        return direction;
    }
    
    /**
     * setDirection
     * This method sets the direction of the vehicle
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    /**
     * setImage
     * This method sets the image of the vehicle
     * @param image An ImageIcon of the image of the vehicle
     */
    public void setImage(ImageIcon image) {
        super.image = image;
    }
}