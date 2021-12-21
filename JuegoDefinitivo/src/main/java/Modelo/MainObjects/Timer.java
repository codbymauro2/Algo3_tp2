package Modelo.MainObjects;

public class Timer {

    private int duration;

    public Timer(){
        duration = 152;
    }

    public void reduce(int hours) {
        duration -= hours;
    }

    public int timeLeft() {
        return duration;
    }
}