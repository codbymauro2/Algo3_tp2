package Modelo.MainObjects;

import Modelo.MainObjects.Buildings.Airport;
import Modelo.MainObjects.Buildings.Bank;
import Modelo.MainObjects.Buildings.Library;

public class Investigator extends Police {

    public Investigator(PoliceStation policeStation) {
        super(policeStation);
        this.velocityKmH = 1300;
        this.stolenItemDifficulty = 2;
        this.citiesToTravel = 5;
    }

    public Investigator() {
        super();
        this.velocityKmH = 1300;
        this.stolenItemDifficulty = 2;
        this.citiesToTravel = 5;
    }


    @Override
    public String enter(Bank bank) {
        this.reduceTimeEnteringBuilding(bank);
        if (this.getCurrentCity().isFinalCity()) {
            return "última ciudad";
        } else if (this.isInCorrectCity()) {
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
            return this.getCurrentCity().getNextCity().getAirport().deployClue(this);
        } else {
            return "No paso por Aca";
        }
    }

}




