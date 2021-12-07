package Lists;
import MainObjects.Player;

import java.util.ArrayList;

public class PlayersList {

    ArrayList<Player> players = new ArrayList<>();

    public void add(Player player){
        players.add(player);
    }


    public Player get(int i) {
        return players.get(i);
    }
}
