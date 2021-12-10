import Readers.StolenItemsReader;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import Lists.StolenItems;

public class TestStolenObjectRead {

    @Test
    public void TestQuantityStolenObjects() throws IOException {
        StolenItems stolenItemsList = new StolenItems();
        StolenItemsReader reader = new StolenItemsReader(stolenItemsList);
        reader.read();
        Assertions.assertEquals(stolenItemsList.size(),3);
    }

    @Test
    public void TestStolenObjectName() throws IOException {
        StolenItems stolenItemsList = new StolenItems();
        StolenItemsReader reader = new StolenItemsReader(stolenItemsList);
        reader.read();
        Assertions.assertEquals(stolenItemsList.get(0).getName(),"Tesoro Nacional");
    }

    @Test
    public void TestStolenListFilter() throws IOException {
        StolenItems stolenItems = new StolenItems();
        StolenItemsReader reader = new StolenItemsReader(stolenItems);
        reader.read();
        stolenItems.assign(3);
        stolenItems.show();
    }

}
