package Modelo.MainObjects;

import Modelo.Lists.Cities;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;

public class Rookie extends Police {

    public Rookie() {
        super();
        this.velocityKmH = 900;
        this.stolenItemDifficulty = 1;
    }

    public Rookie(PoliceStation policeStation) {
        super(policeStation);
        this.velocityKmH = 900;
        this.stolenItemDifficulty = 1;
    }

    @Override
    public String enter(Bank bank) {

        if (this.isInCorrectCity())
            return bank.deployClue(this);
        else
            return "No paso por Aca";

    }

    @Override
    public String enter(Library library) {
        return library.deployClue(this);
    }

}
