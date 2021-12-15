package MainObjects;

import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Library;

public class Investigator extends Police{

    public Investigator(PoliceStation policeStation, Planisphere planisphere) {
        super(policeStation,planisphere);
    }

    public Investigator() {
        super();
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
