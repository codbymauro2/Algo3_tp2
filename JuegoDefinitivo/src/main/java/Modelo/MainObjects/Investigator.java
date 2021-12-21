package Modelo.MainObjects;

import Modelo.Lists.Cities;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;

public class Investigator extends Police {

    public Investigator(PoliceStation policeStation) {
        super(policeStation);
        this.velocityKmH = 1300;
        this.stolenItemDifficulty = 2;
    }

    public Investigator() {
        super();
        this.velocityKmH = 1300;
        this.stolenItemDifficulty = 2;
    }


    @Override
    public String enter(Bank bank) {
        return bank.deployClue(this);
    }

    @Override
    public String enter(Library library) {
        return null;
    }


    @Override
    public City getCurrentCity() {
        return null;
    }

    @Override
    public void sleep() {

    }
}
