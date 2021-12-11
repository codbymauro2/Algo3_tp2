package Actions;
import MainObjects.City;
import MainObjects.Timer;

public class EnterBuilding implements Action {

    private City currentCity;
    private City nextCity;

    public EnterBuilding(City currentCity) {
        this.currentCity = currentCity;
        this.nextCity = currentCity.getNextCity();
    }

    @Override
    public void perform(Timer timer) {
        currentCity.selectBuilding(timer);
    }
}
