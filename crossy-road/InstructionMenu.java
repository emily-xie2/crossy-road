// Import classes
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** [InstructionMenu.java]
  * Desc: The menu that displays the game instructions
  * @author Emily Xie
  * @version Jun 2022
  */

public class InstructionMenu extends JPanel implements ActionListener {
    // Variables
    private JLabel title, keyText1, keyText2, keyText3, obstacleText;
    private JButton mainButton;
    
    public InstructionMenu() {
        this.setBackground(Utility.BACKGROUND);
        title = new JLabel();
        keyText1 = new JLabel();
        keyText2 = new JLabel();
        keyText3 = new JLabel();
        obstacleText = new JLabel();
        
        // Instructions text
        keyText1.setText("Press S to move down.");
        keyText2.setText("Press A to move left.");
        keyText3.setText("Press D to move right.");
        obstacleText.setText("Avoid obstacles to not die.");
        
        // Instructions locations
        keyText1.setLocation(10, 100);
        keyText1.setSize(5000, 50);
        keyText1.setFont(Utility.FONT);
        
        keyText2.setLocation(10, 150);
        keyText2.setSize(5000, 50);
        keyText2.setFont(Utility.FONT);
        
        keyText3.setLocation(10, 200);
        keyText3.setSize(5000, 50);
        keyText3.setFont(Utility.FONT);
        
        obstacleText.setLocation(10, 250);
        obstacleText.setSize(5000, 50);
        obstacleText.setFont(Utility.FONT);
        
        // Title
        title.setText("Instructions");
        title.setLocation(140, 10);
        title.setSize(500, 100);
        title.setFont((Utility.FONT).deriveFont(38f));
        
        // Starter menu button
        mainButton = new JButton();
        mainButton.setBounds(210, 370, 150, 75);
        mainButton.addActionListener(this);
        mainButton.setText("MAIN MENU");
        mainButton.setFont(Utility.FONT);
        mainButton.setBackground(Color.white);
        
        // Add all the components together
        this.add(title);
        this.add(keyText1);
        this.add(keyText2);
        this.add(keyText3);
        this.add(obstacleText);
        this.add(mainButton);
        
        this.setLayout(null);
        repaint();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainButton) {
            // Go back to the main menu
            Frame.layout.show(Frame.container, "startmenu");
        }
    }
}