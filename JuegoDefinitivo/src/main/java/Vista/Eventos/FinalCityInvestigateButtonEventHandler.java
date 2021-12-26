package Vista.Eventos;

import Vista.FinalCityContainer;
import Vista.FinalInvestigateContainer;
import Vista.InvestigateContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import Modelo.MainObjects.Game;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinalCityInvestigateButtonEventHandler implements EventHandler<ActionEvent> {
    private Game game;
    private Stage stage;

    public FinalCityInvestigateButtonEventHandler(Game game, Stage stage) {
        this.game = game;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        FinalInvestigateContainer finalInvestigateContainer = new FinalInvestigateContainer(stage, game);
        finalInvestigateContainer.getStylesheets().add(getClass().getResource("/stylesheets/gameScene.css").toExternalForm());
        Scene investigateScene = new Scene(finalInvestigateContainer, 1180, 660);
        stage.setScene(investigateScene);
    }
}
