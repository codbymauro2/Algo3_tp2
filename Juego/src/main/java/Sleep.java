public class Sleep implements Action{
    @Override
    public void perform(Timer timer) {
        timer.reduce(8);

    }
}
