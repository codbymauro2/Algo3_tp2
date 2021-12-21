package Vista.Eventos;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.ArrayList;

public class TravelButtonEventHandler implements EventHandler<ActionEvent> {

    VBox screen, enterName;
    HBox citiesBox;
    Button city1, city2, city3,city4;
    Game game;

    public TravelButtonEventHandler(VBox screen, VBox enterName, HBox citiesBox, Button city1, Button city2, Button city3, Button city4, Game game){
        this.screen = screen;
        this.enterName = enterName;
        this.citiesBox = citiesBox;
        this.city1 = city1;
        this.city2 = city2;
        this.city3 = city3;
        this.city4 = city4;
        this.game = game;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        screen.getChildren().clear();
        Image image = new Image("CarmenMap.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        screen.setBackground(new Background(backgroundImage));
        enterName.getChildren().clear();
        ArrayList<City> travelCities = game.getTravelCities();
        city1.setText(travelCities.get(0).getName());
        city2.setText(travelCities.get(1).getName());
        city3.setText(travelCities.get(2).getName());
        city4.setText(travelCities.get(3).getName());
        citiesBox.getChildren().addAll(city1,city2,city3,city4 );
        enterName.getChildren().addAll(citiesBox);
    }
}
