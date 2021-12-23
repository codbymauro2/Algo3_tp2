package Modelo.MainObjects;

public class Timer {

    private float duration;

    public Timer(){
        this.duration = 152;
    }

    public void reduce(float hours) {
        this.duration -= hours;
    }

    public float timeLeft() {
        return this.duration;
    }
}