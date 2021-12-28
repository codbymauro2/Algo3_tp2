package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.DefeatContainer;
import Vista.VictoryContainer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
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

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(20000), event1 ->  eventLabel.setText("CONGRATULATIONS! YOU HAVE CATCHED THE THIEF AND RETURNED WHAT HAD BEEN STOLEN!"))
            );
            timeline.play();

            VictoryContainer victoryContainer = null;
            try {
                victoryContainer = new VictoryContainer(game, stage);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene victoryScene = new Scene(victoryContainer,1180, 660);
            stage.setScene(victoryScene);
        } else {
            DefeatContainer defeatContainer = new DefeatContainer(game, stage);
            Scene defeatScene = new Scene(defeatContainer,1180, 660);
            stage.setScene(defeatScene);
        }
    }
}
