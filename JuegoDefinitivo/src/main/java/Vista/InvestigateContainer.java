package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class InvestigateContainer extends BorderPane {

    private Stage stage;
    private Game game;
    private MainContainer mainContainer;
    private ButtonBar buttonBar;
    private VBox timeVbox;
    private Label textTime;
    private Label textSpace;
    private Label clueLabel;

    public InvestigateContainer(Stage stage, Game game) {
        this.stage = stage;
        this.game = game;
        textTime = new Label(game.time());
        textSpace = new Label(game.getCityName());
        clueLabel = new Label();
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");
        clueLabel.getStyleClass().add("clue-label");
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
        this.setButtonBarActions();
        buttonBar.getStyleClass().add("button-box");
        mainContainer.setCenter();
        mainContainer.setNameTime( this.getTimeName() );
        mainContainer.setCitiesBox();
        mainContainer.setFullScreen();
        mainContainer.setLeftScreen( getLeftScreen() );
        mainContainer.setRightScreen( this.getScreen() ) ;
        mainContainer.setButtonBar(buttonBar);
        mainContainer.buildContainer();
        this.setCenter(mainContainer);

    }

    private VBox getScreen() {
        VBox screen = new VBox(0);
        screen.getStyleClass().add("right-screen");
        screen.getChildren().addAll(clueLabel);

        return screen;
    }

    private VBox getTimeName() {
        timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");
        timeVbox.getChildren().addAll(textSpace, textTime);
        return timeVbox;
    }

    private HBox getLeftScreen() {

        HBox enterBuildingOptions = new HBox(5);
        enterBuildingOptions.getStyleClass().add("travel-box");

        // BOTONES EDIFICIOS
        EnterBankEventHandler enterBankEventHandler = new EnterBankEventHandler(game, clueLabel, textTime, stage);
        EnterAirportEventHandler enterAirportEventHandler = new EnterAirportEventHandler(game, clueLabel, textTime, stage);
        EnterLibraryEventHandler enterLibraryEventHandler = new EnterLibraryEventHandler(game, clueLabel, textTime, stage);

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

        return enterBuildingOptions;
    }

    private void setButtonBarActions() {
        // EVENTOS DE LOS BOTONES
        TravelButtonEventHandler travelButtonEventHandler = new TravelButtonEventHandler(game, stage);
        buttonBar.setTravelAction(travelButtonEventHandler);

        EmitWarrantEventHandler emitWarrantEventHandler = new EmitWarrantEventHandler(game, stage);
        buttonBar.setWarrantAction(emitWarrantEventHandler);
    }
}
