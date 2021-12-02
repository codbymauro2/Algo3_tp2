import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlayerRead {

    @Test
    public void TestPlayerName() throws IOException {
        ArrayList<Player> playerList = new ArrayList<Player>();
        PlayerReader reader = new PlayerReader(playerList);
        reader.read();
        assertEquals(playerList.get(0).getName(), "Mauro");
    }
}
