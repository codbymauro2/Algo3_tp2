import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaLecturaCiudades {

    private final int ciudadSeleccionada = 1;

    @Test
    public void pruebaLecturaCiudad() throws FileNotFoundException {
        Lector lector = new LectorCiudades();
        String ciudad = "Athens";
        String[] linea = lector.leerLinea();
        assertEquals(linea[ciudadSeleccionada],ciudad);
    }

    @Test
    public void pruebaLecturaBandera() throws FileNotFoundException {
        Lector lector = new LectorCiudades();
        String ciudad = "Blue and White";
        String[] linea = lector.leerLinea();
        linea = lector.leerLinea();
        assertEquals(linea[ciudadSeleccionada],ciudad);
    }
}
