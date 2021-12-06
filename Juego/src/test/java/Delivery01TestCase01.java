import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Delivery01TestCase01 {

    @Test
    public void TestTheyStoleTheMontrealNationalTreasure() throws IOException {

        Simulation simulation = Mockito.spy(new Simulation());
        simulation.start();

    }



}
