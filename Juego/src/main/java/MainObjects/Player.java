package MainObjects;

public class Player {

    private int casesWon;
    private String name, rank;

    public Player() {};

    public Player(String name, String rank){
        this.name = name;
        this.casesWon = 0;
        this.rank = rank;

    }

    public String getName() {
        return name;
    }
    
    public String getRank(){
        return rank;
    }

}
