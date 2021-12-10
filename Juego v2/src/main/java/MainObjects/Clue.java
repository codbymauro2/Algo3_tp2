package MainObjects;
import java.util.ArrayList;

public class Clue {

    String easy, medium, hard;

    public Clue(String easy, String medium, String hard) {
        this.easy = easy;
        this.medium = medium;
        this.hard = hard;
    }

    public String easy() {
        return easy;
    }
}
