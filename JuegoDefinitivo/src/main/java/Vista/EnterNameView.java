package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.TypewriterSound;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;


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

        String string = "Welcome " + game.getPlayerName()+ "! Your rank is " + game.getRank() + ".\n" +
                "The " + game.getStolenItemName() + " has been stolen from " + game.getCityName() +
                ".\n" + game.getThiefGender() + " thief reported at the scene of the crime. You have until Sunday at 17:00hs to find the thief.";

        Timeline timeline =  new Timeline();

        TypewriterSound typewriterSound = new TypewriterSound();
        typewriterSound.play();

        for (char aux: string.toCharArray ()) {
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(delay), event -> name.setText(name.getText() + aux)));
            delay += 100;
        }

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(delay), event -> typewriterSound.pause()));
        timeline.play();
    }
}
