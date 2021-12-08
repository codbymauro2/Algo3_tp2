package MainObjects.Ranks;

public class Rookie implements Rank{
    private int clueDifficulty = 0;
    private String rankName = "Rookie";

    public int getClueDifficulty(){
        return clueDifficulty;
    }

    public String getRankName(){
        return rankName;
    }
}
