import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class PruebaLecturaObjetosRobados {

    private final int objetoSeleccionado = 0;
    private final int ciudadSeleccionado = 1;

    @Test
    public void pruebaLecturaObjeto() throws FileNotFoundException {
        LectorObjetosRobados lector = new LectorObjetosRobados();
        String objeto = "1,000 Year Old Egg";
        String[] linea = lector.leerLinea();
        assertEquals(linea[objetoSeleccionado],objeto);
    }

    @Test
    public void pruebaLecturaCiudad() throws FileNotFoundException {
        LectorObjetosRobados lector = new LectorObjetosRobados();
        String ciudad = "Peking";
        String[] linea = lector.leerLinea();
        assertEquals(linea[ciudadSeleccionado],ciudad);
    }



}
