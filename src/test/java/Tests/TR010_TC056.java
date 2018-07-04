package Tests;

import Actions.ClickCustomer_Action;
import Actions.ClickShowAllCustomer_Action;
import Actions.DetailCustomer_Action;
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

public class TR010_TC056 {
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
    //Verify that User can delete for the lead when user clicking on Delete button.
    @Test
    public void Delete()throws IOException{
        //1. Move to Customer dropdown.
        ClickCustomer_Action.clickCustomer(dr);
        WaitforControl.waitforControlVisible(dr, ".//a[text()='Show All Customers']");
        //2. Click on Show all customer
        ClickShowAllCustomer_Action.clickShowAllCustomer(dr);

        Excel_Object ex1 = new Excel_Object();
        String field = dr.findElement(By.xpath("//*[@id=\"j_idt71:j_idt72_head\"]/tr")).getText();
        if(field != "Delete"){
            ex1.setTC_ID("22");
            ex1.setTC_Summary("Verify that User can delete for the lead when user clicking on Delete button.");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_056");
        } else {
            ex1.setTC_ID("22");
            ex1.setTC_Summary("Verify that User can delete for the lead when user clicking on Delete button.");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_056");
        }
        Result_Execls.saveResultExcel(ex1);

    }
}
