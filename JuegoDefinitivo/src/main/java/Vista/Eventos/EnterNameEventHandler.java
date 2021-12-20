package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class EnterNameEventHandler implements EventHandler<ActionEvent> {

    private GameView gameView;
    private Game game;
    private TextField playerName;


    public EnterNameEventHandler(GameView gameView, Game game, TextField playerTextField){
        this.gameView = gameView;
        this.game = game;
        this.playerName = playerTextField;
    }


    @Override
    public void handle(ActionEvent event) {
        game.setPlayerName(playerName.getText());
    }
}
