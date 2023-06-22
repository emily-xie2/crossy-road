// Import classes
import javax.swing.ImageIcon;

/** [Main.java]
  * Desc: The main class
  * @author Emily Xie
  * @version Jun 2022
  */

public class Main {
    // Static menu to show score
    public static GameOverMenu gameoverMenu = new GameOverMenu(); 
    
    public static void main(String[] args) {
        Frame frame = new Frame();
        StartMenu startMenu = new StartMenu();
        InstructionMenu instructionMenu = new InstructionMenu();
        Chicken chicken = new Chicken((Frame.WIDTH/2)-40, Frame.SQUARE / 4);
        LandGenerator landGenerator = new LandGenerator();
        GamePanel gamePanel = new GamePanel(chicken, landGenerator);
        
        // Add all of the panels to the game
        Frame.container.add(startMenu, "startmenu");
        Frame.container.add(instructionMenu, "instructionmenu");
        Frame.container.add(gamePanel, "gamepanel");
        Frame.container.add(gameoverMenu, "gameovermenu");
        
        frame.setVisible(true);
    }
}