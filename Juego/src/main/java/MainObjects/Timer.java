package MainObjects;

public class Timer {

    private int duration;

    public Timer(){
        duration = 176;
    }

    public void reduce(int hours) {
        duration -= hours;
    }

    public int timeLeft() {
        return duration;
    }
}
