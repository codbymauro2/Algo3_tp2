package Modelo.MainObjects;

import com.sun.source.doctree.SerialFieldTree;

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
