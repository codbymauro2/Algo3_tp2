package MainObjects.Buildings;
import MainObjects.*;

public abstract class Building {

    protected Clue clues;

    public Building(Clue clue) {
        this.clues = clue;
    }

    public abstract String deployClue(Rookie rookie);

    public abstract String deployClue(Detective detective);

    public abstract String deployClue(Investigator investigator);

    
}
