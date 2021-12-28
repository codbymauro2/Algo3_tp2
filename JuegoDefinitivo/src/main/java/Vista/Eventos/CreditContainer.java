package Vista.Eventos;

import Modelo.MainObjects.Game;
import Vista.Eventos.ContinueButtonEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CreditContainer extends VBox{

    private Stage stage;
    public CreditContainer(Stage stage) {
        super();
        this.getStylesheets().add(getClass().getResource("/stylesheets/gameScene.css").toExternalForm());
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setPadding(new Insets(10,20, 150, 20));
        Image image = new Image("/images/creditsScene.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        Label label = new Label("This game was made with lots of love and effort, as part of the final proyect of the subject 'Programming & Algorithms III - Pablo Suárez Chair' for the Universidad de Buenos Aires.\nThe students that coded this game were:\nDecouflet, Agustín\n Frascarelli, Esteban\n General, Camila\nRamos, Claudia\n Villagra, Mauro\n And a special mention to the teacher assigned to this proyect" +
                ": Massuh, Pablo.\n We hope you enjoy this game as much as we enjoyed doing it!.");
        label.getStyleClass().add("credits-label");

        Button continueButton = new Button();
        continueButton.setText("Main Menu");
        continueButton.setMinSize(75,25);

        ContinueButtonEventHandler continueButtonEventHandler = new ContinueButtonEventHandler(stage);
        continueButton.setOnAction(continueButtonEventHandler);
        continueButton.getStyleClass().add("end-button");

        this.getChildren().addAll(label, continueButton);
    }
}
