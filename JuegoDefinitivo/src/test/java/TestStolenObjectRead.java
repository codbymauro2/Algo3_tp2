
import Modelo.Lists.StolenItems;
import Modelo.Readers.StolenItemsReader;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;


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
