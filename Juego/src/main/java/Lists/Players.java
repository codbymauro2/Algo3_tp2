package Lists;
import MainObjects.Planisphere;
import MainObjects.Player;

import java.util.ArrayList;

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
}
