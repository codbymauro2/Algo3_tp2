package Vista;

import Modelo.MainObjects.Game;
import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javafx.scene.media.AudioClip;
import javafx.util.Duration;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.spi.AudioFileReader;


public class EnterNameView {

    private final VBox nameBox;
    private final Game game;
    private int delay;
    private char c;

    public EnterNameView(VBox nameBox, Game game) {
        this.nameBox = nameBox;
        this.game = game;
        this.delay = 500;
    }

    public void update() {
        nameBox.getChildren().remove(0);
        nameBox.getChildren().remove(0);

        Label name = (Label) nameBox.getChildren().get(0);

        String string = "Welcome " + game.getPlayerName()+ "! Your rank is " + game.getRank() + ". " + "The " + game.getStolenItemName() + " has been stolen from " + game.getCityName() + ".\n" + game.getThiefGender() + " suspect reported at the scene of the crime.";

        Timeline timeline =  new Timeline();
        for (char aux: string.toCharArray ()) {
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(delay), event -> name.setText(name.getText() + aux)));
            delay += 100;
        }
        timeline.play();
    }
}
