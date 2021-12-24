package Vista.Eventos;

import Modelo.MainObjects.Game;
import Modelo.MainObjects.City;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        ArrayList<City> travelCities = game.getTravelCities();

        Label city1 = new Label(travelCities.get(0).getName());
        Label city2 = new Label(travelCities.get(1).getName());
        Label city3 = new Label(travelCities.get(2).getName());
        Label city4 = new Label(travelCities.get(3).getName());

        Image image = new Image("images/CarmenMap.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
//          screen.setBackground(new Background(backgroundImage));


    }
}
