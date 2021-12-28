package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class PrincipalContainer extends BorderPane {

    private final Stage stage;
    private final Game game;
    ApplicationMenuBar menuBar;
    private ButtonBar buttonBar;
    private MainContainer mainContainer;
    private VBox timeVbox;
    private Label textTime;
    private Label textSpace;

    public PrincipalContainer (Stage stage, Game game) {
        this.game = game;
        this.stage = stage;
        textTime = new Label(game.time());
        textSpace = new Label(game.getCityName());
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");
        this.setMenu();
        this.setCentro();
    }

    private void setMenu() {
        this.menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {
        mainContainer =  new MainContainer(this.game, this.stage);
        buttonBar = new ButtonBar(20);
        buttonBar.getStyleClass().add("button-box");
        mainContainer.setCenter();
        mainContainer.setNameTime( getTimeName() );
        mainContainer.setCitiesBox();
        mainContainer.setFullScreen();
        mainContainer.setLeftScreen( getLeftScreen() );
        mainContainer.setRightScreen( getScreen()) ;
        mainContainer.setButtonBar(buttonBar);
        this.setButtonBarActions();
        mainContainer.buildContainer();
        this.setCenter(mainContainer);
    }

    private VBox getScreen() {
        VBox screen = new VBox(0);
        Label cityDescription = new Label(game.getCityDescription());
        cityDescription.getStyleClass().add("description-label");
        screen.getStyleClass().add("right-screen");
        screen.getChildren().add(cityDescription);
        return screen;
    }

    private VBox getTimeName() {
        timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");
        timeVbox.getChildren().addAll(textSpace, textTime);
        return timeVbox;
    }

    private VBox getLeftScreen() {
        VBox cityImageBox = new VBox(5);
        cityImageBox.getStyleClass().add("city-image-box");
        String string = ("-fx-background-image: url('/images/cities/" + game.getCityName().replaceAll(" ", "") + ".jpg'" + ");");
        cityImageBox.setStyle(string + "-fx-background-repeat: stretch;" + "-fx-background-size: 450 400;" + "-fx-background-position: center center;" );
        return cityImageBox;
    }

    private void setButtonBarActions() {
        InvestigateButtonEventHandler investigateButtonEventHandler = new InvestigateButtonEventHandler(game, stage);
        buttonBar.setInvestigateAction(investigateButtonEventHandler);

        TravelButtonEventHandler travelButtonEventHandler = new TravelButtonEventHandler(game, stage);
        buttonBar.setTravelAction(travelButtonEventHandler);

        EmitWarrantEventHandler emitWarrantEventHandler = new EmitWarrantEventHandler(game, stage);
        buttonBar.setWarrantAction(emitWarrantEventHandler);
    }


}