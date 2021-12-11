package MainObjects;

import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Library;

public class Detective extends Police{



    @Override
    public String enter(Bank bank) {
        return null;
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
