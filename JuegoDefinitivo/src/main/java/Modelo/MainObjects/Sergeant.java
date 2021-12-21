package Modelo.MainObjects;

import Modelo.Lists.Cities;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;

public class Sergeant extends Police {

    public Sergeant(PoliceStation policeStation) {
        super(policeStation);
        this.velocityKmH = 1500;
        this.stolenItemDifficulty = 3;
        this.citiesToTravel = 7;
    }


    @Override
    public String enter(Bank bank) {
        return bank.deployClue(this);
    }

    @Override
    public String enter(Library library) {
        return library.deployClue(this);
    }
}