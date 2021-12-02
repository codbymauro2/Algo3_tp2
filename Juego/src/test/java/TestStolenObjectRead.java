import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStolenObjectRead {

    @Test
    public void TestQuantityStolenObjects() throws IOException {
        ArrayList<StolenItems> stolenItemsList = new ArrayList<StolenItems>();
        StolenItemsReader reader = new StolenItemsReader(stolenItemsList);
        reader.read();
        assertEquals(stolenItemsList.size(),3);
    }

    @Test
    public void TestStolenObjectName() throws IOException {
        ArrayList<StolenItems> stolenItemsList = new ArrayList<StolenItems>();
        StolenItemsReader reader = new StolenItemsReader(stolenItemsList);
        reader.read();
        assertEquals(stolenItemsList.get(0).getName(),"Oro");
    }

}
