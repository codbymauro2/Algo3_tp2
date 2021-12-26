package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class EnterFinalBankEventHandler implements EventHandler<ActionEvent> {

    private Game game;
    private Label clueLabel,label;

    public EnterFinalBankEventHandler(Game game, Label clueLabel, Label textTime) {
        this.game = game;
        this.clueLabel = clueLabel;
        this.label = textTime;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
