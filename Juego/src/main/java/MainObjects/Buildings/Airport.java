package java.MainObjects.Buildings;

public class Airport implements Building {

    private int entries;
    private String buildingType;

    public void enter(MainObjects.Timer timer, String clue) {
        timer.reduce(entries + 1);
        entries++;
        System.out.println(clue);
    }
}