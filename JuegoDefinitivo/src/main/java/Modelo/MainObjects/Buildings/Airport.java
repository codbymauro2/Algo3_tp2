package Modelo.MainObjects.Buildings;

import Modelo.MainObjects.*;

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
        return clues.medium();
    }

    @Override
    public String deployClue(Investigator investigator) {
        return (clues.medium() + clues.hard());
    }

    @Override
    public String deployClue(Sergeant sergeant) {
        return clues.hard();
    }


}