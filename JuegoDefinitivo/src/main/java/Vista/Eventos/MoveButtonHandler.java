package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveButtonHandler implements EventHandler<ActionEvent> {

    private final GameView view;
    private final Game game;

    public MoveButtonHandler(GameView view, Game game) {
        this.view = view;
        this.game = game;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.view.update();
    }

}

