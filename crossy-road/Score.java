// Import classes
import java.awt.Color;
import java.awt.Graphics;

/** [Score.java]
  * Desc: The class that holds the score
  * @author Emily Xie
  * @version Jun 2022
  */

public class Score {
    // Variables
    private static int score = 0;
    
    /**
     * addScore
     * This method adds a point to the total score
     */
    public static void addScore() {
        score++;
    }
    
    /**
     * resetScore
     * This method resets the score to zero
     */
    public static void resetScore() {
        score = 0;
    }
    
    /**
     * drawScore
     * This method draws the score on the top right of the game screen
     */
    public static void drawScore(Graphics g) {
        g.setFont(Utility.FONT.deriveFont(40f));
        g.setColor(Color.black);
        String str = Integer.toString(score);
        g.drawString(str, Frame.WIDTH - (str.length() * 40), 50);
    }
    
    // Getters
    /**
     * getScore
     * This method gets the score
     * @return score An int of the score
     */
    public static int getScore() {
        return score;
    }
}