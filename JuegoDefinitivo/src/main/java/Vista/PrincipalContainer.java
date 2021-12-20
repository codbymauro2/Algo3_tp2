package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.DirectionButtonHandler;
import Vista.Eventos.EnterNameEventHandler;
import Vista.Eventos.MoveButtonHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.awt.*;


public class PrincipalContainer extends BorderPane {

    ApplicationMenuBar menuBar;
    GameView gameView;
    Canvas canvasCentral;
    VBox centralContainer;

    public PrincipalContainer (Stage stage, Game game) {
        this.setMenu(stage);
        this.setCentro(game);
        this.setBotonera(game);
    }

    private void setBotonera(Game game) {

        Button moveButton = new Button();
        moveButton.setText("Mover");
        MoveButtonHandler moveButtonHandler = new MoveButtonHandler(gameView, game);
        moveButton.setOnAction(moveButtonHandler);

        Button directionButton = new Button();
        directionButton.setText("Cambiar direccion");
        DirectionButtonHandler directionButtonHandler = new DirectionButtonHandler(game);
        directionButton.setOnAction(directionButtonHandler);

        HBox buttonContainer = new HBox(moveButton, directionButton);
        buttonContainer.setSpacing(200);

        buttonContainer.setBackground(new Background(new BackgroundFill(Paint.valueOf("grey"), CornerRadii.EMPTY, Insets.EMPTY)));
        buttonContainer.setSpacing(10);
        buttonContainer.setPadding(new Insets(15));

        this.setBottom(buttonContainer);

    }

    private void setMenu(Stage stage) {
        this.menuBar = new ApplicationMenuBar(stage);
        this.setTop(menuBar);
    }

    private void setCentro(Game game) {

        TextField playerTextField = new TextField();
        EnterNameEventHandler enterNameEventHandler = new EnterNameEventHandler(gameView,game,playerTextField);
        playerTextField.setOnAction(enterNameEventHandler);

        canvasCentral = new Canvas(200, 200);
        gameView = new GameView(game, canvasCentral);
        gameView.paint();


        VBox left = new VBox(5);
        VBox right = new VBox(5);

        left.setPrefSize(200,600);
        right.setPrefSize(800,600);

        left.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        right.setBorder(new Border(new BorderStroke(Paint.valueOf("black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

        HBox root = new HBox(5);
        root.getChildren().addAll(left,right);

        root.setPadding(new Insets(10));

        centralContainer = new VBox(root);
        centralContainer.setAlignment(Pos.CENTER);
        centralContainer.setSpacing(20);
        centralContainer.setPadding(new Insets(25));
        Image image = new Image("juego.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        right.setBackground(new Background(backgroundImage));

        this.setCenter(centralContainer);
    }


    public ApplicationMenuBar getMenuBar() {
        return menuBar;
    }
}