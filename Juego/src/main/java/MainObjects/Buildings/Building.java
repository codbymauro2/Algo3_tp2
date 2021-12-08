package MainObjects.Buildings;
import MainObjects.City;
import MainObjects.Clue;
import MainObjects.Timer;
import java.util.ArrayList;

public abstract class Building {

    private int entries;
    private Clue clues;

    public void updateTimer(Timer timer){
        timer.reduce(entries + 1);
        entries++;
    }

    public String getClue(int difficulty){
        return(clues.getClue(difficulty));
    }

    public abstract void enterBuilding(City nextCity, int clueDifficulty);
}
