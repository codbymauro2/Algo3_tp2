package Lists;
import MainObjects.Player;

import java.util.ArrayList;

public class Players {

    ArrayList<Player> players = new ArrayList<>();

    public void add(Player player){
        players.add(player);
    }


    public Player get(int i) {
        return players.get(i);
    }
}
