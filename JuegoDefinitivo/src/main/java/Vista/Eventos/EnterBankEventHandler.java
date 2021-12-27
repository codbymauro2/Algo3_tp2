package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.DefeatContainer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


public class EnterBankEventHandler implements EventHandler<ActionEvent> {

    private Game game;
    private Label clueLabel, time;
    private Stage stage;

    public EnterBankEventHandler(Game game, Label label, Label time, Stage stage){
        this.game = game;
        this.clueLabel = label;
        this.time = time;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        this.clueLabel.setText(this.game.deployBankClue());
        if (game.isOutOfTime()) {
            DefeatContainer defeatContainer = new DefeatContainer(game, stage);
            Scene defeatScene = new Scene(defeatContainer,1180, 660);
            stage.setScene(defeatScene);
        } else {
            this.time.setText(game.time());
        }

    }
}
