package Vista;

import Modelo.MainObjects.Game;
import javafx.animation.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class EnterNameView {

    private final VBox nameBox;
    private final Game game;


    public EnterNameView(VBox nameBox, Game game) {
        this.nameBox = nameBox;
        this.game = game;
    }

    public void update() {
        nameBox.getChildren().remove(0);
        nameBox.getChildren().remove(0);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(500), event -> ((TextField) nameBox.getChildren().get(0)).setText("Welcome ")),
                new KeyFrame(Duration.millis(1000), event -> ((TextField) nameBox.getChildren().get(0)).appendText(game.getPlayerName() + " ")),
                new KeyFrame(Duration.millis(1500), event -> ((TextField) nameBox.getChildren().get(0)).appendText(game.getRank() + " ")),
                new KeyFrame(Duration.millis(2000), event -> ((TextField) nameBox.getChildren().get(1)).appendText("The treasure ")),
                new KeyFrame(Duration.millis(2500), event -> ((TextField) nameBox.getChildren().get(1)).appendText("has been identified ")),
                new KeyFrame(Duration.millis(3000), event -> ((TextField) nameBox.getChildren().get(1)).appendText(game.getStolenItemName())),
                new KeyFrame(Duration.millis(3500), event -> ((TextField) nameBox.getChildren().get(2)).appendText(game.getThiefGender() + " suspect reported ")),
                new KeyFrame(Duration.millis(4000), event -> ((TextField) nameBox.getChildren().get(2)).appendText("from " + game.getCityName()))
        );
        timeline.play();
    }
}
