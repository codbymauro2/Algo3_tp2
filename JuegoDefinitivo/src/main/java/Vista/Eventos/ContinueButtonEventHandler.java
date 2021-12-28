package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.WelcomeContainer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ContinueButtonEventHandler implements EventHandler<ActionEvent>{

    private Stage stage;

    public ContinueButtonEventHandler(final Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent)  {

        Game game = null;
        try {
            game = createModel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        WelcomeContainer welcomeContainer = new WelcomeContainer(stage, game);
        Scene welcomeScene = new Scene(welcomeContainer, 1180, 660);
        welcomeScene.getStylesheets().add(getClass().getResource("/stylesheets/welcomeScene.css").toExternalForm());

        stage.setScene(welcomeScene);

    }

    private Game createModel() throws FileNotFoundException {
        Game game = new Game();
        game.startGame();
        return game;
    }

}
