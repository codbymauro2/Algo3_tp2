package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class EnterLibraryEventHandler implements EventHandler<ActionEvent> {

    private final Label clueLabel;
    private Game game;

    public EnterLibraryEventHandler(Game game, Label label){
        this.clueLabel = label;
        this.game = game;
    }


    @Override
    public void handle(ActionEvent event){
        this.clueLabel.setText(this.game.deployLibraryClue());
    }
}
