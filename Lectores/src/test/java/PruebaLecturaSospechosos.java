import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PruebaLecturaSospechosos {

    @Test
    public void pruebaLecturaObjetoJson() throws IOException {
        LectorSospechosos lector = new LectorSospechosos();
        lector.leer();
    }
}
