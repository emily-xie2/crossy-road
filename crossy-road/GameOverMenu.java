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

/** [GameOverMenu.java]
  * Desc: The menu that is displayed after the player dies
  * @author Emily Xie
  * @version Jun 2022
  */

public class GameOverMenu extends JPanel implements ActionListener {
    // Variables
    private JButton againButton, exitButton, mainButton;
    private JLabel score;
    private ImageIcon gameover;
    private final ImageIcon GAME_OVER = new ImageIcon("images/gameover.png");
    
    public GameOverMenu() {
        this.setBackground(Utility.BACKGROUND);
        againButton = new JButton();
        mainButton = new JButton();
        exitButton = new JButton();
        score = new JLabel();
        
        // Play again button
        againButton.setBounds(50, 350, 150, 75);
        againButton.addActionListener(this);
        againButton.setText("TRY AGAIN");
        againButton.setFont(Utility.FONT);
        againButton.setBackground(Color.white);
        
        // Starter menu button
        mainButton.setBounds(220, 350, 150, 75);
        mainButton.addActionListener(this);
        mainButton.setText("MAIN MENU");
        mainButton.setFont(Utility.FONT);
        mainButton.setBackground(Color.white);
        
        // Exits button
        exitButton.setBounds(390, 350, 150, 75);
        exitButton.addActionListener(this);
        exitButton.setText("EXIT GAME");
        exitButton.setFont(Utility.FONT);
        exitButton.setBackground(Color.white);
        
        // Score label
        score.setLocation(250, 230);
        score.setSize(300, 100);
        score.setFont(Utility.FONT);
        score.setForeground(Color.black);
        
        // Add all the components together
        this.add(againButton);
        this.add(mainButton);
        this.add(exitButton);
        this.add(score);
        this.setLayout(null);
        repaint();
        this.setVisible(true);
    }
    
    /**
     * displayScore
     * This method display the final score on the screen.
     */
    public void displayScore(int finalScore) {
        score.setText("Score: " + finalScore);
    }
    
    public void actionPerformed(ActionEvent e) {
        // Depending on the button clicked, implement the action pertained to it
        if (e.getSource() == againButton) { 
            Frame.layout.show(Frame.container, "gamepanel");
        } else if (e.getSource() == mainButton) { 
            Frame.layout.show(Frame.container, "startmenu");
        } else if (e.getSource() == exitButton) { 
            System.exit(0);
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Paint the gameover image
        g.drawImage(GAME_OVER.getImage(), 90, -50, 400, 400, null);
    }
}