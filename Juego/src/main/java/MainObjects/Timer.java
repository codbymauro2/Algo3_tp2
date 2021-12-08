package MainObjects;

public class Timer {
    float duration = 176;

    public void reduce(float hours) {
        duration = duration - hours;
    }
}
