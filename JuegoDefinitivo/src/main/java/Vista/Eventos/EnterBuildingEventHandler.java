package Vista.Eventos;

import Modelo.MainObjects.Buildings.Airport;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Building;
import Modelo.MainObjects.Buildings.Library;
import Modelo.MainObjects.Game;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class EnterBuildingEventHandler {

    private Game game;


    public EnterBuildingEventHandler(Game game){
        this.game = game;

    }

    @Override
    public void handle(ActionEvent event) {
        ArrayList<Building> buildings = game.getBuildings();
        Bank building1 = (Bank) buildings.get(0);
        Airport building2 = (Airport) buildings.get(1);
        Library building3 = (Library) buildings.get(2);
    }

}
