package Modelo.MainObjects;

import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Building;
import Modelo.MainObjects.Buildings.Library;
import Modelo.MainObjects.Buildings.Airport;
import java.util.ArrayList;
import java.util.Stack;

public abstract class Police {

    protected City currentCity;
    protected double velocityKmH;
    protected int timesAttacked, casesWon, stolenItemDifficulty, citiesToTravel;
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
        this.timer.reduce(currentCity.calculateDistanceTo(city) / this.velocityKmH);
    }

    public void reduceTimeEnteringBuilding(Building building)  {
        timer.reduce(building.getTimesEntered() + 1);
        building.enter();
    }

    private boolean passedThrough(City city) {
        if (visitedCities.isEmpty())
            return false;
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
        this.currentCity = city;
    }

    public void beAttacked(Weapon weapon){
        timesAttacked = weapon.hurt(timer,timesAttacked);
    }

    public void sleep() {
        timer.reduce(8);
    }

    public String getTimeLeftInHours() {
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
        if(policeStation.getPossibleSuspectsSize() == 1) {
            this.warrant = true;
            this.warrantSuspect = suspect;
            timer.reduce(3);
            System.out.println("Orden emitida");
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

    public boolean isOutOfTime() { return timer.outOfTime(); }
}
