
import Modelo.Lists.Suspects;
import Modelo.Readers.SuspectReader;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSuspectRead {

    @Test
    public void TestQuantitySuspects() throws IOException {
        Suspects suspectList = new Suspects();
        SuspectReader reader = new SuspectReader(suspectList);
        reader.read();
        assertEquals(suspectList.size(),10);
    }

    @Test
    public void TestSuspectsName() throws IOException {
        Suspects suspectList = new Suspects();
        SuspectReader reader = new SuspectReader(suspectList);
        reader.read();
        assertEquals(suspectList.get(0).getName(),"Nick Brunch");
    }

}
