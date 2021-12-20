package Vista;

import Vista.Eventos.PlayButtonEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class WelcomeContainer extends VBox {

    Stage stage;

    public WelcomeContainer(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(20));
        Image image = new Image("main.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
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

        PlayButtonEventHandler playButtonHandler = new PlayButtonEventHandler(stage, proximaEscena);
        enterButton.setOnAction(playButtonHandler);


        this.getChildren().addAll(enterButton,creditsButton,exitButton);
    }

}
