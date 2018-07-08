package Tests;

import Actions.ClickCreateCustomer_Action;
import Actions.ClickCustomer_Action;
import Actions.CreateCustomer1_Action;
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

public class TR03_TC040 {
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


    }
    //Verify that validation message " Please check back your information before clicking on OK button" display when user Create customer success.
   @Test
   public void ValidationMessage() throws IOException{
       //1. Move to Customer dropdown.
       ClickCustomer_Action.clickCustomer(dr);

       WaitforControl.waitforControlVisible(dr, ".//a[text()='Create Customer']");
       //2. Click on Create customer
       ClickCreateCustomer_Action.clickCreateCustomer(dr);

       //3. Enter all field correct
       create.setName("anhnhat@gmail.com");
       //4. Enter all field.
       create.setEmail("hongvanlkcit@gmail.com");
       create.setPhone("0935396638");
       create.setAddress("da nang");

       //4. Click on Create a customer button.
       CreateCustomer1_Action.enterCreateACustomer(dr,create);
       CreateCustomer1_Action.clickCreateACustomer(dr);

       Excel_Object ex1 = new Excel_Object();
       if (dr.findElement(By.xpath(".//strong[text()='Show All Customers']")).isDisplayed() == true) {
           ex1.setTC_ID("19");
           ex1.setTC_Summary("Verify that validation message \" Please check back your information before clicking on OK button\" display when user Create customer success");
           ex1.setTC_Result("Failed");
           ex1.setTC_Note("BugID_014");
       } else {
           ex1.setTC_ID("19");
           ex1.setTC_Summary("Verify that validation message \" Please check back your information before clicking on OK button\" display when user Create customer success");
           ex1.setTC_Result("Passed");
           ex1.setTC_Note("BugID_014");
       }

       Result_Execls.saveResultExcel(ex1);
       dr.quit();
   }
}