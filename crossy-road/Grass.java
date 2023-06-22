// Import classes
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/** [Grass.java]
  * Desc: The class of the grass
  * @author Emily Xie
  * @version Jun 2022
  */

public class Grass extends Land {
    // Variables
    private int maxNumOfObjects = 1;
    ArrayList<Integer> existingPositions = new ArrayList<Integer>();

    /**
     * Grass
     * This constructor creates a new Grass object
     * @param color An object of the color of the grass
     * @param position An int of the position of the grass
     */
    public Grass(Color color, int pos) {
        // Color color, int pos, String type
        super(color, pos, "Grass");
        
        // An ArrayList of all the tree positions
        ArrayList<Integer> treePositions = generateTreePositions(existingPositions);
        existingPositions = treePositions;
        
        // Add trees for each tree position
        for (int i = 0; i < treePositions.size(); i++) {
            objects.add(new Tree(treePositions.get(i) * Frame.SQUARE, getPos() * Frame.SQUARE));
        }
        
        // An ArrayList of all the rock positions
        ArrayList<Integer> rockPositions = generateRockPositions(existingPositions);
        
        // Add rocks for each tree position
        for (int i = 0; i < rockPositions.size(); i++) {
            objects.add(new Rock(rockPositions.get(i) * Frame.SQUARE, getPos() * Frame.SQUARE));
        }
    }
    
    /**
     * Grass
     * This constructor generate grass with specified tree positions
     * @param treePositions An Arraylist of the specified tree positions
     * @param color The color of the grass
     * @param pos The position of the grass
     */
    public Grass(ArrayList<Integer> treePositions, Color color, int pos) {
        super(color, pos, "Grass");
        
        // Add the trees to the objects ArrayList
        for (int i = 0; i < treePositions.size(); i++) {
            objects.add(new Tree(treePositions.get(i) * Frame.SQUARE, getPos() * Frame.SQUARE));
        }
    }
    
    public void draw(Graphics g) {
        super.draw(g);
        updateObjectPos();
        
        // Draw the trees and rocks
        for (int e = 0; e < objects.size(); e++) {
            (objects.get(e)).draw(g);
        }
    }
    
    /**
     * generateTreePositions
     * This method randomly generates tree positions
     * @param existingPositions An array list of the existing positions of the trees and rocks
     * @return positions The positions of the trees
     */
    private ArrayList<Integer> generateTreePositions(ArrayList<Integer> existingPositions) {
        ArrayList<Integer> positions = generateRandomNumbers(0, Frame.WIDTH / Frame.SQUARE, Utility.generateRandomNumber(1, maxNumOfObjects), existingPositions);
        return positions;
    }
    
    /**
     * generateRockPositions
     * This method randomly generates rock positions
     * @param existingPositions An array list of the existing positions of the trees/rocks
     * @return positions The positions of the rocks
     */
    private ArrayList<Integer> generateRockPositions(ArrayList<Integer> existingPositions) {
        ArrayList<Integer> positions = generateRandomNumbers(0, Frame.WIDTH / Frame.SQUARE, Utility.generateRandomNumber(1, maxNumOfObjects), existingPositions);
        return positions;
    }
    
    /**
     * generateRandomNumbers
     * This method randomly generates a list of random numbers between two numbers inclusive
     * @param min An int of the minimum value of the list
     * @param max An int of the maxmimum value of the list
     * @param listSize An int of the size of the list
     * @param existingPositions An array list of the existing positions of the trees/rocks
     * @return listRand An integer array list of the random numbers
     */
    public ArrayList<Integer> generateRandomNumbers(int min, int max, int listSize, ArrayList<Integer> existingPositions) {
        ArrayList<Integer> listRand = new ArrayList<Integer>();
        
        for (int i = 0; i < listSize; i++) {
            int pos = Utility.generateRandomNumber(min, max);
            while (existingPositions.contains(pos)) {
                pos = Utility.generateRandomNumber(min, max);
            }
            existingPositions.add(pos);
            listRand.add(pos);
        }
        return listRand;
    }
}