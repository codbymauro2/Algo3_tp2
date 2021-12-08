package MainObjects;

import MainObjects.Buildings.Bank;
import MainObjects.Buildings.Building;
import MainObjects.Ranks.*;
// import Actions.Action;
import Actions.EmitWarrant;
// import Actions.EnterBuilding;
import Actions.Travel;

public class Police {

    // Action actionToDo;
    City currentCity;
    int velocity = 900;
    Timer timer = new Timer();
    String rank;
    public final int easy = 0;
    public final int medium = 1;
    public final int hard = 2;




//    public void selectAction(){
//        int option = 0;   //ACA IRÍA UN INPUT
//        switch (option) {
//            case 1:
//                // El jugador eligio la opción de entrar al edificio.
//                actionToDo = new EnterBuilding(this.currentCity);
//                break;
//            case 2:
//                // El jugador eligio la opción de viajar.
//                actionToDo = new Travel(velocity,currentCity);
//                break;
//            case 3:
//                // El jugador eligio la opción de emitir orden.
//                actionToDo = new EmitWarrant();
//
//                break;
//        }
//        actionToDo.perform(timer);
//    }

    //public void perform(Timer timer) {
//        actionToDo.perform(timer);
//    }

    public void travel(City origin, City destination){
        float distance =  calculateDistance(origin, destination);
        float delay = distance/velocity;
        timer.reduce(delay);
        this.currentCity = destination;
    }

    private float calculateDistance(City origin, City destination) {
        float distance = (float) Math.sqrt(Math.pow(origin.getLatitude() - destination.getLatitude(),2) + Math.pow(origin.getLongitude() - destination.getLongitude(),2));
        return(distance);
    }

//    public void enterBank(City currentCity, Rank rank){
//        Bank currentCityBank = currentCity.getBank();
//        City nextCity = currentCity.getNextCity();
//        String clue = currentCity.getClue(nextCity.getBank(), rank.getClueDifficulty());
//        currentCityBank.enter(clue);
//    }

    public void enter(Building building, Rank rank){
        City nextCity = currentCity.getNextCity();
        building.enterBuilding(nextCity,rank.getClueDifficulty());
        building.updateTimer(timer);
    }
}
