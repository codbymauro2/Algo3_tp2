package Vista.Eventos;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.util.ArrayList;

public class ConnectionsButtonEventHandler implements EventHandler<ActionEvent> {
    private Game game;

    public ConnectionsButtonEventHandler(Game game) {
        this.game = game;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<City> travelCities = game.getTravelCities();
        travelCities.forEach(c -> {
            System.out.println(c.getName());
        });
    }
}
