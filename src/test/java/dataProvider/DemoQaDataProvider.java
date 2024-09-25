package dataProvider;

import modelos.Usuario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DemoQaDataProvider {

    @DataProvider(name = "excelData",parallel = false)
    public String[][] getData() throws IOException {
        String [][] data = null;
        File excelFile = new File("src/main/resources/Data.xlsx");
        if (excelFile.exists()) {
            FileInputStream dataFile = new FileInputStream(excelFile);
            XSSFWorkbook workbook = new XSSFWorkbook(dataFile);
            XSSFSheet sheet = workbook.getSheet("Hoja1");
            data = new String[sheet.getPhysicalNumberOfRows() - 1][sheet.getRow(0).getLastCellNum()];
            for (int i = 1; i < sheet.getPhysicalNumberOfRows() ; i++) {
                for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                    DataFormatter formatter = new DataFormatter();
                    data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                }            }

            workbook.close();
            dataFile.close();
        }
        return data;
    }

    @DataProvider(name = "excelDataList",parallel = false)

    public Usuario[] readExcelFile() throws FileNotFoundException {
        Usuario[] usuarios = null;
        int contador = 0;
        try(FileInputStream fis = new FileInputStream(new File("src/main/resources/Data.xlsx"));
            Workbook workbook = new XSSFWorkbook(fis)){
                Sheet sheet = workbook.getSheet("Hoja1");
            usuarios = new Usuario[sheet.getRow(0).getLastCellNum()];
                for (Row row : sheet) {

                    if (row.getRowNum() == 0) continue;
                    Cell firstNameCell = row.getCell(0);
                    Cell lastNameCell = row.getCell(1);
                    Cell ageCell = row.getCell(2);
                    Cell emailCell = row.getCell(3);
                    Cell salaryCell = row.getCell(4);
                    Cell departmentCell = row.getCell(5);

                    String firstName = firstNameCell.getStringCellValue();
                    String lastName = lastNameCell.getStringCellValue();
                    int age = (int) ageCell.getNumericCellValue();
                    String email = emailCell.getStringCellValue();
                    double salary = salaryCell.getNumericCellValue();
                    String department = departmentCell.getStringCellValue();

                    Usuario usuario = new Usuario(firstName,lastName,email,age,salary,department);
                    usuarios[contador] = usuario;
                    contador++;

                }
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  usuarios;
    }
}
