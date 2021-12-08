package MainObjects.Buildings;
import MainObjects.Clue;
import MainObjects.Timer;
import java.util.ArrayList;

public abstract class Building {

    private int entries;
    private Clue clues;

    public void enter(Timer timer, String clue){
        timer.reduce(entries + 1);
        entries++;
        System.out.println(clue);
    }

    public String getClue(int difficulty){
        return(clues.getClue(difficulty));
    }
}
