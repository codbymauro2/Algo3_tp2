package Modelo.Lists;


import Modelo.MainObjects.Player;
import Modelo.MainObjects.StolenItem;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private ArrayList<Player> players;

    public Players(){
        this.players = new ArrayList<>();
    }

    public void add(Player player){
        players.add(player);
    }

    public Player get(int i) {
        return players.get(i);
    }

    public Player getPlayer(String name) {
        for (Player p : players) {
            if (p.equalsName(name)) {
                return  p;
            }
        }
        Player newPlayer = new Player(name,0);
        this.add(newPlayer);
        return newPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

}
