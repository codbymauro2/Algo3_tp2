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
    private VBox showCities;

    public ConnectionsButtonEventHandler(Game game, Stage stage, VBox showCities) {
        this.game = game;
        this.stage = stage;
        this.showCities = showCities;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<City> citiesToShow = game.getTravelCities();
        HBox left = (HBox) showCities.getChildren().get(0);
        HBox right = (HBox) showCities.getChildren().get(1);

        left.getChildren().clear();
        right.getChildren().clear();

        left.getStyleClass().add("show-cities-box");
        right.getStyleClass().add("show-cities-box");

        Label city0 = new Label(citiesToShow.get(0).getName());
        Label city1 = new Label(citiesToShow.get(1).getName());
        Label city2 = new Label(citiesToShow.get(2).getName());
        Label city3 = new Label(citiesToShow.get(3).getName());

        city0.getStyleClass().add("cities-label");
        city1.getStyleClass().add("cities-label");
        city2.getStyleClass().add("cities-label");
        city3.getStyleClass().add("cities-label");

        left.getChildren().addAll(city0, city1);
        right.getChildren().addAll(city2, city3);
    }
}
