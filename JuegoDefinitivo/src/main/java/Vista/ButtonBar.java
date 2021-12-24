package Vista;

import Vista.Eventos.ConnectionsButtonEventHandler;
import Vista.Eventos.InvestigateButtonEventHandler;
import Vista.Eventos.TravelButtonEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class ButtonBar extends HBox {

    private Button travelButton;
    private Button emitOrderButton;
    private Button connectionsButton;
    private Button enterBuildingButton;



    public ButtonBar(int spacing) {

        travelButton = new Button("",new ImageView(new Image("images/travelButton.png")));
        travelButton.setPrefSize(128,113);

        emitOrderButton = new Button("",new ImageView(new Image("images/emitOrderButton.png")));
        emitOrderButton.setPrefSize(128,113);

        connectionsButton = new Button("",new ImageView(new Image("images/citiesButtton.png")));
        connectionsButton.setPrefSize(128,113);

        enterBuildingButton = new Button("",new ImageView(new Image("images/enterButton.png")));
        enterBuildingButton.setPrefSize(128,113);

        this.setSpacing(spacing);
        this.setPrefSize(813,230);
        this.setBackground(new Background(new BackgroundFill(Paint.valueOf("grey"), CornerRadii.EMPTY, Insets.EMPTY)));
        this.getChildren().addAll(travelButton,connectionsButton,emitOrderButton,enterBuildingButton);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10,10,10,10));

    }

    public void setTravelAction(TravelButtonEventHandler travelButtonEventHandler) {
        travelButton.setOnAction(travelButtonEventHandler);
    }

    public void setConnectionsAction(ConnectionsButtonEventHandler connectionsButtonEventHandler) {
        connectionsButton.setOnAction(connectionsButtonEventHandler);
    }

    public void setInvestigateAction(InvestigateButtonEventHandler investigateButtonEventHandlerEventHandler) {
        enterBuildingButton.setOnAction(investigateButtonEventHandlerEventHandler);
    }

    public void setDisable() {
        travelButton.setDisable(true);
        connectionsButton.setDisable(true);
        emitOrderButton.setDisable(true);
        enterBuildingButton.setDisable(true);
    }

    public void setEnable() {
        travelButton.setDisable(false);
        connectionsButton.setDisable(false);
        emitOrderButton.setDisable(false);
        enterBuildingButton.setDisable(false);
    }

}
