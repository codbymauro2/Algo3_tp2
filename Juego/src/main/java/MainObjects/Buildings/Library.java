package MainObjects.Buildings;

import MainObjects.*;

public class Library extends Building {


    public Library(Clue clue) {
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

    @Override
    public String deployClue(Sergeant sergeant) {
        return null;
    }


}