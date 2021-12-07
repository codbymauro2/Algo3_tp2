import Lists.SuspectsList;
import MainObjects.Suspect;
import Readers.SuspectReader;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSuspectRead {

    @Test
    public void TestQuantitySuspects() throws IOException {
        SuspectsList suspectList = new SuspectsList();
        SuspectReader reader = new SuspectReader(suspectList);
        reader.read();
        assertEquals(suspectList.size(),1);
    }

    @Test
    public void TestSuspectsName() throws IOException {
        SuspectsList suspectList = new SuspectsList();
        SuspectReader reader = new SuspectReader(suspectList);
        reader.read();
        assertEquals(suspectList.get(0).getName(),"NickBrunch");
    }

}
