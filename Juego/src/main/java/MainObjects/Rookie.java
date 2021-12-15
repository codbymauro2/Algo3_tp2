package MainObjects;

import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Library;

public class Rookie extends Police {

    public Rookie() {
        super();
    }

    public Rookie(PoliceStation policeStation, Planisphere planisphere) {
        super(policeStation,planisphere);
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
