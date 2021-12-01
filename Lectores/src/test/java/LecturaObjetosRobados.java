import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LecturaObjetosRobados {

    @Test
    public void pruebaLecturaObjetoJson() throws IOException {
        LectorObjetosRobados lector = new LectorObjetosRobados();
        lector.leer();
    }

}
