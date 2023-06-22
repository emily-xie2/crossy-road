//Import classes
import java.awt.Graphics;
import javax.swing.ImageIcon;

/** [Object.java]
  * Desc: The parent class of all the objects (anything in the game above the ground)
  * @author Emily Xie
  * @version Jun 2022
  */

public class Object {
    // Variables
    public int width, x;
    private int height, y;
    private boolean isKillable; 
    public ImageIcon image;
    
    /**
     * Object
     * This constructor creates a new Object object.
     * @param width An int of the width of the object
     * @param height An int of the height of the object
     * @param x An int of the x-value of the object
     * @param y An int of the y-value of the object
     * @param isKillable A boolean that determines if the object can kill
     * @param image An ImageIcon of the object
     */
    public Object(int width, int height, int x, int y, boolean isKillable, ImageIcon image) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.isKillable = isKillable;
        this.image = image;
    }
    
    public void draw(Graphics g) {
        // Draw the object
        g.drawImage(image.getImage(), x, y, width, height, null);
    }
    
    // Getters and setters
    /**
     * getX
     * This method gets the x value of the object
     * @return x An int of the x value
     */
    public int getX() {
        return x;
    }
    
    /**
     * getY
     * This method gets the y value of the object
     * @return y An int of the y value
     */
    public int getY() {
        return y;
    }
    
    /**
     * getWidth
     * This method gets the width of the object
     * @return width An int of the width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * getHeight
     * This method gets the height of the object
     * @return height An int of the height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * isCanKill
     * This method determines if the object can kill the chicken
     * @return isKillable A boolean of if it is killable or not
     */
    public boolean isCanKill() {
        return isKillable;
    }
    
    /**
     * getImage
     * This method gets the image of the object
     * @return image An ImageIcon of the image
     */
    public ImageIcon getImage() {
        return image;
    }
    
    /**
     * setX
     * This method sets the x-value of the object
     */
    public void setX (int x) {
        this.x = x;
    }
    
    /**
     * setY
     * This method sets the y-value of the object
     */
    public void setY (int y) {
        this.y = y;
    }
    
    /**
     * setWidth
     * This method sets the width of the object
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * setHeight
     * This method sets the height of the object
     */
    public void setHeight(int height) {
        this.height = height;
    }
}