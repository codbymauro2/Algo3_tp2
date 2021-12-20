package MainObjects;

import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Library;

public class Sergeant extends Police {

    public Sergeant(PoliceStation policeStation, Planisphere planisphere) {
        super(policeStation,planisphere);
        this.velocityKmH = 1500;
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
