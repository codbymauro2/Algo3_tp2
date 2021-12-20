package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.ApplicationOnKeyPressEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Carmen San Diego Algo - 3");

        Game game = createModel();

        PrincipalContainer principalContainer = new PrincipalContainer(stage, game);
        Scene gameScene = new Scene(principalContainer, 640, 480);

        ApplicationOnKeyPressEventHandler ApplicationOnKeyPressEventHandler = new ApplicationOnKeyPressEventHandler(stage, principalContainer.getMenuBar());
        gameScene.setOnKeyPressed(ApplicationOnKeyPressEventHandler);

        WelcomeContainer welcomeContainer = new WelcomeContainer(stage, gameScene);
        Scene welcomeScene = new Scene(welcomeContainer, 640, 480);

        stage.setScene(welcomeScene);

        stage.show();

    }

    private Game createModel() throws FileNotFoundException {
        return new Game();
    }
}

