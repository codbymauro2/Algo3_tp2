package Modelo.MainObjects.Weapons;

import Modelo.MainObjects.Timer;

public interface Weapon {

    int hurt(Timer timer, int timesAttacked);
}
