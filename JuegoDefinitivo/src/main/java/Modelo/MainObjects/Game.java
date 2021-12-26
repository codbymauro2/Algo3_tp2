package Modelo.MainObjects;

import Modelo.Lists.*;
import Modelo.MainObjects.Buildings.Airport;
import Modelo.MainObjects.Buildings.Library;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Building;
import Modelo.Readers.*;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
    private City currentCity;

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
        this.cities.startCity(stolenItem);
        this.suspects.randomSuspect(cities, this.police.getCitiesToTravel());
        this.policeStation.setSuspect();
        this.police.setCurrentCity(cities.getStartCity());
        this.thief = this.suspects.getRobber();
        this.cities.setSuspect(this.thief);
        this.currentCity = police.getCurrentCity();
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

    public String time() {
        if (this.police == null)
            return "Monday 9hs";
        return String.valueOf(this.police.getTimeLeftInHours());
    }

    public String getCityName() {
        if (this.police == null)
            return "Cuartel General";
        return police.getCurrentCity().getName();
    }

    public ArrayList<City> getTravelCities() {
        cities.setPossibleCities(police);
        return police.getConnections();
    }

    public ArrayList<Building> getBuildings(){
        return (this.currentCity.getBuildings());
    }

    public String deployAirportClue() {
        return (this.police.enter(new Airport()));
    }

    public String deployLibraryClue() {
        return (this.police.enter(new Library()));
    }

    public String deployBankClue() {
        return (this.police.enter(new Bank()));
    }

    public void travel(City city) {
        police.travel(city);
        this.currentCity = city;
        if (city.isFinalCity()) {
            throw new FinalCityException();
        }
    }

    public String getRank() {
        return police.getClass().getSimpleName();
    }

    public ArrayList<Suspect> filterFeatures(ArrayList<Feature> features) {
        return (this.policeStation.getSuspects(features));
    }

    public void emitWarrant(Suspect suspect) {
        police.emitWarrant(suspect);
    }

    public City getCurrentCity() {
        return currentCity;
    }
}
