package Vista.Eventos;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import Vista.CityButtonsBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class TravelButtonEventHandler implements EventHandler<ActionEvent> {
    VBox enterName;
    VBox screen, timeVBox;
    CityButtonsBox cityButtonsBox;
    Game game;

    public TravelButtonEventHandler(VBox enterName, VBox screen, VBox timeVBox, Game game){
        this.enterName = enterName;
        this.screen = screen;
        this.timeVBox = timeVBox;
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
        CityButtonsBox cityButtonsBox = new CityButtonsBox(game);

        Button cityToChoose1 = new Button();
        Button cityToChoose2 = new Button();
        Button cityToChoose3 = new Button();
        Button cityToChoose4 = new Button();

        TravelToCityEventHandler travelToCity1EventHandler = new TravelToCityEventHandler(game, travelCities.get(0), timeVBox, screen);
        TravelToCityEventHandler travelToCity2EventHandler = new TravelToCityEventHandler(game, travelCities.get(1), timeVBox, screen);
        TravelToCityEventHandler travelToCity3EventHandler = new TravelToCityEventHandler(game, travelCities.get(2), timeVBox, screen);
        TravelToCityEventHandler travelToCity4EventHandler = new TravelToCityEventHandler(game, travelCities.get(3), timeVBox, screen);

        cityToChoose1.setOnAction(travelToCity1EventHandler);
        cityToChoose2.setOnAction(travelToCity2EventHandler);
        cityToChoose3.setOnAction(travelToCity3EventHandler);
        cityToChoose4.setOnAction(travelToCity4EventHandler);

        cityButtonsBox.addCities(cityToChoose1, cityToChoose2, cityToChoose3, cityToChoose4);
        cityButtonsBox.show(travelCities);

        enterName.getChildren().addAll(cityButtonsBox.getVBox());
    }

    }
