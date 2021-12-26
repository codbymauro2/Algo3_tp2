package Modelo.MainObjects.Buildings;

import Modelo.MainObjects.*;

public abstract class Building<timesEntered> {

    public int timesEntered = 0;
    protected Clue clues;
    protected String name;

    public Building(Clue clue) {
        this.clues = clue;
    }

    protected Building() {
    }

    public abstract String deployClue(Rookie rookie);

    public abstract String deployClue(Detective detective);

    public abstract String deployClue(Investigator investigator);

    public abstract String deployClue(Sergeant sergeant);

    public String getName() {
        return name;
    }

    public void enter() { timesEntered++; }

    public int getTimesEntered() { return timesEntered; }
}
