package Modelo.MainObjects;

import Modelo.Lists.Cities;
import Modelo.Lists.Players;
import Modelo.Lists.Suspects;
import Modelo.Readers.CityReader;
import Modelo.Readers.PlayerReader;
import Modelo.Readers.SuspectReader;

import java.io.FileNotFoundException;

public class Game {

    private Police police;
    private Player player;
    private Planisphere planisphere;
    private Cities cities;
    private CityReader cityReader;
    private StolenItem stolenItem;
    private PoliceStation policeStation;
    private Suspects suspects;
    private SuspectReader suspectReader;
    private Players players;
    private PlayerReader playerReader;


    public Game() throws FileNotFoundException {

        players = new Players();
        playerReader = new PlayerReader(players);
    }

    public void setPlayerName(String name) {
        this.player = new Player(name, 6);
    }

    public String getPlayerName() {
        return this.player.getName();
    }

}
