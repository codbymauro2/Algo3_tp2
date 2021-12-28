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
    private final Label textTime;
    private final Label textSpace;
    private MainContainer mainContainer;
    private ButtonBar buttonBar;
    private VBox allCBX;
    private Label searchResult;
    private VBox timeVbox;

    public WarrantContainer(Stage stage, Game game) {
        this.stage = stage;
        this.game = game;
        textTime = new Label(game.time());
        textSpace = new Label(game.getCityName());
        searchResult = new Label();
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");
        searchResult.getStyleClass().add("clue-label");
        this.setMenu();
        this.setCenter();
    }

    private void setMenu() {
        ApplicationMenuBar menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }

    private void setCenter() {

        mainContainer =  new MainContainer(this.game, this.stage);
        buttonBar = new ButtonBar(20);
        buttonBar.getStyleClass().add("button-box");
        mainContainer.setCenter();
        mainContainer.setNameTime( getTimeName() );
        mainContainer.setCitiesBox();
        mainContainer.setFullScreen();
        mainContainer.setLeftScreen( getLeftScreen() );
        mainContainer.setRightScreen( this.getScreen() ) ;
        mainContainer.setButtonBar(buttonBar);
        this.setButtonBarActions();
        mainContainer.buildContainer();
        this.setCenter(mainContainer);

    }

    private VBox getScreen() {
        VBox screen = new VBox(0);
        screen.getStyleClass().add("right-screen");
        screen.getChildren().add(searchResult);

        return screen;
    }


    private VBox getLeftScreen() {

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

        allCBX = new VBox();
        allCBX.getStyleClass().add("combo-box");
        allCBX.getChildren().addAll(cbxSex, cbxHobby, cbxHair, cbxAccessory, cbxVehicle);

        EmitWarrantButtonEventHandler emitWarrantButtonEventHandler = new EmitWarrantButtonEventHandler(game, allCBX, searchResult);
        Button emitWarrantButton = new Button("SEARCH");
        emitWarrantButton.getStyleClass().add("emit-button");
        emitWarrantButton.setOnAction(emitWarrantButtonEventHandler);

        VBox emitWarrantBox = new VBox(5);
        emitWarrantBox.getStyleClass().add("warrant-box");

        emitWarrantBox.getChildren().addAll(allCBX, emitWarrantButton);

        return emitWarrantBox;
    }

    private void setButtonBarActions() {
        InvestigateButtonEventHandler investigateButtonEventHandler = new InvestigateButtonEventHandler(game, stage);
        buttonBar.setInvestigateAction(investigateButtonEventHandler);

        TravelButtonEventHandler travelButtonEventHandler = new TravelButtonEventHandler(game, stage);
        buttonBar.setTravelAction(travelButtonEventHandler);

        EmitWarrantEventHandler emitWarrantEventHandler = new EmitWarrantEventHandler(game, stage);
        buttonBar.setWarrantAction(emitWarrantEventHandler);
    }

    public VBox getTimeName() {
        timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");
        timeVbox.getChildren().addAll(textSpace, textTime);
        return timeVbox;
    }

}