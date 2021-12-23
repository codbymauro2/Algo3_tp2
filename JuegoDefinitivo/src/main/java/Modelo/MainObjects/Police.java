package Modelo.MainObjects;

import Modelo.Lists.Cities;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;
import Modelo.MainObjects.Buildings.Airport;
import java.util.ArrayList;
import java.util.Stack;

public abstract class Police {

    protected City currentCity;
    protected int velocityKmH, timesAttacked, casesWon, stolenItemDifficulty, citiesToTravel;
    protected Timer timer;
    protected PoliceStation policeStation;
    protected boolean warrant;
    protected Stack<City> visitedCities;
    private Suspect warrantSuspect;

    public Police() {
        timer = new Timer();
        warrant = false;
        casesWon = 0;
        visitedCities = new Stack<>();
    }

    public Police(PoliceStation policeStation) {
        this.policeStation = policeStation;
        this.timer = new Timer();
        this.warrant = false;
        this.casesWon = 0;
        this.timesAttacked = 0;
        visitedCities = new Stack<>();
    }

    public abstract String enter(Bank bank);

    public abstract String enter(Library library);

    public abstract String enter(Airport airport);

    public void travel(City city){
        if (this.passedThrough(city))
            visitedCities.pop();
        else
            visitedCities.push(currentCity);

        this.reduceTime(city);
        currentCity = city;
    }

    private void reduceTime(City city) {
        float timerH = this.currentCity.calculateDistanceTo(city) / this.velocityKmH;
        this.timer.reduce(timerH);
    }

    private boolean passedThrough(City city) {
        if (visitedCities.isEmpty()) { return false; }
        return visitedCities.peek().equals(city);
    }

    public City getCurrentCity(){
        return currentCity;
    }

    public City previousCity() {
        if (visitedCities.isEmpty()) return null;
        return visitedCities.peek();
    }

    public void setCurrentCity(City city) {
        //visitedCities.push(city);
        this.currentCity = city;
    }

    public void beAttacked(Weapon weapon){
        timesAttacked = weapon.hurt(timer,timesAttacked);
    }

    public void sleep() {
        timer.reduce(8);
    }

    public float getTimeLeftInHours() {
        return timer.timeLeft();
    }

    public void takeCase(City city){
        visitedCities.push(city);
        currentCity = city;
    }

    public boolean isInCity(City city){
        return city.equals(currentCity);
    }

    protected void emitWarrant(Suspect suspect){
        if(policeStation.getPossibleSuspectsSize() == 1 && suspect.isInCity(currentCity)) {
            this.warrant = true;
            this.warrantSuspect = suspect;
        }
    }

    public void arrest(Suspect suspect){
        if(warrant && warrantSuspect.equals(suspect)){;
            suspect.arrest();
            policeStation.completeCase();
        }
    }

    public int finishedCases() {
        return casesWon;
    }

    public int getStolenItemDifficulty(){
        return stolenItemDifficulty;
    }

    protected boolean isInCorrectCity(){
        return currentCity.correctCity();
    };

    public void investigate( Feature feature1, Feature feature2, Feature feature3, Feature feature4, Feature feature5) {
        policeStation.obtainFeatures( feature1, feature2, feature3, feature4, feature5);
        policeStation.findSuspects();
        this.emitWarrant(policeStation.getRobber());
    }

    public int getCitiesToTravel(){
        return citiesToTravel;
    }

    public ArrayList<City> getConnections() {
        return currentCity.getConnections();
    };

}
