package MainObjects.Buildings;
import MainObjects.*;

public abstract class Building {

    protected Clue clues;

    public Building(Clue clue) {
        this.clues = clue;
    }

    public abstract String deployClue(Easy difficulty);

    public abstract void deployClue(Medium difficulty);

    public abstract void deployClue(Hard difficulty);
    
}
