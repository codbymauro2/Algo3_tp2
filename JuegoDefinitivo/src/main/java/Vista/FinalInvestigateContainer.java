package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinalInvestigateContainer extends BorderPane {
    private Stage stage;
    private Game game;
    private VBox centralContainer;

    public FinalInvestigateContainer(Stage stage, Game game) {
        this.stage = stage;
        this.game = game;
        centralContainer = new VBox();
        this.setMenu();
        this.setCenter();
    }

    private void setMenu() {
        ApplicationMenuBar menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }

    private void setCenter() {
        // CONTENEDOR PANTALLA/BOTONES
        VBox vRightContainer = new VBox(0);
        vRightContainer.getStyleClass().add("right-side-box");

        // PANTALLA DERECHA DE JUEGO
        VBox screen = new VBox(0);
        screen.getStyleClass().add("right-screen");

        Label clueLabel = new Label();
        clueLabel.getStyleClass().add("clue-label");

        // BOTONERA
        ButtonBar buttonBar = new ButtonBar(20);
        buttonBar.getStyleClass().add("button-box");

        screen.getChildren().addAll(clueLabel);
        vRightContainer.getChildren().addAll(screen, buttonBar);

        // ESPACIO PARA CIUDAD ACTUAL Y TIEMPO RESTANTE
        VBox timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");

        Label textTime = new Label(game.time());
        Label textSpace = new Label(game.getCityName());
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");

        timeVbox.getChildren().addAll(textSpace, textTime);

        HBox enterBuildingOptions = new HBox(5);
        enterBuildingOptions.getStyleClass().add("travel-box");

        // BOTONES EDIFICIOS
        EnterFinalBankEventHandler enterBankEventHandler = new EnterFinalBankEventHandler(game, clueLabel, textTime);
        EnterFinalAirportEventHandler enterAirportEventHandler = new EnterFinalAirportEventHandler(game, clueLabel, textTime);
        EnterFinalLibraryEventHandler enterLibraryEventHandler = new EnterFinalLibraryEventHandler(game, clueLabel, textTime);

        ImageView bankImage = new ImageView(new Image("/images/bankButton.png", 80, 80, false, false));
        ImageView libraryImage = new ImageView(new Image("/images/libraryButton.png", 80, 80, false, false));
        ImageView airportImage = new ImageView(new Image("/images/airportButton.png", 80, 80, false, false));

        Button bankButton = new Button("", bankImage);
        Button libraryButton = new Button("", libraryImage);
        Button airportButton = new Button("", airportImage);

        bankButton.getStyleClass().add("action-button");
        libraryButton.getStyleClass().add("action-button");
        airportButton.getStyleClass().add("action-button");

        bankButton.setOnAction(enterBankEventHandler);
        libraryButton.setOnAction(enterLibraryEventHandler);
        airportButton.setOnAction(enterAirportEventHandler);

        enterBuildingOptions.getChildren().addAll(bankButton, libraryButton, airportButton);

        VBox showCities = new VBox();
        showCities.getStyleClass().add("bottom-box");
        HBox leftCities = new HBox();
        HBox rightCities = new HBox();
        showCities.getChildren().addAll(leftCities, rightCities);
        showCities.getStyleClass().add("bottom-box");

        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426, 570);
        left.getChildren().addAll(timeVbox, enterBuildingOptions, showCities);

        // PANTALLA DERECHA
        VBox right = new VBox(5);
        right.setPrefSize(713, 570);
        right.getChildren().addAll(vRightContainer);

        // PANTALLA COMPLETA
        HBox fullScreen = new HBox(20);
        fullScreen.getChildren().addAll(left, right);

        centralContainer = new VBox(fullScreen);
        centralContainer.getStyleClass().add("central-container");

        // EVENTOS DE LOS BOTONES
        TravelButtonEventHandler travelButtonEventHandler = new TravelButtonEventHandler(game, stage);
        buttonBar.setTravelAction(travelButtonEventHandler);

        ConnectionsButtonEventHandler connectionsButtonEventHandlerEventHandler = new ConnectionsButtonEventHandler(game, stage, showCities);
        buttonBar.setConnectionsAction(connectionsButtonEventHandlerEventHandler);

        EmitWarrantEventHandler emitWarrantEventHandler = new EmitWarrantEventHandler(game, stage);
        buttonBar.setWarrantAction(emitWarrantEventHandler);

        this.setCenter(centralContainer);
    }
}
