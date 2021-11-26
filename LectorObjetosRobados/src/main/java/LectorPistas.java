import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

class ScannerClassDemo {

    InputStream ins = new FileInputStream("ObjetosRobados.txt");
    Scanner obj = new Scanner(ins);

    ScannerClassDemo() throws FileNotFoundException {
    }

    public void leerCompleto() {
        while (obj.hasNextLine())
            System.out.println(obj.nextLine());
    }

    public String[] leerLinea() {
        return this.separarLinea(obj.nextLine());
    }

    private String[] separarLinea(String linea) {
        return linea.split(";");
    }



}
