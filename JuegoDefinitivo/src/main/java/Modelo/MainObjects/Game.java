package Modelo.MainObjects;

import Modelo.Lists.*;
import Modelo.Readers.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Game {

    private Police police;
    private Player player;
    private Cities cities;
    private CityReader cityReader;
    private StolenItem stolenItem;
    private StolenItems stolenItems;
    private StolenItemsReader stolenItemsReader;
    private PoliceStation policeStation;
    private Suspects suspects;
    private SuspectReader suspectReader;
    private Players players;
    private PlayerReader playerReader;
    private Suspect thief;


    public Game() throws FileNotFoundException {
        players = new Players();
        playerReader = new PlayerReader(players);
    }

    public void setPlayer(String name) {
        this.player = this.players.getPlayer(name);
    }

    public String getPlayerName() {
        return this.player.getName();
    }

    public void startGame() throws FileNotFoundException{
        this.collectData();
        this.policeStation = new PoliceStation(suspects,cities);
    }

    public void initializeCase() {
        this.police = this.policeStation.assignRange(this.player);
        this.stolenItem = stolenItems.assign(police.getStolenItemDifficulty());
        this.police.setCurrentCity(cities.find(stolenItem.city));
        this.suspects.randomSuspect(cities, this.police.getCitiesToTravel());
        this.thief = this.suspects.getRobber();
    }


    private void collectData() throws FileNotFoundException {

        this.players = new Players();
        this.playerReader = new PlayerReader(players);
        playerReader.read();

        this.cities = new Cities();
        this.cityReader = new CityReader(cities);
        cityReader.read();

        this.stolenItems = new StolenItems();
        this.stolenItemsReader = new StolenItemsReader(stolenItems);
        stolenItemsReader.read();

        this.suspects = new Suspects();
        this.suspectReader = new SuspectReader(suspects);
        suspectReader.read();

    }

    public String getStolenItemName() {
        return this.stolenItem.getName();
    }

    public String getThiefGender() {
        return this.thief.getGender();
    }
}
