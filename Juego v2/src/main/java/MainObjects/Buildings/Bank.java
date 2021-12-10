package MainObjects.Buildings;

import MainObjects.*;

public class Bank extends Building {


    public Bank(Clue clue) {
        super(clue);
    }

    @Override
    public String deployClue(Easy difficulty) {
        return this.clues.easy();
    }

    @Override
    public void deployClue(Medium difficulty) {

    }

    @Override
    public void deployClue(Hard difficulty) {

    }

    //public void reduceTimer()

}