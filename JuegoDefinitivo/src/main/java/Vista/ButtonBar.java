package Vista;

import Vista.Eventos.ConnectionsButtonEventHandler;
import Vista.Eventos.EmitWarrantEventHandler;
import Vista.Eventos.InvestigateButtonEventHandler;
import Vista.Eventos.TravelButtonEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class ButtonBar extends HBox {

    private Button travelButton;
    private Button emitOrderButton;
    private Button connectionsButton;
    private Button enterBuildingButton;

    public ButtonBar(int spacing) {

        ImageView travelImage = new ImageView(new Image("/images/departButton.png", 80, 80, false, false));
        ImageView warrantImage = new ImageView(new Image("/images/warrantButton.png", 80, 80, false, false));
        ImageView citiesImage = new ImageView(new Image("/images/citiesButton.png", 80, 80, false, false));
        ImageView investigateImage = new ImageView(new Image("/images/investigateButton.png", 80, 80, false, false));

        travelButton = new Button("", travelImage);
        emitOrderButton = new Button("",warrantImage);
        connectionsButton = new Button("",citiesImage);
        enterBuildingButton = new Button("",investigateImage);

        travelButton.getStyleClass().add("action-button");
        emitOrderButton.getStyleClass().add("action-button");
        connectionsButton.getStyleClass().add("action-button");
        enterBuildingButton.getStyleClass().add("action-button");

        this.getChildren().addAll(travelButton,connectionsButton,emitOrderButton,enterBuildingButton);

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

    public void setWarrantAction(EmitWarrantEventHandler emitWarrantEventHandler) {
        emitOrderButton.setOnAction(emitWarrantEventHandler);
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
