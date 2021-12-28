package Vista;

import Modelo.MainObjects.Game;
import Vista.Eventos.ConnectionsButtonEventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainContainer extends VBox {

    private final Game game;
    private final Stage stage;
    private VBox vRightContainer;
    private VBox showCities;
    private VBox timeVbox;
    private VBox left;
    private VBox right;
    private HBox fullScreen;
    private ButtonBar buttonBar;

    public MainContainer(Game game, Stage stage) {
        this.game = game;
        this.stage = stage;
    }

    public void setCenter() {
        vRightContainer = new VBox(0);
        vRightContainer.getStyleClass().add("right-side-box");
    }

    public void buildContainer() {
        this.getChildren().add(fullScreen);
        this.getStyleClass().add("central-container");
    }


    public void setFullScreen() {

        // PANTALLA IZQUIERDA
        this.left = new VBox(5);
        left.setPrefSize(426, 570);
        left.getChildren().addAll(timeVbox, showCities);

        // PANTALLA DERECHA
        this.right = new VBox(5);
        right.setPrefSize(713, 570);
        right.getChildren().addAll(vRightContainer);

        // PANTALLA COMPLETA
        this.fullScreen = new HBox(20);
        fullScreen.getChildren().addAll(left, right);
    }


    public void setButtonBar(ButtonBar buttonBar) {
        this.buttonBar = buttonBar;
        ConnectionsButtonEventHandler connectionsButtonEventHandlerEventHandler = new ConnectionsButtonEventHandler(this.game, this.stage, this.showCities);
        buttonBar.setConnectionsAction(connectionsButtonEventHandlerEventHandler);
        vRightContainer.getChildren().add(buttonBar);
    }

    public void setRightScreen(VBox screen) {
        vRightContainer.getChildren().add(screen);
    }

    public void setLeftScreen(VBox cityImageBox) {
        left.getChildren().add(1,cityImageBox);
    }

    public void setNameTime(VBox timeVbox) {
        this.timeVbox = timeVbox;
    }


    public void setCitiesBox() {
        this.showCities = new VBox();
        this.showCities.getStyleClass().add("bottom-box");
        HBox leftCities = new HBox();
        HBox rightCities = new HBox();
        this.showCities.getChildren().addAll(leftCities, rightCities);
        this.showCities.getStyleClass().add("bottom-box");
    }


    public void setLeftScreen(HBox leftScreen) {
        left.getChildren().add(1,leftScreen);
    }
}
