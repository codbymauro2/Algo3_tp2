package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.DefeatContainer;
import Vista.VictoryContainer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent

        ;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AttackedByGunEventHandler implements EventHandler<ActionEvent> {
    private Label eventLabel;
    private Game game;
    private Stage stage;

    public AttackedByGunEventHandler(Game game, Stage stage, Label eventLabel) {
        this.game = game;
        this.stage = stage;
        this.eventLabel = eventLabel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        game.gunAttack();
        if (game.end()) {
            try {
                game.updatePlayers();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            eventLabel.setText("Oh no, you've been shot, and it seems to have been by " + game.getThief().getName() + "! Quick, arrest him before he gets away!");

            VictoryContainer victoryContainer = null;
            victoryContainer = new VictoryContainer(game, stage);

            Scene victoryScene = new Scene(victoryContainer,1180, 660);
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(5000), event1 -> stage.setScene(victoryScene))
            );
            timeline.play();

        } else {
            String label = "You didn't have a warrant and the thief got away. Better luck next time. Are you ready for your next case?";
            DefeatContainer defeatContainer = new DefeatContainer(game, stage, label);
            Scene defeatScene = new Scene(defeatContainer,1180, 660);
            stage.setScene(defeatScene);
        }
    }
}
