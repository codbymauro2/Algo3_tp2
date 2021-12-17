package MainObjects;

import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Library;

import java.util.ArrayList;
import java.util.Stack;

public abstract class Police {

    protected City currentCity;
    protected Planisphere planisphere;
    protected int velocity, timesAttacked, casesWon;
    protected Timer timer;
    protected PoliceStation policeStation;
    protected boolean warrant;
    protected ArrayList<String> features;
    protected Stack<City> passCities;
    private Suspect warrantSuspect;

    public Police() {
        timer = new Timer();
        warrant = false;
        casesWon = 0;
        passCities = new Stack<>();
    }

    public Police(PoliceStation policeStation, Planisphere planisphere) {
        this.planisphere = planisphere;
        this.policeStation = policeStation;
        this.currentCity = policeStation.caseFrom();
        this.timer = new Timer();
        this.warrant = false;
        this.casesWon = 0;
        passCities = new Stack<>();
    }

    public abstract String enter(Bank bank);

    public abstract String enter(Library library);

    public void travel(City city){
        if (this.hasCome(city))
            passCities.pop();
        else
            passCities.push(city);
        currentCity = city;
    }

    private boolean hasCome(City city) {
        return passCities.peek().equals(city);
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
        passCities.push(city);
        currentCity = city;
    }

    public boolean isInCity(City city){
        return city.equals(currentCity);
    }

    protected void emitWarrant(Suspect suspect){

        if(policeStation.getPossibleSuspectsSize() == 1){
            this.warrant = true;
            this.warrantSuspect = suspect;
        }
    }

    public void giveFeatures(ArrayList<String> features){
        this.features = features;
    };

    public void arrest(Suspect suspect){
        if(warrant && warrantSuspect.equals(suspect)){
            suspect.arrest();
            policeStation.completeCase();
        }
    }

    public int finishedCases() {
        return casesWon;
    }

    protected boolean stayCorrectCity(){
        return currentCity.correctCity();
    };

    public void investigate(String[] features) {
        policeStation.obtainFeatures(features);
        policeStation.findSuspects();
        this.emitWarrant(policeStation.getRobber());
    }

}
