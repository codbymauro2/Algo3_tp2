package Modelo.MainObjects.Buildings;


import Modelo.MainObjects.*;

public abstract class Building {

    protected Clue clues;

    public Building(Clue clue) {
        this.clues = clue;
    }

    public abstract String deployClue(Rookie rookie);

    public abstract String deployClue(Detective detective);

    public abstract String deployClue(Investigator investigator);

    public abstract String deployClue(Sergeant sergeant);

    
}
