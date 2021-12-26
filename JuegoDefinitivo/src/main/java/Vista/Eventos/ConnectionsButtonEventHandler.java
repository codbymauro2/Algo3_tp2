package Vista.Eventos;

import Modelo.MainObjects.Game;
import Modelo.MainObjects.City;
import Vista.ConnectionsContainer;
import Vista.TravelContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.scene.image.Image;


public class ConnectionsButtonEventHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private Game game;

    public ConnectionsButtonEventHandler(Game game, Stage stage) {
        this.game = game;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ConnectionsContainer connectionsContainer = new ConnectionsContainer(stage, game);
        Scene connectionsScene = new Scene(connectionsContainer, 1180, 660);
        connectionsScene.getStylesheets().add(getClass().getResource("/stylesheets/gameScene.css").toExternalForm());

        stage.setScene(connectionsScene);
    }
}
