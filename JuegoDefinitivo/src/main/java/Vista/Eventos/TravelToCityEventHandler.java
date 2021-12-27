package Vista.Eventos;

import Modelo.MainObjects.City;
import Modelo.MainObjects.FinalCityException;
import Modelo.MainObjects.Game;
import Vista.DefeatContainer;
import Vista.FinalCityContainer;
import Vista.PrincipalContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TravelToCityEventHandler implements EventHandler<ActionEvent> {
    private City travelCity;
    private Game game;
    private Stage stage;

    public TravelToCityEventHandler(Game game, Stage stage, City travelCity){
        this.travelCity = travelCity;
        this.game = game;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent action){
        try {
            game.travel(travelCity);
            if (game.isOutOfTime()) {
                DefeatContainer defeatContainer = new DefeatContainer(game, stage);
                Scene defeatScene = new Scene(defeatContainer,1180, 660);
                stage.setScene(defeatScene);
            } else {
                PrincipalContainer principalContainer = new PrincipalContainer(stage, game);
                principalContainer.getStylesheets().add(getClass().getResource("/stylesheets/gameScene.css").toExternalForm());
                Scene gameScene = new Scene(principalContainer, 1180, 660);
                stage.setScene(gameScene);
            }
        } catch(FinalCityException e) {
            //ESCENA FINAL
            FinalCityContainer finalCityContainer = new FinalCityContainer(stage, game);
            Scene scene = new Scene(finalCityContainer, 1180, 660);
            scene.getStylesheets().add(getClass().getResource("/stylesheets/gameScene.css").toExternalForm());
            stage.setScene(scene);
        }
    }
}