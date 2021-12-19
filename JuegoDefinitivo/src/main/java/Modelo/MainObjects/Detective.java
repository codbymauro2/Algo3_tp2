package Modelo.MainObjects;


import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;

public class Detective extends Police{

    public Detective() {
        super();
    }

    public Detective(PoliceStation policeStation, Planisphere planisphere) {
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
