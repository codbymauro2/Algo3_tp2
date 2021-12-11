package MainObjects;

import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Library;

public class Rookie extends Police {

    Easy difficulty;

    public Rookie(Planisphere map) {
        super(map);
        difficulty = new Easy();
        timesAttacked = 0;
        timer = new Timer();
    }

    public Rookie(Planisphere map, StolenItem stolenItem) {
        super(map, stolenItem);
    }

    public Rookie() {
        super();
        difficulty = new Easy();
    }

    @Override
    public String enter(Bank bank) {
        return bank.deployClue(this);
    }

    @Override
    public String enter(Library library) {
        return library.deployClue(this);
    }

    @Override
    public City getCurrentCity() {
        return currentCity;
    }

    @Override
    public void sleep() {
        timer.reduce(8);
    }


    public void travel(String city) {

    }


}
