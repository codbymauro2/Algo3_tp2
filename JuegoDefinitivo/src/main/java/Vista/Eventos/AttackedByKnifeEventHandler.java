package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.DefeatContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.concurrent.TimeUnit;

public class AttackedByKnifeEventHandler implements EventHandler<ActionEvent> {
    private Game game;
    private Stage stage;
    private Label time, eventLabel;

    public AttackedByKnifeEventHandler(Game game, Stage stage, Label time, Label eventLabel){
        this.game = game;
        this.stage = stage;
        this.time = time;
        this.eventLabel = eventLabel;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        game.knifeAttack();
        String outOfTimeLabel;
        if (game.isOutOfTime()) {
            game.stopMusic();
            String label = "Time's up " + game.getRank() + "! The thief has gotten away. Better luck next time. Are you ready for your next case?";
            DefeatContainer defeatContainer = new DefeatContainer(game, stage, label);
            Scene defeatScene = new Scene(defeatContainer,1180, 660);
            outOfTimeLabel = "Oh no! The thief has stabbed you and you couldn't get him in time!";
            this.eventLabel.setText(outOfTimeLabel);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stage.setScene(defeatScene);
        } else {
            this.time.setText(game.time());
            outOfTimeLabel = "Oh no! Someone has stabbed you, you should rest before getting back to your investigation!";
            this.eventLabel.setText(outOfTimeLabel);
        }
    }
}
