package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.WarrantContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmitWarrantEventHandler implements EventHandler<ActionEvent> {

    private Game game;
    private Stage stage;

    public EmitWarrantEventHandler(Game game, Stage stage){

        this.game = game;
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        WarrantContainer warrantContainer = new WarrantContainer(stage, game);
        Scene warrantScene = new Scene(warrantContainer, 1180, 660);
        warrantScene.getStylesheets().add(getClass().getResource("/stylesheets/gameScene.css").toExternalForm());
        stage.setScene(warrantScene);
        //System.out.println(game.getThief());
    }
}
