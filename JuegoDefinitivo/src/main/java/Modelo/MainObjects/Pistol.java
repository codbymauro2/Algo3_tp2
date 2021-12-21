package Modelo.MainObjects;

public class Pistol implements Weapon {
    private int hurt = 4;

    @Override
    public int hurt(Timer timer, int timesAttacked){
        timer.reduce(hurt);
        return timesAttacked;
    }
}
