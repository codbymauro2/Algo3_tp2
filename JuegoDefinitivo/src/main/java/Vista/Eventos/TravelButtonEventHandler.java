package Vista.Eventos;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class TravelButtonEventHandler implements EventHandler<ActionEvent> {

    VBox screen, enterName;
    HBox citiesBox;
    Game game;

    public TravelButtonEventHandler(VBox screen, VBox enterName, HBox citiesBox, Game game){
        this.screen = screen;
        this.enterName = enterName;
        this.citiesBox = citiesBox;
        this.game = game;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        screen.getChildren().clear();
        Image image = new Image("images/CarmenMap.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        screen.setBackground(new Background(backgroundImage));
        enterName.getChildren().clear();
        ArrayList<City> travelCities = game.getTravelCities();


        citiesBox.getChildren().forEach(c -> {
            c.setVisible(true);
            c.setDisable(false);
        });

        enterName.getChildren().addAll(citiesBox);
    }
}
