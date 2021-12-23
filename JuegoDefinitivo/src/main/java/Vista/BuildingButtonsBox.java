package Vista;

import Modelo.MainObjects.Buildings.Building;
import javafx.scene.layout.VBox;
import Modelo.MainObjects.Game;

import javafx.scene.control.Button;
import java.util.ArrayList;


public class BuildingButtonsBox extends VBox {

    private Game game;
    private ArrayList<Button> buildings;

    public BuildingButtonsBox (Game game){
        this.game = game;

    }

    public void addButtons(Button building1, Button building2, Button building3){
        this.buildings.add(building1);
        this.buildings.add(building2);
        this.buildings.add(building3);
    }
}
