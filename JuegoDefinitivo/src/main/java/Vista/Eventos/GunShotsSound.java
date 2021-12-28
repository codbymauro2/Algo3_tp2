package Vista.Eventos;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class GunShotsSound {

    private URL url;
    private AudioInputStream audioInputStream;
    private Clip clip;

    public GunShotsSound() {

        url = this.getClass().getClassLoader().getResource("audio/gunShot.wav");

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
