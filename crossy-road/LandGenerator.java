// Import classes
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/** [LandGenerator.java]
  * Desc: The class that generates all of the land strips
  * @author Emily Xie
  * @version Jun 2022
  */

public class LandGenerator {
    // Variables
    private ArrayList<Land> lands; 
    private boolean isMoving;
    
    /**
     * LandGenerator
     * This constructor creates a new LandGenerator object.
     */
    public LandGenerator() {
        lands = startingLand(); //generate the starting land
        isMoving = false;
    }
    
    /**
     * startingLand
     * This method generates the land when the game starts
     * @return startingLand An array list of the starting land
     */
    private ArrayList<Land> startingLand() {
        ArrayList<Land> startingLand = new ArrayList<Land>();
        for (int i = 0; i < Frame.WIDTH / Frame.SQUARE; i++) {
            startingLand.add(new Grass(new ArrayList<Integer>(Arrays.asList(0, 8)), Utility.GRASS_COLOR, i));
        }
        return startingLand;
    }
    
    /**
     * moveLand
     * This method moves the lands by removing the one on the top, shifting the positions, and adding a new land on the bottom
     */
    public void moveLand() {
        lands.remove(0);
        shiftLandPos();
        lands.add(generateNewLand());
    }
    
    /**
     * shiftLandPos
     * This method shifts the position of the lands
     */
    private void shiftLandPos() {
        for (int i = 0; i < lands.size(); i++) {
            (lands.get(i)).setPos((lands.get(i)).getPos() - 1);
        }
    }
    
    /**
     * shiftLandPos
     * This method generates new land based on what the previous land was
     * @return A new land based on the odds
     */
    private Land generateNewLand() {
        Land lastLand = lands.get(lands.size() - 1);
        
        // Array list of all the types of lands
        ArrayList<Land> lands = new ArrayList<Land>(Arrays.asList(new Grass(Utility.GRASS_COLOR, Frame.HEIGHT / Frame.SQUARE - 1),
                                                                  new River(Utility.WATER_COLOR, Frame.HEIGHT / Frame.SQUARE - 1),
                                                                  new Road(Utility.ROAD_COLOR, Frame.HEIGHT / Frame.SQUARE - 1),
                                                                  new TrainTrack(Utility.ROAD_COLOR, Frame.HEIGHT / Frame.SQUARE - 1)));
        // Check if the last land was grass
        if (lastLand.type == "Grass") {
            if (oddsOfSame(50)) { 
                return new Grass(Utility.GRASS_COLOR, Frame.HEIGHT / Frame.SQUARE - 1);
            } else {
                lands.remove(0);
                shuffleList(lands);
                return lands.get(0); 
            }
        }
        
        // Check if the last land was a river
        if (lastLand.type.equals("River")) {
            if (oddsOfSame(0)) {
                return new River(Utility.WATER_COLOR, Frame.HEIGHT / Frame.SQUARE - 1);
            } else {
                lands.remove(1);
                shuffleList(lands);
                return lands.get(0);
            }
        }
        
        // Check if the last land was a road
        if (lastLand.type.equals("Road")) {
            if (oddsOfSame(50)) { 
                return new Road(Utility.ROAD_COLOR, Frame.HEIGHT / Frame.SQUARE - 1);
            } else {
                lands.remove(2);
                shuffleList(lands);
                return lands.get(0);
            }
        }
        
        // Check if the last land was a train track
        if (lastLand.type.equals("TrainTrack")) {
            if (oddsOfSame(10)) {
                return new TrainTrack(Utility.ROAD_COLOR, Frame.HEIGHT / Frame.SQUARE - 1);
            } else {
                lands.remove(3);
                shuffleList(lands);
                return lands.get(0); 
            }
        }
        // Return grass if the previous statements were not true
        return new Grass(Utility.GRASS_COLOR, Frame.HEIGHT / Frame.SQUARE - 1);
    }
    
    public void draw(Graphics g) {
        for (int i = 0; i < lands.size(); i++) {
            (lands.get(i)).draw(g);
        }
    }
    
    /**
     * oddsOfSame
     * This method generates a random number and compares it to the inputed number
     * @param An int of the odds of it being the same
     * @return A number that is generated and less than the odds
     */
    public boolean oddsOfSame(int odds) {
        int number = Utility.generateRandomNumber(0, 100);
        return number <= odds;
    }
    
    /**
     * shuffleList
     * This method shuffles an array list
     * @param l An array list
     */
    public <T> void shuffleList(ArrayList<T> l) {
        int n = l.size();
        Random random = new Random();
        random.nextInt();
        
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            T helper = l.get(i);
            l.set(i, l.get(change));
            l.set(change, helper);
        }
    }
    
    // Getters and setters
    /**
     * getLands
     * This method gets an array list of the lands
     * @return lands An array list of the land objects
     */
    public ArrayList<Land> getLands() {
        return lands;
    }
    
    /**
     * isMoving
     * This method determines if the land is moving
     * @return isMoving A boolean that determines if the land is moving
     */
    public boolean isMoving() {
        return isMoving;
    }
    
    /**
     * setIsMoving
     * This method sets the land as moving
     */
    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
}