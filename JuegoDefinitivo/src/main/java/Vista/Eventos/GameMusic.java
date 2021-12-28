package Vista.Eventos;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class GameMusic {

    private URL url;
    private AudioInputStream audioInputStream;
    private Clip clip;

    public GameMusic() {

        url = this.getClass().getClassLoader().getResource("audio/gameSong.wav");

        try {
            audioInputStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.start();
    }

    public void pause() {
        clip.stop();
    }

}