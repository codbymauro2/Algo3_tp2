package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnterAirportEventHandler implements EventHandler<ActionEvent>{

    private Game game;
    private Label clueLabel, time;

    public EnterAirportEventHandler(Game game, Label label, Label time){
        this.game = game;
        this.clueLabel = label;
        this.time = time;
    }

    @Override
    public void handle(ActionEvent event){
        this.clueLabel.setText(this.game.deployAirportClue());
        this.time.setText(game.time());
    }
}
