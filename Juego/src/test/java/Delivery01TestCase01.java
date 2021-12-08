import MainObjects.Ranks.Rookie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import Readers.*;
import MainObjects.*;
import Lists.*;
import MainObjects.Ranks.Rookie;

public class Delivery01TestCase01 {


    @Test
    public void TheyStoleTheMontrealNationalTreasure() throws IOException {

//    Caso de uso 1

//     1- Robaron el tesoro Nacional de Montreal.
//     2- Sospechoso femenino.
//     3- Detectived novato comienza en Montreal.
//     4- Visita un Banco:
//     5- Se despliega una pista.

        // Se inicializan objetos

        StolenItems stolenItems = new StolenItems();
        StolenItemsReader stolenItemsReader = new StolenItemsReader(stolenItems);
        stolenItemsReader.read();
        Cities cities = new Cities();
        CityReader cityReader = new CityReader(cities);
        cityReader.read();
        Suspects suspects = new Suspects();
        SuspectReader suspectReader = new SuspectReader(suspects);
        suspectReader.read();
        Players players = new Players();
        PlayerReader playerReader = new PlayerReader(players);
        playerReader.read();
        Ranks ranks = new Ranks();
        ranks.add(new Rookie());
        Player jugador = players.get(0);
        Suspect ladrona = suspects.get(1);
        StolenItem tesoroNacionalMontreal = stolenItems.get(0);

        //Empieza simulacion
        System.out.println(tesoroNacionalMontreal.getCityName());
        City ciudadActual = cities.getCity(tesoroNacionalMontreal.getCityName());
        City ciudadSiguiente = cities.get(1);
        ciudadActual.setNextCity(ciudadSiguiente);
        Police policia = new Police();
        policia.travel(ciudadActual,ciudadActual);
        policia.enterBank(ciudadActual, ranks.getRank(jugador.getRank()));  // SE TIENE QUE MANDAR ACÁ EL "NOVATO" PARA OBTENER DIFICULTAD DE PISTA

    }



}