package MainObjects;
import java.util.ArrayList;

public class Clue {

    private String easy,medium,hard;

    public void showClue(){
        System.out.println("ACÁ HAY UNA PISTA");
    }

    public String getClue(int difficulty) {
        ArrayList<String> clues = new ArrayList<String>();
        clues.add(easy);
        clues.add(medium);
        clues.add(hard);
        return(clues.get(difficulty));
    }
}
