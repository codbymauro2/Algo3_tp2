import Lists.CitiesList;
import Lists.PlayersList;
import Lists.StolenItemsList;
import MainObjects.City;
import MainObjects.Player;
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
    PlayersList players = new PlayersList();
    StolenItemsList stolenItemsList = new StolenItemsList();
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
        stolenItemsReader = new StolenItemsReader(stolenItemsList);
        playerReader = new PlayerReader(players);
        // suspectReader = new SuspectReader(suspects);
        cityReader = new CityReader(citiesList);
    }

    public void start() {
        readFiles();
        assignStolenItem();
        assignCity();
    }

    private void assignCity() {
        citiesList.assign(stolenItemsList);
    }

    private void assignStolenItem() {
        stolenItemsList.assign(difficulty);
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

