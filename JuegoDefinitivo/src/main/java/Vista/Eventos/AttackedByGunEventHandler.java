package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.DefeatContainer;
import Vista.VictoryContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class AttackedByGunEventHandler implements EventHandler<ActionEvent> {
    private Game game;
    private Stage stage;

    public AttackedByGunEventHandler(Game game, Stage stage) {
        this.game = game;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        game.gunAttack();
        if (game.end()){
            VictoryContainer victoryContainer = new VictoryContainer(game, stage);
        } else {
            DefeatContainer defeatContainer = new DefeatContainer(game, stage);
        }
    }
}
