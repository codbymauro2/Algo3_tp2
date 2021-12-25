package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.ApplicationOnKeyPressEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class App extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("AlgoTheif - Algo 3");

        Game game = createModel();

        WelcomeContainer welcomeContainer = new WelcomeContainer(stage, game);
        Scene welcomeScene = new Scene(welcomeContainer, 1180, 660);
        welcomeScene.getStylesheets().add(getClass().getResource("/stylesheets/welcomeScene.css").toExternalForm());

        stage.setScene(welcomeScene);
        stage.show();
    }

    private Game createModel() throws FileNotFoundException {
        Game game = new Game();
        game.startGame();
        return game;
    }
}

