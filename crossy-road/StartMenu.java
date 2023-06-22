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
import javax.sound.sampled.Clip;
import java.awt.CardLayout;

/** [StartMenu.java]
  * Desc: The menu that is first displayed when game is run
  * @author Emily Xie
  * @version Jun 2022
  */

public class StartMenu extends JPanel implements ActionListener {
    // Variables
    private JButton playButton, instructionsButton, exitButton;
    private JLabel title;
    private final ImageIcon LOGO = new ImageIcon("images/logo.png");

    /**
     * StartMenu
     * This constructor creates a new StartMenu object
     */
    public StartMenu() {
        this.setBackground(Utility.BACKGROUND);
        Audio.lobby.start();
        Audio.lobby.loop();
        
        // Play game button
        playButton = new JButton();
        playButton.setBounds(50, 370, 120, 75);
        playButton.addActionListener(this);
        playButton.setText("PLAY GAME");
        playButton.setFont(Utility.FONT);
        playButton.setBackground(Color.white);
        
        // Instruction menu button
        instructionsButton = new JButton();
        instructionsButton.setBounds(210, 370, 150, 75);
        instructionsButton.addActionListener(this);
        instructionsButton.setText("HOW TO PLAY");
        instructionsButton.setFont(Utility.FONT);
        instructionsButton.setBackground(Color.white);
        
        // Exit button
        exitButton = new JButton();
        exitButton.setBounds(400, 370, 120, 75);
        exitButton.addActionListener(this);
        exitButton.setText("EXIT GAME");
        exitButton.setFont(Utility.FONT);
        exitButton.setBackground(Color.white);
        
        // Add all the components together
        this.add(playButton);
        this.add(instructionsButton);
        this.add(exitButton);
        
        this.setLayout(null);
        repaint();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        // Depending on the button clicked, implement the action pertained to it
        if (e.getSource() == playButton) {
            Frame.layout.show(Frame.container, "gamepanel");
        } else if (e.getSource() == instructionsButton) {
            Frame.layout.show(Frame.container, "instructionmenu");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw chicken image
        g.drawImage(LOGO.getImage(), 120, 70, 350, 250, null);
    }
}