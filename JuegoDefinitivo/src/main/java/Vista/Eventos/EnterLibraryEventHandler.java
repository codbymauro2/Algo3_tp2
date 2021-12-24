package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class EnterLibraryEventHandler {

    private Game game;

    public EnterLibraryEventHandler(Game game){
        this.game = game;
    }


    @Override
    public void handle(ActionEvent event){
        Label clue = new Label(this.game.deployLibraryClue());
    }
}
