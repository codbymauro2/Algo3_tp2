package MainObjects.Buildings;

public class Library implements Building {

    private int entries;

    public void enter(MainObjects.City nextCity, MainObjects.Timer timer, MainObjects.Clue clue) {
        timer.reduce(entries + 1);
        entries++;
        clue.showClue();
    }
}