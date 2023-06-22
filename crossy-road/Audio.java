// Import classes
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineListener;
// Possible exceptions
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;


/** [Audio.java]
  * Desc: The class that loads and plays audio
  * @author Emily Xie
  * @version Jun 2022
  */

public class Audio {
    // Audio file
    public static Audio lobby = new Audio("audio/lobbymusic.wav");

    Clip audio;
    Audio (String audioName){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(audioName));
            this.audio = AudioSystem.getClip();
            this.audio.open(audioStream);
        } 
        catch (IOException ex){
            System.out.println("File not found!");
        }
        catch (UnsupportedAudioFileException ex){
            System.out.println("Unsupported file!");
        }   
        catch (LineUnavailableException ex){
            System.out.println("Audio feed already in use!");
        }
    }
    
    // Audio methods
    public void start(){
        this.audio.start();
    }
    public void loop(){
        this.audio.loop(Clip.LOOP_CONTINUOUSLY); 
    }
}