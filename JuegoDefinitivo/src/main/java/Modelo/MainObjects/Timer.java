package Modelo.MainObjects;

public class Timer {

    private double duration;

    public Timer(){
        this.duration = 152;
    }

    public void reduce(double hours) {
        this.duration -= Math.round(hours);
    }

    public int timeLeft() {
        return (int) this.duration;
    }
}