package Vista.Eventos;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import Vista.CityButtonsBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class TravelButtonEventHandler implements EventHandler<ActionEvent> {

    VBox screen, enterName;
    CityButtonsBox cityButtonsBox;
    Game game;

    public TravelButtonEventHandler(VBox screen, VBox enterName, CityButtonsBox cityButtonsBox, Game game){
        this.screen = screen;
        this.enterName = enterName;
        this.cityButtonsBox = cityButtonsBox;
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
        cityButtonsBox.show(travelCities);
        enterName.getChildren().addAll(cityButtonsBox.getHBox());
    }
}
