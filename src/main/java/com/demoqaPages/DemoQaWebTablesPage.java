package com.demoqaPages;


import metodos.LlenarTablaWebTables;
import modelos.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

// page_url = https://demoqa.com/webtables
public class DemoQaWebTablesPage {

    private final int index = 0;

    private final Logger logger = LogManager.getLogger(DemoQaWebTablesPage.class);
    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    private WebElement addNewRecordButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]")
    private WebElement table;

    @FindBy(xpath = "//*[@id=\"searchBox\"]")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select")
    private WebElement scrollDownRows;

    @FindBy(xpath = "//input[@aria-label='jump to page']")
    private WebElement jumpToPage;

    @FindBy(xpath = "//*[@id=\"delete-record-" + index +"\"]")
    private WebElement deleteRecordButton;

    @FindBy(xpath = "//*[@id=\"edit-record-"+index+"\"]")
    private WebElement editRecordButton;

    @FindBy(xpath = "/html/body/div[4]/div/div")
    private WebElement registrationFormPage;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@id=\"userEmail\"]")
    private WebElement userEmailInput;

    @FindBy(xpath = "//*[@id=\"age\"]")
    private WebElement ageInput;

    @FindBy(xpath = "//*[@id=\"salary\"]")
    private WebElement salaryInput;

    @FindBy(xpath = "//*[@id=\"department\"]")
    private WebElement departmentInput;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]//div[@role = 'gridcell' and normalize-space(text()) != '']")
    public List<WebElement> nonEmptyResultRows;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/descendant::div[@role='rowgroup']")
    private List<WebElement> rows = new ArrayList<>();

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[1]")
    private WebElement getFIrstNameResult;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[2]")
    private WebElement getLastNameResult;

    public void registrarUsuario(String firstName, String lastName, String email, String age, String salary, String department) throws IOException {

        try{
            if(addNewRecordButton.isDisplayed()){
                    addNewRecordButton.click();
                    firstNameInput.sendKeys(firstName);
                    lastNameInput.sendKeys(lastName);
                    ageInput.sendKeys(age);
                    userEmailInput.sendKeys(email);
                    salaryInput.sendKeys(salary);
                    departmentInput.sendKeys(department);
                    submitButton.click();
            }


        }catch (NoSuchElementException e){
            logger.error("No se puede registrar el usuario{}", e.getMessage());
        }
    }

    public void searchUser(Usuario usuario){
        try{
            if(searchBox.isDisplayed()){
                searchBox.sendKeys(usuario.getCorreo());
            }
        }catch (NoSuchElementException e){
            logger.error("No se puede encontrar el elemento{}", e.getMessage());
        }
    }

    public boolean comparingUsers(Usuario usuario){

        try{
            searchUser(usuario);
            if(!rows.isEmpty() && getFIrstNameResult.getText().equals(usuario.getNombre())
               && getLastNameResult.getText().equals(usuario.getApellido())){
                return true;
            }
        }catch (NoSuchElementException e){
            logger.error("No se puede comparar el usuario{}", e.getMessage());
        }
        return false;
    }

public void registrarUsuario(List<Usuario> usuarios) throws FileNotFoundException {

    for (Usuario elemento : usuarios) {
        addNewRecordButton.click();
        firstNameInput.sendKeys(elemento.getNombre());
        lastNameInput.sendKeys(elemento.getApellido());
        ageInput.sendKeys(String.valueOf(elemento.getEdad()));
        userEmailInput.sendKeys(elemento.getCorreo());
        salaryInput.sendKeys(String.valueOf(elemento.getSalary()).substring(0, String.valueOf(elemento.getSalary()).indexOf(".")));
        departmentInput.sendKeys(elemento.getDepartment());
        submitButton.click();
    }
}

public void findUserByEmail() throws FileNotFoundException {

        List<Usuario> usuarios = LlenarTablaWebTables.readExcelFile();
        registrarUsuario(usuarios);
        try{
            searchBox.sendKeys(usuarios.get(new Random().nextInt(0, usuarios.size())).getCorreo());
        }catch (NoSuchElementException | ElementNotInteractableException e){
            logger.error("No se puede encontrar el elemento{}", e.getMessage());
        }
}

    public DemoQaWebTablesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}