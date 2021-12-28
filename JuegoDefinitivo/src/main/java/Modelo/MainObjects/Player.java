package Modelo.MainObjects;

import java.util.Objects;

public class Player {

    private int casesWon;
    private String name;

    public Player(String name, int casesWon) {
        this.name = name;
        this.casesWon = casesWon;
    };

    public String getName() {
        return name;
    }

    public int totalCasesWon() {
        return casesWon;
    }

    public void addFinishedCase(int finishedCases) {
        casesWon += finishedCases;
    }

    @Override
    public boolean equals(Object player) {
        return (Objects.equals(this.name, ((Player) player).getName()));
    }

    public boolean equalsName(String givenName) {
        return (Objects.equals(this.name, givenName));
    }


}
