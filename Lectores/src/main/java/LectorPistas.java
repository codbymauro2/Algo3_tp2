import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

class LectorObjetosRobados implements Lector {

    InputStream ins = new FileInputStream("ObjetosRobados.txt");
    Scanner obj = new Scanner(ins);

    LectorObjetosRobados() throws FileNotFoundException {
    }

    public void leerCompleto() {
        while (obj.hasNextLine())
            System.out.println(obj.nextLine());
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
