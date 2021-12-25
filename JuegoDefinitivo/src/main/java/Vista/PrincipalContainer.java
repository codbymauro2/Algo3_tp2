package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.EnterNameEventHandler;
import Vista.Eventos.ConnectionsButtonEventHandler;
import Vista.Eventos.InvestigateButtonEventHandler;
import Vista.Eventos.TravelButtonEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import javax.swing.*;
import java.net.URL;
import java.util.Collection;


public class PrincipalContainer extends BorderPane {

    private final Stage stage;
    private final Game game;
    ApplicationMenuBar menuBar;
    VBox centralContainer;

    public PrincipalContainer (Stage stage, Game game) {
        this.game = game;
        this.stage = stage;
        this.setMenu();
        this.setCentro();
    }

    private void setMenu() {
        this.menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }

    private void setCentro() {

        // CONTENEDOR PANTALLA/BOTONES
        VBox vRightContainer = new VBox(0);
        vRightContainer.getStyleClass().add("right-side-box");

        // PANTALLA DERECHA DE JUEGO
        VBox screen = new VBox(0);
        screen.setPrefSize(813, 682);
        screen.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
        screen.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));

        // BOTONERA
        ButtonBar buttonBar = new ButtonBar(20);
        buttonBar.getStyleClass().add("button-box");
        vRightContainer.getChildren().addAll(screen, buttonBar);

        // ESPACIO PARA CIUDAD ACTUAL Y TIEMPO RESTANTE
        VBox timeVbox = new VBox();
        timeVbox.getStyleClass().add("time-box");

        Label textSpace = new Label(game.getCityName());
        Label textTime = new Label(game.time());
        textTime.getStyleClass().add("time-label");
        textSpace.getStyleClass().add("city-label");

        timeVbox.getChildren().addAll(textSpace, textTime);

        VBox nameBox = new VBox(5);
        nameBox.setAlignment(Pos.TOP_CENTER);
        nameBox.setPrefSize(500, 500);
        nameBox.setPadding(new Insets(100, 0, 0, 0));
        String string = ("-fx-background-image: url('images/" + game.getCityName() + ".jpg'" + ");");
        nameBox.setStyle(string +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 450 400;" +
                "-fx-background-position: center center;" );


        VBox showCities = new VBox();
        showCities.setAlignment(Pos.CENTER);
        showCities.setPrefSize(420, 200);
        showCities.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY, Insets.EMPTY)));
        showCities.setBorder(new Border(new BorderStroke(Paint.valueOf("white"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));


        // PANTALLA IZQUIERDA
        VBox left = new VBox(5);
        left.setPrefSize(426, 570);
        left.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        left.getChildren().addAll(timeVbox, nameBox, showCities);

        // PANTALLA DERECHA
        VBox right = new VBox(5);
        right.setPrefSize(713, 570);
        right.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        right.getChildren().addAll(vRightContainer);

        // PANTALLA COMPLETA
        HBox fullScreen = new HBox(20);
        fullScreen.getChildren().addAll(left, right);
        fullScreen.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        fullScreen.setPadding(new Insets(10));

        centralContainer = new VBox(fullScreen);
        centralContainer.setAlignment(Pos.CENTER);
        centralContainer.setSpacing(20);
        centralContainer.setPadding(new Insets(25));

        // EVENTOS DE LOS BOTONES
        TravelButtonEventHandler travelButtonEventHandler = new TravelButtonEventHandler(game, stage);
        buttonBar.setTravelAction(travelButtonEventHandler);

        ConnectionsButtonEventHandler connectionsButtonEventHandlerEventHandler = new ConnectionsButtonEventHandler(game, stage);
        buttonBar.setConnectionsAction(connectionsButtonEventHandlerEventHandler);

        InvestigateButtonEventHandler investigateButtonEventHandler = new InvestigateButtonEventHandler(game, stage);
        buttonBar.setInvestigateAction(investigateButtonEventHandler);

        EmitWarrantEventHandler emitWarrantEventHandler = new EmitWarrantEventHandler(game, stage);
        buttonBar.setWarrantAction(emitWarrantEventHandler);

        this.setCenter(centralContainer);

    }

    public ApplicationMenuBar getMenuBar() {
        return menuBar;
    }
}

