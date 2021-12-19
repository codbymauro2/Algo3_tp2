package Modelo.MainObjects;

public class Player {

    private int casesWon, difficulty;
    private String name;

    public Player(String name, int casesWon) {
        this.name = name;
        this.casesWon = casesWon;
    };

    public Player(String name){
        this.name = name;
        this.casesWon = 0;
        this.difficulty = 0;
    }

    public String getName() {
        return name;
    }


    public int totalCasesWon() {
        return casesWon;
    }

    public void addFinishedCase(int finishedCases) {
        casesWon += finishedCases;
    }
}
