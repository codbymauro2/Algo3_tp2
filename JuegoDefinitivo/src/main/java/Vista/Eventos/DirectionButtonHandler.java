package Vista.Eventos;

import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DirectionButtonHandler implements EventHandler<ActionEvent> {

    private final Game game;

    public DirectionButtonHandler(Game game) {
        this.game = game;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    }


}
