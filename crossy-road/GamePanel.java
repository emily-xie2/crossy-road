// Import classes
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

/** [GamePanel.java]
  * Desc: The class of the game elements
  * @author Emily Xie
  * @version Jun 2022
  */

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    // Variables
    private Chicken chicken;
    private LandGenerator landGenerator;
    private Timer timer;
    
    /**
     * GamePanel
     * This constructor creates a new GamePanel object.
     * @param chicken A chicken object
     * @param landGenerator A land generator object
     */
    public GamePanel(Chicken chicken, LandGenerator landGenerator) {
        setBackground(Color.white); 
        this.chicken = chicken;
        this.landGenerator = landGenerator;
        timer = new Timer(7, this);
        timer.addActionListener(this);
        timer.start();
        addKeyListener(this); 
        setFocusable(true);
        this.requestFocusInWindow(); 
    }
    
    public void keyTyped(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e) {}
    
    public void keyReleased(KeyEvent e) {
        // Check if the S key was pressed
        if(e.getKeyCode() == KeyEvent.VK_S) {
            if (chicken.isCanMoveForward()) {
                // Reset that the chicken is not on a log
                chicken.setIsOnLog(false);
                // Add a point to the score
                Score.addScore(); 
                // Move the land once
                landGenerator.setIsMoving(true);
            }
        }
        
        // Check if the A key was pressed
        if(e.getKeyCode() == KeyEvent.VK_A) {
            if (chicken.canMoveLeft()) { 
                chicken.moveLeft(); 
                chicken.setIsMoving(true);
            }
        }
        
        // Check if the D key was pressed
        if (e.getKeyCode() == KeyEvent.VK_D) {
            if (chicken.canMoveRight()) {
                chicken.moveRight(); 
                chicken.setIsMoving(true);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            Land standingLand = landGenerator.getLands().get(3); 
            Land nextLand = landGenerator.getLands().get(4);

            // Check if the chicken is on the river
            if (standingLand.type.equals("River")) {
                // Move the chicken differently if it is on a log
                chicken.moveWithLog(standingLand.getObjects()); 
            } else {
                chicken.setIsOnLog(false);
                if (!chicken.isMoving()) {
                    for (int i = 0; i < (standingLand.getObjects()).size(); i++) {
                        // Set the chicken position to the nearest square without an object
                        if (getClosestSquare(chicken.getX(), false) == ((standingLand.getObjects()).get(i)).getX()) { 
                            chicken.setX(getClosestSquare(chicken.getX(), true)); 
                        } else {
                            chicken.setX(getClosestSquare(chicken.getX(), false));
                        }
                    }
                }
                chicken.handleXCollision(standingLand);
             }
            chicken.handleYCollision(nextLand);


            // Chicken has died
            if (chicken.isDead()) {
                Main.gameoverMenu.displayScore(Score.getScore());
                Frame.layout.show(Frame.container, "gameovermenu");

                chicken = new Chicken((Frame.WIDTH/2)-40, Frame.SQUARE / 4); 
                landGenerator = new LandGenerator(); 
                Score.resetScore(); 
            }

            // Chicken has left the screen
            if (chicken.getX() < 0 || chicken.getX() + Frame.SQUARE / 2 > Frame.WIDTH) {
                chicken.setIsDead(true);
            }

            // Move the chicken
            if (chicken.canMove()) {
                if (chicken.chickenMoved())
                    chicken.setIsMoving(false);
            }
            repaint();
            requestFocusInWindow();
        }
    }
    
    /**
     * getClosestSquare
     * This method gets the x-value of the closest square to the chicken.
     * @param x An int of the x-value
     * @param isOccupied A boolean that determines if the square is occupied or not
     * @return max or min depending on whichever square is closest, max if the square is occupied
     */
    public static int getClosestSquare(int x, boolean isOccupied) {
        int min = (x / Frame.SQUARE) * Frame.SQUARE; 
        int max = min + Frame.SQUARE;
        
        if(isOccupied) { 
            return max;
        }
        
        // Check for the closest square
        if(min + (Frame.SQUARE / 2) >= x) { 
            return min;
        } else {
            return max;
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (landGenerator.isMoving()) {
            landGenerator.moveLand();
        }
        // The land can only move once
        landGenerator.setIsMoving(false); 
        // Draw the components of the screen
        landGenerator.draw(g); 
        chicken.draw(g); 
        Score.drawScore(g);
    }
}