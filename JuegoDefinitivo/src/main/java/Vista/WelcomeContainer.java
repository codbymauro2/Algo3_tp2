package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.CreditOptionEventHandler;
import Vista.Eventos.ExitOptionEventHandler;
import Vista.Eventos.PlayButtonEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WelcomeContainer extends VBox {

    Stage stage;

    public WelcomeContainer(Stage stage, Game game) {
        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(60, 10, 10, 10));
        Image image = new Image("/images/cover.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        Button enterButton = new Button();
        enterButton.setText("Jugar");
        enterButton.setMinSize(75,25);

        Button creditsButton = new Button();
        creditsButton.setText("Creditos");
        creditsButton.setMinSize(75,25);

        Button exitButton = new Button();
        exitButton.setText("Salir");
        exitButton.setMinSize(75,25);

        PlayButtonEventHandler playButtonHandler = new PlayButtonEventHandler(stage, game);
        enterButton.setOnAction(playButtonHandler);

        ExitOptionEventHandler exitOptionHandler = new ExitOptionEventHandler();
        exitButton.setOnAction(exitOptionHandler);



//        CreditOptionEventHandler creditOptionEventHandler = new CreditOptionEventHandler();



        this.getChildren().addAll(enterButton,creditsButton,exitButton);
    }

}
