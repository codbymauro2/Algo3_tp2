package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class EnterBankEventHandler implements EventHandler<ActionEvent> {

    private Game game;
    private Label clueLabel;

    public EnterBankEventHandler(Game game, Label label){
        this.game = game;
        this.clueLabel = label;
    }


    @Override
    public void handle(ActionEvent event){
        this.clueLabel.setText(this.game.deployBankClue());
    }

}
