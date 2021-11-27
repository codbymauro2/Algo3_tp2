import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class LectorCiudades implements Lector{

    InputStream ins = new FileInputStream("Ciudades.txt");
    Scanner obj = new Scanner(ins);

    public LectorCiudades() throws FileNotFoundException {
    }

    @Override
    public String[] leerLinea() {
        return this.separarLinea(obj.nextLine());
    }

    @Override
    public String[] separarLinea(String linea) {
        return linea.split(";");
    }
}
