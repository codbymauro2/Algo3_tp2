package Modelo.MainObjects;

import Modelo.Lists.Cities;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;
import Modelo.MainObjects.Buildings.Airport;

public class Rookie extends Police {

    public Rookie() {
        super();
        this.velocityKmH = 900;
        this.stolenItemDifficulty = 1;
        this.citiesToTravel = 4;
    }

    public Rookie(PoliceStation policeStation) {
        super(policeStation);
        this.velocityKmH = 900;
        this.stolenItemDifficulty = 1;
        this.citiesToTravel = 4;
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
        }
    }

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
