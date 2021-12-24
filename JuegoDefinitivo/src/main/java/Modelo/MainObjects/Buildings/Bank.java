package Modelo.MainObjects.Buildings;


import Modelo.MainObjects.*;

public class Bank extends Building {

    public Bank(){
        this.name = "Banco";
    }

    public Bank(Clue clue) {
        super(clue);
        this.name = "Bank";
    }

    @Override
    public String deployClue(Rookie rookie) {
        return clues.deploy(rookie);
    }

    @Override
    public String deployClue(Detective detective) {
        return clues.deploy(detective);
    }

    @Override
    public String deployClue(Investigator investigator) {
        return (clues.deploy(investigator) + clues.deploy(investigator));
    }

    @Override
    public String deployClue(Sergeant sergeant) {
        return clues.deploy(sergeant);
    }

}