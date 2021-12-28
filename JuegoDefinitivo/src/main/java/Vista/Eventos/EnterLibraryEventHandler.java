package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.DefeatContainer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class EnterLibraryEventHandler implements EventHandler<ActionEvent> {

    private Label clueLabel, time;
    private Game game;
    private Stage stage;

    public EnterLibraryEventHandler(Game game, Label label, Label time, Stage stage){
        this.clueLabel = label;
        this.game = game;
        this.time = time;
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent event) {
        this.clueLabel.setText(this.game.deployLibraryClue());
        if (game.isOutOfTime()) {
            game.stopMusic();
            String label = "Time's up " + game.getRank() + "! The thief has gotten away. Better luck next time. Are you ready for your next case?";
            DefeatContainer defeatContainer = new DefeatContainer(game, stage, label);
            Scene defeatScene = new Scene(defeatContainer,1180, 660);
            stage.setScene(defeatScene);
        } else {
            this.time.setText(game.time());
        }
    }
}
