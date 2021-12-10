package MainObjects;

import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Library;

public abstract class Police {

    protected Difficulty difficulty;
    protected City currentCity;
    protected Planisphere map;
    protected int velocity, timesAttacked;
    protected Timer timer;


    public Police(Planisphere map) {
        this.map = map;
    }

    public Police(Planisphere map, StolenItem stolenItem){
        this.map = map;
        currentCity = map.getCity(stolenItem.origin());
    }

    public Police() {
        timer = new Timer();
    }

    public abstract String enter(Bank bank);

    public abstract String enter(Library library);

    public abstract void travel(City city);

    public abstract City getCurrentCity();

    public void beAttacked(Knife knife){
        if(timesAttacked >= 1)
            timer.reduce(1);
        else
            timer.reduce(2);
    }

    public abstract void sleep();

    public int getTimeLeft() {
        return timer.timeLeft();
    }
}
