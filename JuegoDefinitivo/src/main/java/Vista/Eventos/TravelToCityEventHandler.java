package Vista.Eventos;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import Vista.PrincipalContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TravelToCityEventHandler implements EventHandler<ActionEvent> {

    private City travelCity;
    private Game game;
    private Stage stage;

    public TravelToCityEventHandler(Game game, Stage stage, City travelCity){
        this.travelCity = travelCity;
        this.game = game;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        game.travel(travelCity);
        PrincipalContainer principalContainer = new PrincipalContainer(stage, game);
        principalContainer.getStylesheets().add(getClass().getResource("/stylesheets/gameScene.css").toExternalForm());
        Scene gameScene = new Scene(principalContainer, 1180, 660);
        stage.setScene(gameScene);
    }

}