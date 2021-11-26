import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class PruebaLecturaObjetosRobados {

    private final int objetoSeleccionado = 0;
    private final int ciudadSeleccionado = 1;

    @Test
    public void pruebaLecturaObjeto() throws FileNotFoundException {
        ScannerClassDemo lectorObjetosRobados = new ScannerClassDemo();
        String objeto = "1,000 Year Old Egg";
        String[] linea = lectorObjetosRobados.leerLinea();
        assertEquals(linea[objetoSeleccionado],objeto);
    }

    @Test
    public void pruebaLecturaCiudad() throws FileNotFoundException {
        ScannerClassDemo lectorObjetosRobados = new ScannerClassDemo();
        String ciudad = "Peking";
        String[] linea = lectorObjetosRobados.leerLinea();
        assertEquals(linea[ciudadSeleccionado],ciudad);
    }



}
