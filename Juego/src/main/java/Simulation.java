import Lists.CitiesList;
import Lists.StolenItemsList;
import MainObjects.City;
import MainObjects.Player;
import MainObjects.StolenItems;
import MainObjects.Suspect;
import Readers.CityReader;
import Readers.PlayerReader;
import Readers.StolenItemsReader;
import Readers.SuspectReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Simulation {

    // LISTAS
    CitiesList citiesList = new CitiesList();
    ArrayList<Player> players = new ArrayList<Player>();
    StolenItemsList stolenItems = new StolenItemsList();
    ArrayList<Suspect> suspects = new ArrayList<Suspect>();

    // LECTORES
    StolenItemsReader stolenItemsReader;
    PlayerReader playerReader;
    SuspectReader suspectReader;
    CityReader cityReader;

    // OBJETOS
    Player player;
    City startCity;
    Integer difficulty = 0;

    public Simulation() throws FileNotFoundException {
        stolenItemsReader = new StolenItemsReader(stolenItems);
        playerReader = new PlayerReader(players);
        suspectReader = new SuspectReader(suspects);
        cityReader = new CityReader(citiesList);
    }

    public void start() {
        readFiles();
        assignCity();
    }

    private void assignCity() {
    }

    private void assignStolenItem() {
        stolenItems.assign(difficulty);
    }

    private void readFiles() {
        readCityFiles();
        readPlayerFiles();
        readStolenItemsFiles();
        readSuspectFiles();
    }

    private void assignPlayer() {

    }


    private void readSuspectFiles() {
        suspectReader.read();
    }

    private void readStolenItemsFiles() {
        stolenItemsReader.read();
    }

    private void readPlayerFiles() {
        playerReader.read();
    }

    private void readCityFiles() {
        cityReader.read();
    }


}
