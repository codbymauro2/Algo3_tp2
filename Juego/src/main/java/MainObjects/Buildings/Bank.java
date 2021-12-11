package MainObjects.Buildings;

import MainObjects.*;

public class Bank extends Building {


    public Bank(Clue clue) {
        super(clue);
    }

    @Override
    public String deployClue(Rookie rookie) {
        return clues.easy();
    }

    @Override
    public String deployClue(Detective detective) {
        return null;
    }

    @Override
    public String deployClue(Investigator investigator) {
        return null;
    }


    //public void reduceTimer()

}