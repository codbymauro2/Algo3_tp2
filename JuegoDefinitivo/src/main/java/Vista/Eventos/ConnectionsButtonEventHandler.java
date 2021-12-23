package Vista.Eventos;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import java.util.ArrayList;
import java.util.Collection;

public class ConnectionsButtonEventHandler implements EventHandler<ActionEvent> {
    private Game game;
    private VBox screen;

    public ConnectionsButtonEventHandler(Game game, VBox screen) {
        this.game = game;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<City> travelCities = game.getTravelCities();
        screen.getChildren().clear();
        Label city1 = new Label(travelCities.get(0).getName());
        Label city2 = new Label(travelCities.get(1).getName());
        Label city3 = new Label(travelCities.get(2).getName());
        Label city4 = new Label(travelCities.get(3).getName());

        Image labelImage = new Image("images/planeAlgoThief.png");
        BackgroundImage labelBackgroundImage = new BackgroundImage(labelImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));

        city1.setBackground(new Background(labelBackgroundImage));
        city2.setBackground(new Background(labelBackgroundImage));
        city3.setBackground(new Background(labelBackgroundImage));
        city4.setBackground(new Background(labelBackgroundImage));


        Image image = new Image("images/CarmenMap.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        screen.setBackground(new Background(backgroundImage));

        travelCities.forEach(c -> {
            System.out.println(c.getName());
        });

        screen.getChildren().addAll(city1,city2,city3,city4);

    }
}
