import Lists.PlayersList;
import MainObjects.Player;

import Readers.PlayerReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import static org.mockito.Mockito.*;

public class TestPlayerRead {

    @Test
    public void TestWithJsonNotEmpty() throws IOException {
        PlayersList playerList = new PlayersList();
        PlayerReader reader = spy(new PlayerReader(playerList));
        reader.read();
        verify(reader,times(1)).storeData();
    }

    @Test
    public void TestPlayerName() throws IOException {
        PlayersList playerList = new PlayersList();
        PlayerReader reader = spy(new PlayerReader(playerList));
        reader.read();
        verify(reader,times(1)).storeData();
        Assertions.assertEquals(playerList.get(0).getName(),"Mauro");
    }

}
