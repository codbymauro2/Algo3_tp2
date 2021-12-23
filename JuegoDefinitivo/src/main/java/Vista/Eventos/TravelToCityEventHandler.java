package Vista.Eventos;

import Modelo.MainObjects.City;
import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TravelToCityEventHandler implements EventHandler<ActionEvent> {
    private Game game;
    private City city;
    private VBox timeVBox, screen;

    public TravelToCityEventHandler(Game game, City city, VBox timeVBox, VBox screen){
        this.game = game;
        this.city = city;
        this.timeVBox = timeVBox;
        this.screen = screen;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        screen.getChildren().clear();
        game.travel(city);
        Label textTime = new Label(game.time());
        Label textSpace = new Label(game.getCityName());
        timeVBox.getChildren().addAll(textSpace, textTime);
    }


}
