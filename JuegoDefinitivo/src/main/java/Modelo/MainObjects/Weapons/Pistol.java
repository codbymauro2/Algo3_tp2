package Modelo.MainObjects.Weapons;

import Modelo.MainObjects.Timer;

public class Pistol implements Weapon {
    private int recoveryTime = 4;

    @Override
    public int hurt(Timer timer, int timesAttacked){
        timer.reduce(recoveryTime);
        return timesAttacked;
    }
}
