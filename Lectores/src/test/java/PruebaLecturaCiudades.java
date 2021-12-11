import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PruebaLecturaCiudades {

    @Test
    public void pruebaLecturaObjetoJson() throws IOException {
        LectorCiudades lector = new LectorCiudades();
        lector.leer();
    }
}
