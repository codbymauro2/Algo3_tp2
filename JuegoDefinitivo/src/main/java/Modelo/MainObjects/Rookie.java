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
        Bank nextBank = this.getCurrentCity().getNextCity().getBank();
        this.reduceTimeEnteringBuilding(nextBank);
        this.checkTimeLeft();

        if (this.getCurrentCity().isFinalCity()){
            return "última ciudad";
        } else if (this.isInCorrectCity()) {
            String bankClue = nextBank.deployClue(this);
            String suspectClue = this.policeStation.getThief().getFeatureClue(this);
            return (bankClue + ".\n" + suspectClue);
        } else {
            return "No paso por Aca";
        }
    }

    @Override
    public String enter(Library library) {

        Library nextLibrary = this.getCurrentCity().getNextCity().getLibrary();
        this.reduceTimeEnteringBuilding(nextLibrary);
        this.checkTimeLeft();

        if (this.getCurrentCity().isFinalCity()) {
            return "última ciudad";
        } else if (this.isInCorrectCity()) {
            String libraryClue = nextLibrary.deployClue(this);
            String suspectClue = this.policeStation.getThief().getFeatureClue(this);
            String returnValue = libraryClue + ".\n" + suspectClue;
            return returnValue;
        } else {
            return "No paso por Aca";
        }
    }

    @Override
    public String enter(Airport airport) {
        Airport nextAirport = this.getCurrentCity().getNextCity().getAirport();
        //acordarme de decirle a mauro que esta linea puede romper
        this.reduceTimeEnteringBuilding(nextAirport);
        this.checkTimeLeft();

        if (this.getCurrentCity().isFinalCity()) {
            return "última ciudad";
            /*
            if (this.warrant)
             */
        } else if (this.isInCorrectCity()) {
            String airportClue = nextAirport.deployClue(this);
            String suspectClue = this.policeStation.getThief().getFeatureClue(this);
            String returnValue = airportClue + ".\n" + suspectClue;
            return returnValue;
        } else {
            return "No paso por Aca";
        }
    }
}
