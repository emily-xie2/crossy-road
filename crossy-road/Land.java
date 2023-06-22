// Import classes
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/** [Land.java]
  * Desc: The parent class holding the different types of land
  * @author Emily Xie
  * @version Jun 2022
  */

public class Land extends Rectangle {
    // Variables
    protected ArrayList<Object> objects;
    private Color color;
    private int width, height, pos;
    public String type;
    
    /**
     * Land
     * This constructor creates a new Land object.
     * @param color A color object of the color of the land
     * @param pos An int of the position of the land
     * @param type A string of the type of land
     */
    public Land (Color color, int pos, String type) {
        this.color = color;
        this.pos = pos;
        width = Frame.WIDTH;
        height = Frame.SQUARE;
        objects = new ArrayList<Object>();
        this.type = type;
    }
    
    /**
     * updateObjectPos
     * This method updates the position of the objects.
     */
    public void updateObjectPos() { 
        for (int e = 0; e < objects.size(); e++) {
            (objects.get(e)).setY(pos * Frame.SQUARE);
        }
    }
    
    public void draw(Graphics g) {
        // Draw the land
        g.setColor(color);
        g.fillRect(0, pos * Frame.SQUARE, width, height);
    }
    
    // Getters and setters
    /**
     * getObjects
     * This method gets an array list of the objects.
     * @return objects An array list of the objects
     */
    public ArrayList<Object> getObjects() {
        return objects;
    }
    
    /**
     * getPos
     * This method gets the position of the land.
     * @return pos An int of the positions
     */
    public int getPos() {
        return pos;
    }
    
    /**
     * setPos
     * This method sets the position of the land.
     */
    public void setPos(int pos) {
        this.pos = pos;
    }
}