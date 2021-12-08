package Lists;

import MainObjects.City;
import MainObjects.Ranks.*;

import java.util.ArrayList;

public class Ranks{
    ArrayList<Rank> ranks = new ArrayList<Rank>();

    public Rank getRank(String rankName) {
        Rank rank = this.ranks.stream().
                filter(r -> rankName.equals(r.getRankName())).
                findAny().
                orElse(null);

        return rank;
    }
    public void add(Rank rank) {
        ranks.add(rank);
    }

}
