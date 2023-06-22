// Import classes
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/** [TrainTrack.java]
  * Desc: The class of the cars
  * @author Emily Xie
  * @version Jun 2022
  */

public class TrainTrack extends Land {
    
    /**
     * TrainTrack
     * This constructor creates a new TrainTrack object
     * @param color An object of the color of the train track
     * @param pos An int of the position of the train track
     */
    public TrainTrack(Color color, int pos) {
        // Color color, int pos, String type
        super(color, pos, "TrainTrack"); 
        // Create a new train
        Train train = new Train(getPos() * Frame.SQUARE); 
        objects.add(train);
    }
    
    public void draw(Graphics g) {
        super.draw(g);
        
        // Draw the train tracks
        for (int i = 0; i < Frame.WIDTH; i += Frame.SQUARE) {
            g.drawImage((new ImageIcon("images/traintrack.png")).getImage(), i,getPos() * Frame.SQUARE, null);
        }
        updateObjectPos();
        
        // Draw the train
        for (int e = 0; e < objects.size(); e++) {
            ((Train) objects.get(e)).moveVehicle();
            (objects.get(e)).draw(g);
            
            // Check if the train is out of the frame and remove when it is
            if ((objects.get(e)).getX() > Frame.WIDTH || (objects.get(e)).getX() + (objects.get(e)).getWidth()  < 0) {
                objects.remove(0); 
                objects.add(new Train(getPos() * Frame.SQUARE));
            }
        }
    }
}