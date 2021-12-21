package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;;


public class EnterNameEventHandler implements EventHandler<ActionEvent> {

    private GameView gameView;
    private Game game;
    private TextField playerName;
    private Label recognizedPlayer;


    public EnterNameEventHandler(GameView gameView, Game game, TextField playerTextField, Label recognizedPlayerMessage){
        this.gameView = gameView;
        this.game = game;
        this.playerName = playerTextField;
        this.recognizedPlayer = recognizedPlayerMessage;
    }


    @Override
    public void handle(ActionEvent event) {
        game.setPlayer(playerName.getText());
        game.initializeCase();
        String message = "Hola " + game.getPlayerName() + ", han robado el " + game.getStolenItemName() + ",y tu mision es recuperarlo";
        recognizedPlayer.setText(message);
    }
}
