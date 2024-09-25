import com.demoqaPages.DemoQaWebTablesPage;
import metodos.LlenarTablaWebTables;
import modelos.Usuario;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        List<Usuario> usuarios = LlenarTablaWebTables.readExcelFile();

        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNombre() + " " + usuario.getApellido() + " " + usuario.getCorreo() + usuario.getEdad());
        }
    }
}
