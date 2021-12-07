package java.MainObjects;
import java.Actions.*;
import Actions.Action;
import MainObjects.Timer;

public class Police {

    Action actionToDo;
    java.MainObjects.City currentCity;
    int velocity;
    Timer timer;


    public void selectAction(){
        int option = 1;   //ACA IRÍA UN INPUT
        switch (option) {
            case 1:
                // El jugador eligio la opción de entrar al edificio.
                actionToDo = new Actions.EnterBuilding(this.currentCity);
                break;
            case 2:
                // El jugador eligio la opción de viajar.
                actionToDo = new Travel(velocity,currentCity);
                break;
            case 3:
                // El jugador eligio la opción de emitir orden.
                actionToDo = new Actions.EmitWarrant();

                break;
        }
        actionToDo.perform(timer);
    }

    public void perform(Timer timer) {
        actionToDo.perform(timer);
    }

}
