package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class EnterBankEventHandler {

    private Game game;

    public EnterBankEventHandler(Game game){
        this.game = game;
    }


    @Override
    public void handle(ActionEvent event){
        Label clue = new Label(this.game.deployBankClue());
    }

}
