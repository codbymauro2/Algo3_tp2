package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.DefeatContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class AttackedByKnifeEventHandler implements EventHandler<ActionEvent> {
    private Game game;
    private Stage stage;
    private Label time;

    public AttackedByKnifeEventHandler(Game game, Stage stage, Label time){
        this.game = game;
        this.stage = stage;
        this.time = time;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        game.knifeAttack();
        if (game.isOutOfTime()) {
            DefeatContainer defeatContainer = new DefeatContainer(game, stage);
            Scene defeatScene = new Scene(defeatContainer,1180, 660);
            stage.setScene(defeatScene);
        } else {
            this.time.setText(game.time());
        }
    }
}
