package java.Actions;

import Actions.Action;
import java.MainObjects.City;
import MainObjects.Timer;

public class Travel implements Action {
    private int velocity;
    private java.MainObjects.City city;

    public Travel(int velocity, java.MainObjects.City city) {
        this.velocity = velocity;
        this.city = city;
    }

    @Override
    public void perform(Timer timer) {
       // int distance = city.distanceNextCity();
       // int duration = distance/velocity;
       // timer.reduce(duration);
    }

    public void enterNextCity() {
       // city.getNext();
    }

}