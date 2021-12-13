import Lists.Suspects;
import Readers.SuspectReader;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSuspectRead {

    @Test
    public void TestQuantitySuspects() throws IOException {
        Suspects suspectList = new Suspects();
        SuspectReader reader = new SuspectReader(suspectList);
        reader.read();
        assertEquals(suspectList.size(),1);
    }

    @Test
    public void TestSuspectsName() throws IOException {
        Suspects suspectList = new Suspects();
        SuspectReader reader = new SuspectReader(suspectList);
        reader.read();
        assertEquals(suspectList.get(0).getName(),"Merey Laroc");
    }

}
