package Vista;

import Modelo.MainObjects.Game;
import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javafx.scene.media.AudioClip;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.spi.AudioFileReader;
import java.nio.file.Paths;


public class EnterNameView {

    private final VBox nameBox;
    private final Game game;
    private int delay;
    private char c;
    private AudioClip audioClip;

    public EnterNameView(VBox nameBox, Game game) {
        this.nameBox = nameBox;
        this.game = game;
        this.delay = 500;
        audioClip = new AudioClip(Paths.get("/audio/audio.mpeg").toUri().toString());
    }

    public void update() {
        nameBox.getChildren().remove(0);
        nameBox.getChildren().remove(0);

        Label name = (Label) nameBox.getChildren().get(0);

        String string = "Welcome " + game.getPlayerName()+ "! Your rank is " + game.getRank() + ".\n " +
                "The " + game.getStolenItemName() + " has been stolen from " + game.getCityName() +
                ".\n" + game.getThiefGender() + " suspect reported at the scene of the crime. You have until Sunday at 17:00hs to find the suspect.";

        Timeline timeline =  new Timeline();
        for (char aux: string.toCharArray ()) {
            audioClip.play();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(delay), event -> name.setText(name.getText() + aux)));
            delay += 100;
        }
        timeline.play();
    }
}
