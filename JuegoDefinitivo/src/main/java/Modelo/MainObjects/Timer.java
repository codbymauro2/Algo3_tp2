package Modelo.MainObjects;

import java.util.ArrayList;
import java.util.Iterator;

public class Timer {

    private double duration;
    private String day;
    private int hour;

    private ArrayList<String> daysWeek;
    private Iterator<String> daysWeekIterator;
    private final int sleepHours;

    public Timer(){
        this.duration = 152;

        this.daysWeek = new ArrayList<>();
        this.daysWeek.add("Monday");
        this.daysWeek.add("Tuesday");
        this.daysWeek.add("Wednesday");
        this.daysWeek.add("Thursday");
        this.daysWeek.add("Friday");
        this.daysWeek.add("Saturday");
        this.daysWeek.add("Sunday");
        this.daysWeekIterator = this.daysWeek.iterator();
        this.day = this.daysWeekIterator.next();
        this.hour = 9;
        this.sleepHours = 8;
    }

    public void reduce(double hours) {
        this.duration -= Math.round(hours);
        this.updateDay();
    }

    public void updateDay(){
        this.hour += (152 - this.duration);
        if (hour >= 24){

            if (this.daysWeekIterator.hasNext()) {
                this.day = this.daysWeekIterator.next();
                //duerme 8 horas cuando llegan las 24
                this.hour = this.sleepHours + (this.hour - 24);
            }
            else
                System.out.println("perdiste");
        }
    }

    public String timeLeft() {
        //return (int) this.duration;
        return this.day + " " + String.valueOf(this.hour) + "hs";
    }


}

