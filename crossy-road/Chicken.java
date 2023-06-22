// Import classes
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/** [Chicken.java]
  * Desc: The class of the chicken
  * @author Emily Xie
  * @version Jun 2022
  */

public class Chicken extends Object {
    // Variables
    private int space, moveDirection; 
    private boolean isMoving, canMoveLeft, canMoveRight, canMoveForward, isDead, onLog; 
    public final ImageIcon CHICKEN = new ImageIcon("images/chicken.png");
    
    /**
     * Chicken
     * This constructor creates a new Chicken object.
     * @param x An int of the x-value of the chicken
     * @param space The amount of space the chicken moves every time a ASD key is clicked
     */
    public Chicken (int x, int space) {
        // int width, int height, int x, int y, boolean isKillable, ImageIcon image
        super (Frame.SQUARE-10, Frame.SQUARE-10, x, Frame.SQUARE * 3, false, null); 
        this.x = x;
        this.space = space;
        image = CHICKEN;
        canMoveLeft = true;
        canMoveRight = true;
        canMoveForward = true;
        onLog = false;
    }
    
    /**
     * moveLeft
     * This method moves the chicken left.
     */
    public void moveLeft() {
        moveDirection = Utility.LEFT;
        if (x <= 0) {
            x -= 0;
        } else {
            x -= space;
        }
    }
    
    /**
     * moveRight
     * This method moves the chicken right.
     */
    public void moveRight() {
        moveDirection = Utility.RIGHT;
        if (x >= Frame.WIDTH - Frame.SQUARE) {
            x += 0;
        } else {
            x += space;
        }
    }
    
    /**
     * chickenMoved
     * This method checks if the move animation has occured.
     */
    public boolean chickenMoved() {
        return x % Frame.SQUARE == 0;
    }

    /**
     * moveWithLog
     * This method allows the player to move with the log it is on.
     * @param objects An array list of all the objects from the land it is currently on
     */
    public void moveWithLog(ArrayList<Object> objects) {
        for (int e = 0; e < objects.size(); e++) {
            int objectX = (objects.get(e)).getX();
            int objectY = (objects.get(e)).getY();
            int objectWidth = (objects.get(e)).getWidth();
            int objectHeight = (objects.get(e)).getHeight();
            int objectDirection = ((Log) (objects.get(e))).getDirection();
            int objectSpeed = ((Log) (objects.get(e))).getSpeed();
            
            // Create the hit boxes of the objects and chicken
            Rectangle objectHitbox = new Rectangle(objectX + 1, objectY, objectWidth - 1, objectHeight);
            Rectangle chickenHitbox = new Rectangle(getX(), getY(), getWidth(), getHeight()); 
            
            // Check if the chicken is on a log
            if (chickenHitbox.intersects(objectHitbox)) {
                if (!onLog) { 
                    // Put the chicken onto the log's center position
                    onLog = true;
                    x = objectX + Frame.SQUARE;
                    
                } else { 
                    // Move the chicken with the log
                    x = objectX + Frame.SQUARE;
                    if(objectDirection == Utility.LEFT) {
                        x -= objectSpeed;
                    } else {
                        x += objectSpeed;
                    }
                    moveDirection = objectDirection;
                    
                    // Check if the player is still on the log
                    if(!chickenHitbox.intersects(objectHitbox)) {
                        isDead = true;
                    }
                }
            } else { 
                // Player is dead if they are not on the log but are on water
                isDead = true;
            }
        }
    }

    /**
     * handleXCollision
     * This method handles the collisions on the x-axis. 
     * @param currentLand A Land object of the current land the chicken is standing on
     */
    public void handleXCollision (Land currentLand) {
        for (int i = 0; i < currentLand.objects.size(); i++) {
            Object currentObject = currentLand.objects.get(i);
            int objectX = currentObject.getX();
            int objectY = currentObject.getY();
            int objectWidth = currentObject.getWidth();
            int objectHeight = currentObject.getHeight();

            // Create the hit boxes of the objects and chicken
            Rectangle objectHitBox = new Rectangle(objectX , objectY, objectWidth , objectHeight);
            Rectangle chickenHitBox = new Rectangle(getX(), getY(), getWidth(), getHeight());

            if (objectHitBox.intersects(chickenHitBox)) {
                if (currentObject.isCanKill()) {
                    isDead = true;
                } else {
                    if (objectX < getX()) {
                        moveRight();
                        setCanMoveLeft(false);
                        setCanMoveRight(true);
                    }  else {
                        moveLeft();
                        setCanMoveRight(false);
                        setCanMoveLeft(true);
                    }
                }
            } else {
                setCanMoveLeft(true);
                setCanMoveRight(true);
            }
        }
    }

    /**
     * handleYCollision
     * This method handles the collisions on the y-axis. 
     * @param nextLand A Land object of the next land the chicken will stand on
     */
    public void handleYCollision(Land nextLand) {
        for (int i = 0; i < nextLand.objects.size(); i++) {
            Object currentObject = nextLand.objects.get(i);
            int objectX = currentObject.getX();
            int objectY = currentObject.getY();
            int objectWidth = currentObject.getWidth();
            int objectHeight = currentObject.getHeight();

            // Create the hit boxes of the objects and chicken
            Rectangle objectHitBox = new Rectangle(objectX, objectY - Frame.SQUARE, objectWidth , objectHeight);
            Rectangle chickenHitBox = new Rectangle(getX(), getY(), getWidth(), getHeight());

            if (objectHitBox.intersects(chickenHitBox)) {
                if (! nextLand.type.equals("River") && !currentObject.isCanKill()) {
                    setCanMoveForward(false);
                }
            }
        }
        setCanMoveForward(true);
    }
    
