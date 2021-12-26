package Modelo.MainObjects;

import java.util.ArrayList;
import java.util.Iterator;

public class Timer {

    private double duration;
    private String day;
    private int hour;

    private ArrayList<String> days;
    private int daysIterator;
    private final int sleepHours;

    public Timer() {
        this.duration = 152;

        this.days = new ArrayList<>();
        this.days.add("Monday");
        this.days.add("Tuesday");
        this.days.add("Wednesday");
        this.days.add("Thursday");
        this.days.add("Friday");
        this.days.add("Saturday");
        this.days.add("Sunday");
        this.daysIterator = 0;

        this.hour = 9;
        this.sleepHours = 8;
    }

    public void reduce(double hours) {
        this.duration -= Math.round(hours);
        hour += Math.round(hours);
        if (hour >=24) {
            hour -= 24;
            daysIterator += 1;
        }
    }

    public String timeLeft() {
        System.out.println(duration);
        return days.get(daysIterator) + " " + String.valueOf(this.hour) + "hs";
    }
}
