package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EnterAirportEventHandler {

    private Game game;

    public EnterAirportEventHandler(Game game){
        this.game = game;

    }
/*
    @Override
    public void handle(ActionEvent event){
        Label clue = new Label(this.game.deployAirportClue());
    }*/
}
