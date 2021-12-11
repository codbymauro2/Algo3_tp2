package MainObjects;

public class Player {

    private int casesWon, difficulty;
    private String name;

    public Player() {};

    public Player(String name){
        this.name = name;
        this.casesWon = 0;
        this.difficulty = 0;
    }

    public String getName() {
        return name;
    }



}
