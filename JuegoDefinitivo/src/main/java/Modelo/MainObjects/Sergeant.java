package Modelo.MainObjects;

import Modelo.Lists.Cities;
import Modelo.MainObjects.Buildings.Airport;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;

public class Sergeant extends Police {

    public Sergeant(PoliceStation policeStation) {
        super(policeStation);
        this.velocityKmH = 1500;
        this.stolenItemDifficulty = 3;
        this.citiesToTravel = 7;
    }

    public Sergeant() {
        super();
        this.velocityKmH = 1500;
        this.stolenItemDifficulty = 3;
        this.citiesToTravel = 7;
    }

    @Override
    public String enter(Bank bank) {
        this.reduceTimeEnteringBuilding(bank);
        if (this.getCurrentCity().isFinalCity()) {
            return "última ciudad";
        } else if (this.isInCorrectCity()) {
            this.policeStation.getThief().getFeatureClue(this);
            return this.getCurrentCity().getNextCity().getBank().deployClue(this);
        } else {
            return "No paso por Aca";
        }
    }

    @Override
    public String enter(Library library) {
        this.reduceTimeEnteringBuilding(library);
        if (this.getCurrentCity().isFinalCity()) {
            return "última ciudad";
        } else if (this.isInCorrectCity()) {
            this.policeStation.getThief().getFeatureClue(this);
            return this.getCurrentCity().getNextCity().getLibrary().deployClue(this);
        } else {
            return "No paso por Aca";
        }    }

    @Override
    public String enter(Airport airport) {
        this.reduceTimeEnteringBuilding(airport);
        if (this.getCurrentCity().isFinalCity()) {
            return "última ciudad";
        } else if (this.isInCorrectCity()) {
            this.policeStation.getThief().getFeatureClue(this);
            return this.getCurrentCity().getNextCity().getAirport().deployClue(this);
        } else {
            return "No paso por Aca";
        }
    }
}