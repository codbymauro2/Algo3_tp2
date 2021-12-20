package MainObjects;

public class Player {

    private int casesWon, difficulty;
    private String name;

    public Player(String name, int casesWon) {
        this.name = name;
        this.casesWon = casesWon;
    };

    public Player(String name){
        this.name = name;
        this.casesWon = 5;
        this.difficulty = 5;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty(){
        return difficulty;
    }

    public int totalCasesWon() {
        return casesWon;
    }

    public void addFinishedCase(int finishedCases) {
        casesWon += finishedCases;
    }
}
