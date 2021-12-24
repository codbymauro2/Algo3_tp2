package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.TravelContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TravelButtonEventHandler implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final Game game;

    public TravelButtonEventHandler(Game game, Stage stage){
        this.stage = stage;
        this.game = game;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TravelContainer travelContainer = new TravelContainer(stage, game);
        Scene travelScene = new Scene(travelContainer, 1180, 660);
        travelScene.getStylesheets().add(getClass().getResource("/stylesheets/travelScene.css").toExternalForm());

        stage.setScene(travelScene);
    }
}
