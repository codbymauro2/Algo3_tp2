import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


public class LectorSospechoso implements Lector {

    InputStream ins = new FileInputStream("pistas_sospechosos.txt");
    Scanner obj = new Scanner(ins);

    public LectorSospechoso() throws FileNotFoundException {
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
