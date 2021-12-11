package MainObjects.Buildings;

import MainObjects.*;

public class Airport extends Building {


    public Airport(Clue clue) {
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


}