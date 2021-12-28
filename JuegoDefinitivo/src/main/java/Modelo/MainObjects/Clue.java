package Modelo.MainObjects;


import Modelo.MainObjects.Polices.Detective;
import Modelo.MainObjects.Polices.Investigator;
import Modelo.MainObjects.Polices.Rookie;
import Modelo.MainObjects.Polices.Sergeant;

public class Clue {

    String easy, medium, hard;

    public Clue(String easy, String medium, String hard) {
        this.easy = easy;
        this.medium = medium;
        this.hard = hard;
    }

    public String deploy(Rookie rookie) {
        return easy;
    }

    public String deploy(Detective detective) {
        return medium;
    }

    public String deploy(Investigator investigator){
        return medium;
    }

    public String deploy(Sergeant sergeant){
        return hard;
    }
}
