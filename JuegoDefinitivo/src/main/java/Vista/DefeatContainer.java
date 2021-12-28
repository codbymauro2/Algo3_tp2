package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.ContinueButtonEventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DefeatContainer extends VBox {

    Stage stage;

    public DefeatContainer(Game game, Stage stage, String labelText) {
        super();
        this.getStylesheets().add(getClass().getResource("/stylesheets/gameScene.css").toExternalForm());
        this.stage = stage;
        this.setAlignment(Pos.TOP_CENTER);
        //this.setSpacing(60);
        this.setPadding(new Insets(20, 100, 20, 100));
        Image image = new Image("/images/defeatImage.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        Label label = new Label(labelText);
        label.getStyleClass().add("end-label");

        VBox labelBox = new VBox();
        labelBox.setPadding(new Insets(10,10,100,10));
        labelBox.getChildren().add(label);

        Button continueButton = new Button();
        continueButton.setText("Main menu");
        continueButton.setMinSize(75,25);

        ContinueButtonEventHandler continueButtonEventHandler = new ContinueButtonEventHandler(stage);
        continueButton.setOnAction(continueButtonEventHandler);
        continueButton.getStyleClass().add("end-button");

        this.getChildren().addAll(labelBox, continueButton);
    }

}
