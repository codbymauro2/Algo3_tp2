package Actions;

import Actions.Action;
import MainObjects.Timer;

public class Sleep implements Action {
    @Override
    public void perform(Timer timer) {
        timer.reduce(8);

    }
}
