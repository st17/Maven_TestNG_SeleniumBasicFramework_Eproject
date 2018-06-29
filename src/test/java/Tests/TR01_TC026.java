package Tests;

import Actions.ClickCreateCustomer_Action;
import Actions.ClickCustomer_Action;
import Actions.Login_Action;
import Commons.Result_Execls;
import Commons.WaitforControl;
import Objects.CreateCustomer1_Object;
import Objects.Excel_Object;
import Objects.Login_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TR01_TC026 {
    String siteURL = "http://113.176.100.130:8081/CRMweb/faces/login.xhtml";
    WebDriver dr;

    //Verify that Moves to Customer List page when user login successfully.
    CreateCustomer1_Object create = new CreateCustomer1_Object();
    @BeforeMethod
    public void First () throws IOException {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\drivers\\chromedriver.exe");
        Login_Object ob1 = new Login_Object();
        //2. Enter email and password correct
        ob1.setEmail("vyvanviet@gmail.com");
        ob1.setPassword("abc123");
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get(siteURL);

        //3. Click on Login button.
        Login_Action.enterEmailAndPassword(dr, ob1);
        Login_Action.clickLogin(dr);
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div/div/div/div[2]")).isDisplayed() == true) {
            ex.setTC_ID("8");
            ex.setTC_Summary("Verify that Moves to Customer List page when user login successfully.");
            ex.setTC_Result("Passed");
            ex.setTC_Note("TC_03");
        } else {
            ex.setTC_ID("8");
            ex.setTC_Summary("Verify that Moves to Customer List page when user login successfully.");
            ex.setTC_Result("Failed");
            ex.setTC_Note("TC_03");
        }

        Result_Execls.saveResultExcel(ex);

    }

    //Verify that "Name", "Address", "Phone", "Email" fields displays when user selects "Create customer" in Customer dropdown.
    @Test
    public void CreateACustomer () throws IOException {
        //1. Move to Customer dropdown.
        ClickCustomer_Action.clickCustomer(dr);
        WaitforControl.waitforControlVisible(dr, ".//a[text()='Create Customer']");
        //2. Click on Create Customer
        ClickCreateCustomer_Action.clickCreateCustomer(dr);



        Excel_Object ex1 = new Excel_Object();
        if ((dr.findElement(By.xpath(".//label[text()='Name']")).isDisplayed() == true) && (dr.findElement(By.xpath(".//label[text()='Email']")).isDisplayed()==true)
                && (dr.findElement(By.xpath(".//label[text()='Phone']")).isDisplayed()==true) &&(dr.findElement(By.xpath(".//label[text()='Address']")).isDisplayed()==true) ){
            ex1.setTC_ID("9");
            ex1.setTC_Summary("Verify that \"Name\", \"Address\", \"Phone\", \"Email\" fields displays when user selects \"Create customer\" in Customer dropdown.");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_026");
        } else {
            ex1.setTC_ID("9");
            ex1.setTC_Summary("Verify that \"Name\", \"Address\", \"Phone\", \"Email\" fields displays when user selects \"Create customer\" in Customer dropdown.");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_026");
        }

        Result_Execls.saveResultExcel(ex1);
        //Assert.assertEquals(true,dr.findElement(By.xpath("//strong[text()='Create Customer']")).isDisplayed());


    }
}
