package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.InvestigateContainer;
import Vista.TravelContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InvestigateButtonEventHandler implements EventHandler<ActionEvent> {

    private Game game;
    private Stage stage;

    public InvestigateButtonEventHandler(Game game, Stage stage) {
        this.game = game;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        InvestigateContainer travelContainer = new InvestigateContainer(stage, game);
        Scene investigateScene = new Scene(travelContainer, 1180, 660);
        stage.setScene(investigateScene);
    }
}