    /**
     * hasCollided
     * This method creates a rectangle around the chicken and each object to determine collision.
     * @param objects An array list of objects on the land
     * @param isNextLand A boolean that determines if the objects are from the land the chicken is currently on or the next land
     * @param isNextLandRiver A boolean that determines if the next land is a river
     * @return Forward, left, or right depending on where the object is, 0 as default
     */
    public int hasCollided (ArrayList<Object> objects, boolean isNextLand, boolean isNextLandRiver) {
        for (int e = 0; e < objects.size(); e++) { 
            int objectX = (objects.get(e)).getX();
            int objectY = (objects.get(e)).getY();
            int objectWidth = (objects.get(e)).getWidth();
            int objectHeight = (objects.get(e)).getHeight();
            
            // Create the hit boxes of the objects and chicken
            Rectangle objectHitbox = new Rectangle(objectX , objectY, objectWidth , objectHeight);
            Rectangle chickenHitbox = new Rectangle(getX(), getY(), getWidth(), getHeight()); 
            
            // For the next land, shiift all of the objects one square up
            if(isNextLand) {
                objectHitbox = new Rectangle(objectX, objectY - Frame.SQUARE, objectWidth, objectHeight);
            }
            
            // Check for collision
            if(chickenHitbox.intersects(objectHitbox)) {
                if(isNextLand && !(objects.get(e)).isCanKill() && !isNextLandRiver) {
                    // Do not kill the chicken if it did not collide with a killable object and the next land is not water
                    return Utility.FORWARD;
                } else {
                    if(!isNextLand && (objects.get(e)).isCanKill()) {
                        // Chicken is dead because it collided with an object that can kill it
                        isDead = true;
                        return 0; // Default return value when chicken is dead
                    } else {
                        // Check if the chicken collided with an object left or right to it
                        if(objectX < getX()) {
                            return Utility.LEFT; 
                        }
                        if(objectX > getX()) { 
                            return Utility.RIGHT; 
                        }
                    }
                }
            }
        }
        return 0; // Default return value when chicken is dead
    }
    
    // Getters and setters
    /**
     * isCanMoveForward
     * This method determines if the chicken can move forward.
     * @return canMoveForward A boolean that determines if the chicken can move forward
     */
    public boolean isCanMoveForward() {
        return canMoveForward;
    }
    
    /**
     * getMoveDirection
     * This method gets the move direction of the chicken.
     * @return moveDirection An int of the move direction of the chicken
     */
    public int getMoveDirection() {
        return moveDirection;
    }
    
    /**
     * canMoveRight
     * This method determines if the chicken can move right.
     * @return canMoveRight A boolean that determines if the chicken can move right
     */
    public boolean canMoveRight() {
        return canMoveRight;
    }
    
    /**
     * canMoveLeft
     * This method determines if the chicken can move left.
     * @return canMoveLeft A boolean that determines if the chicken can move left
     */
    public boolean canMoveLeft() {
        return canMoveLeft;
    }
    
    /**
     * isMoving
     * This method determines if the chicken is moving.
     * @return isMoving A boolean that determines if the chicken is moving
     */
    public boolean isMoving() {
        return isMoving;
    }
    
    /**
     * isDead
     * This method determines if the chicken is dead.
     * @return isDead A boolean that determines if the chicken is dead
     */
    public boolean isDead() {
        return isDead;
    }
    
    /**
     * isOnLog
     * This method determines if the chicken is on a log.
     * @return onLog A boolean that determines if the chicken is on a log
     */
    public boolean isOnLog() {
        return onLog;
    }
    
    /**
     * canMove
     * This method determines if the chicken can move.
     * @return A boolean that determines if the chicken can move
     */
    public boolean canMove() { 
        return canMoveLeft || canMoveRight;
    }
    
    /**
     * setCanMoveForward
     * This method sets that the chicken can move forward.
     */ 
    public void setCanMoveForward (boolean canMoveForward) {
        this.canMoveForward = canMoveForward;
    }
    
    /**
     * setCanMoveRight
     * This method sets that the chicken is able to move right.
     */ 
    public void setCanMoveRight(boolean canMoveRight) {
        this.canMoveRight = canMoveRight;
    }
    
    /**
     * setCanMoveLeft
     * This method sets that the chicken is able to move left.
     */ 
    public void setCanMoveLeft(boolean canMoveLeft) {
        this.canMoveLeft = canMoveLeft;
    }
    
    /**
     * setIsMoving
     * This method sets that the chicken is moving.
     */ 
    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
    
    /**
     * setIsDead
     * This method sets that the chicken is dead.
     */ 
    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }
    
    /**
     * setIsOnLog
     * This method sets that the chicken is on a log.
     */
    public void setIsOnLog(boolean onLog) {
        this.onLog = onLog;
    }
}