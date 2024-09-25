package metodos;

import modelos.Usuario;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LlenarTablaWebTables {

    public static List<Usuario> readExcelFile() throws FileNotFoundException {
        List<Usuario> usuarios = null;
        try (FileInputStream fis = new FileInputStream(new File("src/main/resources/Data.xlsx"));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet("Hoja1");
            usuarios = new ArrayList<>();

            for (Row row : sheet) {

                if (row.getRowNum() == 0) continue;
                Cell firstNameCell = row.getCell(0);
                Cell lastNameCell = row.getCell(1);
                Cell ageCell = row.getCell(3);
                Cell emailCell = row.getCell(2);
                Cell salaryCell = row.getCell(4);
                Cell departmentCell = row.getCell(5);

                String firstName = firstNameCell.getStringCellValue();
                String lastName = lastNameCell.getStringCellValue();
                String email = emailCell.getStringCellValue();
                int age = (int) ageCell.getNumericCellValue();
                double salary = salaryCell.getNumericCellValue();
                String department = departmentCell.getStringCellValue();

                Usuario usuario = new Usuario(firstName, lastName, email, age, salary, department);
                usuarios.add(usuario);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }
}