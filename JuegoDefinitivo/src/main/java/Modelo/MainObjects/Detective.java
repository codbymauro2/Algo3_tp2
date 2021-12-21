package Modelo.MainObjects;


import Modelo.Lists.Cities;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;

public class Detective extends Police {

    public Detective() {
        super();
        this.velocityKmH = 1100;
        this.stolenItemDifficulty = 2;
    }

    public Detective(PoliceStation policeStation) {
        super(policeStation);
        this.velocityKmH = 1100;
        this.stolenItemDifficulty = 2;
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