// Import classes
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/** [Frame.java]
  * Desc: The class for the frame holding the game elements
  * @author Emily Xie
  * @version Jun 2022
  */

public class Frame extends JFrame {
    // Variables
    public static final int WIDTH = 600, HEIGHT = 600, SQUARE = 64;
    public static Container container;
    public static CardLayout layout;
    
    /**
     * Frame
     * This constructor creates a new Frame object.
     */
    public Frame() {
        container = getContentPane();
        layout = new CardLayout();
        container.setLayout(layout);
        
        setTitle("Crossy Road");
        setSize(WIDTH, HEIGHT); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
}