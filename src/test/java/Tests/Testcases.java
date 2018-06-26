package Tests;

//import Actions.CreateCustomer_Action;
import Actions.*;
import Commons.Result_Execls;
import Commons.WaitforControl;
import Objects.CreateCustomer1_Object;
import Objects.Excel_Object;
import Objects.Login_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Testcases {
    String siteURL = "http://113.176.100.130:8081/CRMweb/faces/login.xhtml";
    WebDriver dr;


    //Verify that error message ' Please enter your email' displays when user leave Email field blank
    @Test
    public void dangnhap1() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\PROJECT\\SourceCode\\Maven_TestNG_CRM\\src\\test\\drivers\\chromedriver.exe");

        Login_Object ob2 = new Login_Object();
        ob2.setEmail("");
        ob2.setPassword("abc123");
        dr = new ChromeDriver();
        dr.get(siteURL);

        Login_Action.enterEmailAndPassword(dr, ob2);
        Login_Action.clickLogin(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//span[text()='Please enter your email']")).isDisplayed() == true) {
            ex.setTC_ID("5");
            ex.setTC_Summary("Verify that error message ' Please enter your email' displays when user leave Email field blank");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_01");
        } else {
            ex.setTC_ID("5");
            ex.setTC_Summary("Verify that error message ' Please enter your email' displays when user leave Email field blank");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_01");
        }

        Result_Execls.saveResultExcel(ex);
    }

    //Verify that Moves to Customer List page when user login successfully.
    CreateCustomer1_Object create = new CreateCustomer1_Object();
    @BeforeMethod
    public void First () {
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\PROJECT\\SourceCode\\Maven_TestNG_CRM\\src\\test\\drivers\\chromedriver.exe");
        Login_Object ob1 = new Login_Object();
        ob1.setEmail("vyvanviet@gmail.com");
        ob1.setPassword("abc123");
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get(siteURL);
        Login_Action.enterEmailAndPassword(dr, ob1);
        Login_Action.clickLogin(dr);
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    //Verify that "Name", "Address", "Phone", "Email" fields displays when user selects "Create customer" in Customer dropdown.
    @Test
    public void CreateACustomer () throws IOException {
        ClickCustomer_Action.clickCustomer(dr);

        WaitforControl.waitforControlVisible(dr, ".//a[text()='Create Customer']");

        ClickCreateCustomer_Action.clickCreateCustomer(dr);



        Excel_Object ex1 = new Excel_Object();
        if ((dr.findElement(By.xpath(".//label[text()='Name']")).isDisplayed() == true) && (dr.findElement(By.xpath(".//label[text()='Email']")).isDisplayed()==true)
                && (dr.findElement(By.xpath(".//label[text()='Phone']")).isDisplayed()==true) &&(dr.findElement(By.xpath(".//label[text()='Address']")).isDisplayed()==true) ){
            ex1.setTC_ID("6");
            ex1.setTC_Summary("Verify that \"Name\", \"Address\", \"Phone\", \"Email\" fields displays when user selects \"Create customer\" in Customer dropdown.");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_027");
        } else {
            ex1.setTC_ID("6");
            ex1.setTC_Summary("Verify that \"Name\", \"Address\", \"Phone\", \"Email\" fields displays when user selects \"Create customer\" in Customer dropdown.");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_027");
        }

        Result_Execls.saveResultExcel(ex1);
        //Assert.assertEquals(true,dr.findElement(By.xpath("//strong[text()='Create Customer']")).isDisplayed());


    }

    //Verify that Error message " Please enter your Name" displays when user leave Name field blank.
    @Test
    public void BlankName() throws IOException{
        //1. click vao nut customer o tren menu
        ClickCustomer_Action.clickCustomer(dr);


        WaitforControl.waitforControlVisible(dr, ".//a[text()='Create Customer']");

        ClickCreateCustomer_Action.clickCreateCustomer(dr);


        create.setName("");
        create.setEmail("hongvanlkcit@gmail.com");
        create.setPhone("0935396638");
        create.setAddress("da nang");
        CreateCustomer1_Action.enterCreateACustomer(dr,create);
        CreateCustomer1_Action.clickCreateACustomer(dr);

            Excel_Object ex1 = new Excel_Object();
            if (dr.findElement(By.xpath(".//span[text()='Please enter your name']")).isDisplayed() == true) {
                ex1.setTC_ID("6");
                ex1.setTC_Summary("Verify that Error message \" Please enter your Name\" displays when user leave Name field blank.");
                ex1.setTC_Result("Passed");
                ex1.setTC_Note("TC_027");
            } else {
                ex1.setTC_ID("6");
                ex1.setTC_Summary("Verify that Error message \" Please enter your Name\" displays when user leave Name field blank.");
                ex1.setTC_Result("Failed");
                ex1.setTC_Note("TC_027");
            }

            Result_Execls.saveResultExcel(ex1);

    }
}




