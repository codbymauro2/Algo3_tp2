package MainObjects;

import Actions.Action;
import Actions.EmitWarrant;
import Actions.EnterBuilding;
import Actions.Travel;

public class Police {

    Action actionToDo;
    City currentCity = new City();
    int velocity;
    Timer timer;



    public void selectAction(){
        int option = 1;   //ACA IRÍA UN INPUT
        switch (option) {
            case 1:
                // El jugador eligio la opción de entrar al edificio.
                actionToDo = new EnterBuilding(this.currentCity);
                break;
            case 2:
                // El jugador eligio la opción de viajar.
                actionToDo = new Travel(velocity,currentCity);
                break;
            case 3:
                // El jugador eligio la opción de emitir orden.
                actionToDo = new EmitWarrant();

                break;
        }
        actionToDo.perform(timer);
    }

    public void perform(Timer timer) {
        actionToDo.perform(timer);
    }

}
