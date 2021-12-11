package MainObjects;

import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Library;

import java.util.ArrayList;

public abstract class Police {

    protected Difficulty difficulty;
    protected City currentCity;
    protected Planisphere map;
    protected int velocity, timesAttacked;
    protected Timer timer;
    protected boolean warrant;
    protected ArrayList<String> features;



    public Police(Planisphere map) {
        this.map = map;
    }

    public Police(Planisphere map, StolenItem stolenItem){
        this.map = map;
        currentCity = map.getCity(stolenItem.origin());
    }

    public Police() {
        timer = new Timer();
        warrant = false;
    }

    public abstract String enter(Bank bank);

    public abstract String enter(Library library);

    public void travel(City city){
        currentCity = city;
    }

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

    public void takeCase(City city){
        currentCity = city;
    }

    public boolean isInCity(City city){
        return city.equals(currentCity);
    }

    public void enter(PoliceStation policeStation) {
        policeStation.getSuspects(features);
        emitWarrant(policeStation);
    }

    public void emitWarrant(PoliceStation policeStation){
//        if(policeStation.findSuspect()){
//            warrant = true;
//            suspectWarrant = policeStation.suspect();
//        }
        //opcion2
        //stateSuspect.emitir();
    }


    public void giveFeatures(ArrayList<String> features){
        this.features = features;
    };
}
