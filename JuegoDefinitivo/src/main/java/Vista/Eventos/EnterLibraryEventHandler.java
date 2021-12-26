package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class EnterLibraryEventHandler implements EventHandler<ActionEvent> {

    private Label clueLabel, time;
    private Game game;

    public EnterLibraryEventHandler(Game game, Label label, Label time){
        this.clueLabel = label;
        this.game = game;
        this.time = time;
    }


    @Override
    public void handle(ActionEvent event) {
        this.clueLabel.setText(this.game.deployLibraryClue());
        this.time.setText(game.time());
    }
}
