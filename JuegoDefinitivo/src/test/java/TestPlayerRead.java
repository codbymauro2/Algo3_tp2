
import Modelo.Lists.Players;
import Modelo.Lists.Players;
import Modelo.MainObjects.Player;
import Modelo.Readers.PlayerReader;
import Modelo.Writer.PlayerWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.*;

public class TestPlayerRead {

    @Test
    public void TestWithJsonNotEmpty() throws IOException {
        Players playerList = new Players();
        PlayerReader reader = spy(new PlayerReader(playerList));
        reader.read();
        verify(reader,times(1)).storeData();
    }

    @Test
    public void TestPlayerName() throws IOException {
        Players playerList = new Players();
        PlayerReader reader = spy(new PlayerReader(playerList));
        reader.read();
        verify(reader,times(1)).storeData();
        Assertions.assertEquals(playerList.get(0).getName(),"Mauro");
    }

    @Test
    public void TestWritePlayerOnFile() throws IOException{
        Players players = new Players();
        PlayerReader reader = new PlayerReader(players);
        reader.read();
        Player player = new Player("Maradona", 10);
        players.add(player);
        PlayerWriter playerWriter = new PlayerWriter(players);
        playerWriter.write();
    }

}
