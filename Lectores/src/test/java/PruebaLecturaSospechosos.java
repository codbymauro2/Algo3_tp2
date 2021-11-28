import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaLecturaSospechosos {
    private final int nombreSospechoso = 0;
    private final int autoSospechoso = 5;

    @Test
    public void pruebaLecturanombre() throws FileNotFoundException {
        Lector lector = new LectorSospechoso();
        String nombre = "NickBrunch";
        String[] linea = lector.leerLinea();
        assertEquals(linea[nombreSospechoso],nombre);
    }

    @Test
    public void pruebaLecturaAuto() throws FileNotFoundException {
        Lector lector = new LectorSospechoso();
        String auto = "Convertible";
        String[] linea = lector.leerLinea();
        linea = lector.leerLinea();
        assertEquals(linea[autoSospechoso],auto);
    }
}
