package Vista;

import Modelo.MainObjects.Feature;
import Modelo.MainObjects.Game;
import Vista.Eventos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class WarrantContainer extends BorderPane {
    private Stage stage;
    private Game game;
    private VBox centralContainer;

    public WarrantContainer(Stage stage, Game game) {
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
        screen.getStyleClass().add("right-screen-warrant");

        Label searchResult = new Label();
        searchResult.getStyleClass().add("clue-label");
        screen.getChildren().add(searchResult);

        // PANTALLA IZQUIERDA DE JUEGO
        VBox showCities = new VBox();
        HBox leftCities = new HBox();
        HBox rightCities = new HBox();
        showCities.getChildren().addAll(leftCities, rightCities);
        showCities.getStyleClass().add("bottom-box");

        // COMBOS BOX
        ComboBox<String> cbxSex = new ComboBox();
        cbxSex.setPromptText("Select gender");
        cbxSex.setEditable(true);
        cbxSex.getEditor().setEditable(false);
        cbxSex.getStyleClass().add("feature-select");
        cbxSex.getItems().addAll("Male", "Female", "");
        cbxSex.getSelectionModel().select(2);

        ComboBox<String> cbxHair = new ComboBox();
        cbxHair.setPromptText("Select hair color");
        cbxHair.setEditable(true);
        cbxHair.getEditor().setEditable(false);
        cbxHair.getStyleClass().add("feature-select");
        cbxHair.getItems().addAll("Blond", "Black", "Brown", "Red", "");
        cbxHair.getSelectionModel().select(4);

        ComboBox<String> cbxHobby = new ComboBox();
        cbxHobby.setPromptText("Select hobby");
        cbxHobby.setEditable(true);
        cbxHobby.getEditor().setEditable(false);
        cbxHobby.getStyleClass().add("feature-select");
        cbxHobby.getItems().addAll("Mountain Climbing", "Tennis", "Music", "Skydiving", "Swimming", "Croquet", "");
        cbxHobby.getSelectionModel().select(6);

        ComboBox<String> cbxAccessory = new ComboBox();
        cbxAccessory.setPromptText("Select accesssory");
        cbxAccessory.setEditable(true);
        cbxAccessory.getEditor().setEditable(false);
        cbxAccessory.getStyleClass().add("feature-select");
        cbxAccessory.getItems().addAll("Ring", "Tattoo", "Scar", "Jewelry", "");
        cbxAccessory.getSelectionModel().select(4);

        ComboBox<String> cbxVehicle = new ComboBox();
        cbxVehicle.setPromptText("Select vehicle");
        cbxVehicle.setEditable(true);
        cbxVehicle.getEditor().setEditable(false);
        cbxVehicle.getStyleClass().add("feature-select");
        cbxVehicle.getItems().addAll("Convertible", "Limousine", "Sport", "Motorcycle", "");
        cbxVehicle.getSelectionModel().select(4);

        VBox allCBX = new VBox();
        allCBX.getStyleClass().add("combo-box");
        allCBX.getChildren().addAll(cbxSex, cbxHobby, cbxHair, cbxAccessory, cbxVehicle);

        EmitWarrantButtonEventHandler emitWarrantButtonEventHandler = new EmitWarrantButtonEventHandler(game, allCBX, searchResult);
        Button emitWarrantButton = new Button("SEARCH");
        emitWarrantButton.getStyleClass().add("emit-button");
        emitWarrantButton.setOnAction(emitWarrantButtonEventHandler);

        // BOTONERA
        ButtonBar buttonBar = new ButtonBar(20);
        buttonBar.getStyleClass().add("button-box");

        vRightContainer.getChildren().addAll(screen, buttonBar);

        // ESPACIO PARA CIUDAD ACTUAL Y TIEMPO RESTANTE
        VBox timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");

        Label textTime = new Label(game.time());
        Label textSpace = new Label(game.getCityName());
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");

        timeVbox.getChildren().addAll(textSpace, textTime);

        VBox emitWarrantBox = new VBox(5);
        emitWarrantBox.getStyleClass().add("warrant-box");

        emitWarrantBox.getChildren().addAll(allCBX, emitWarrantButton);

        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426, 570);
        left.getChildren().addAll(timeVbox, emitWarrantBox, showCities);

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

        InvestigateButtonEventHandler investigateButtonEventHandler = new InvestigateButtonEventHandler(game, stage);
        buttonBar.setInvestigateAction(investigateButtonEventHandler);

        this.setCenter(centralContainer);
    }
}