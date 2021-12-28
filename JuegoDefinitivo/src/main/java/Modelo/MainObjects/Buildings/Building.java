package Modelo.MainObjects.Buildings;

import Modelo.MainObjects.*;
import Modelo.MainObjects.Polices.Detective;
import Modelo.MainObjects.Polices.Investigator;
import Modelo.MainObjects.Polices.Rookie;
import Modelo.MainObjects.Polices.Sergeant;

public abstract class Building {
    protected Clue clues;
    protected String name;

    public Building(Clue clue) {
        this.clues = clue;
    }

    protected Building() {}

    public abstract String deployClue(Rookie rookie);

    public abstract String deployClue(Detective detective);

    public abstract String deployClue(Investigator investigator);

    public abstract String deployClue(Sergeant sergeant);

    public String getName() {
        return name;
    }
}
