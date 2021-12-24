package Vista.Eventos;

import Modelo.MainObjects.Buildings.Airport;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Building;
import Modelo.MainObjects.Buildings.Library;
import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class EnterBuildingEventHandler {

    private Game game;
    private VBox left, screen;


    public EnterBuildingEventHandler(Game game, VBox left, VBox screen){
        this.game = game;
        this.left = left;
        this.screen = screen;
    }


    @Override
    public void handle(ActionEvent event) {

        left.getChildren().clear();

        ArrayList<Building> buildings = game.getBuildings();

        Bank building1 = (Bank) buildings.get(0);
        Airport building2 = (Airport) buildings.get(1);
        Library building3 = (Library) buildings.get(2);

        EnterBankEventHandler enterBankEventHandler = new EnterBankEventHandler(game);
        EnterAirportEventHandler enterAirportEventHandler = new EnterAirportEventHandler(game);
        EnterLibraryEventHandler enterLibraryEventHandler = new EnterLibraryEventHandler(game);

        Button building1Button = new Button(building1.getName());
        Button building2Button = new Button(building2.getName());
        Button building3Button = new Button(building3.getName());

        building1Button.setOnAction(enterBankEventHandler);
        building2Button.setOnAction(enterAirportEventHandler);
        building3Button.setOnAction(enterLibraryEventHandler);



    }

}
