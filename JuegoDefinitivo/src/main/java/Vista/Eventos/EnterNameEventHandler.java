package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;;


public class EnterNameEventHandler implements EventHandler<ActionEvent> {

    private Game game;
    private TextField playerName;
    private Label recognizedPlayer, thiefInformation;


    public EnterNameEventHandler( Game game, TextField playerTextField, Label recognizedPlayerMessage, Label thiefInformation){
        this.game = game;
        this.playerName = playerTextField;
        this.recognizedPlayer = recognizedPlayerMessage;
        this.thiefInformation = thiefInformation;
    }


    @Override
    public void handle(ActionEvent event) {
        game.setPlayer(playerName.getText());
        game.initializeCase();
        String playerMessage = "Hola " + game.getPlayerName() + ", han robado el " + game.getStolenItemName() + ",y tu mision es recuperarlo";
        recognizedPlayer.setText(playerMessage);
        String thiefInfoMessage = "El sospechoso en la escena del crimen fue reconocido como un " + game.getThiefGender();
        thiefInformation.setText(thiefInfoMessage);
    }
}
