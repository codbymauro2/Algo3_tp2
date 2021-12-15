package MainObjects;

import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Library;

import java.util.ArrayList;

public abstract class Police {

    protected City currentCity;
    protected Planisphere planisphere;
    protected int velocity, timesAttacked, casesWon;
    protected Timer timer;
    protected PoliceStation policeStation;
    protected boolean warrant;
    protected ArrayList<String> features;
    private Suspect warrantSuspect;

    public Police() {
        timer = new Timer();
        warrant = false;
        casesWon = 0;
    }

    public Police(PoliceStation policeStation, Planisphere planisphere) {
        this.planisphere = planisphere;
        this.policeStation = policeStation;
        this.currentCity = policeStation.caseFrom();
        this.timer = new Timer();
        this.warrant = false;
        this.casesWon = 0;
    }

    public abstract String enter(Bank bank);

    public abstract String enter(Library library);

    public void travel(City city){
        currentCity = city;
    }

    public City getCurrentCity(){
        return currentCity;
    }

    public void beAttacked(Knife knife){
        if(timesAttacked >= 1)
            timer.reduce(1);
        else
            timer.reduce(2);
    }

    public void sleep() {
        timer.reduce(8);
    }

    public int getTimeLeft() {
        return timer.timeLeft();
    }

    public void takeCase(City city){
        currentCity = city;
    }

    public boolean isInCity(City city){
        return city.equals(currentCity);
    }

    public void emitWarrant(Suspect suspect){
        this.warrant = true;
        this.warrantSuspect = suspect;
    }


    public void giveFeatures(ArrayList<String> features){
        this.features = features;
    };

    public void arrest(Suspect suspect){
        if(warrant && warrantSuspect.equals(suspect)){
            suspect.arrest();
            this.casesWon = this.casesWon + 1;
        }
    }

    public int finishedCases() {
        return casesWon;
    }

}
