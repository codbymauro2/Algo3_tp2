package Modelo.MainObjects;

public class Knife implements  Weapon{
    @Override
    public int hurt(Timer timer, int timesAttacked) {
        timesAttacked++;
        if(timesAttacked > 1)
            timer.reduce(1);
        else
            timer.reduce(2);
        return timesAttacked;
    }
}
