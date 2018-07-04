package Tests;

import Actions.*;
import Commons.Result_Execls;
import Commons.WaitforControl;
import Objects.CreateCustomer1_Object;
import Objects.EditCustomer_Object;
import Objects.Excel_Object;
import Objects.Login_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TR10_TC055 {
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
    //Verify that User can edit for the lead when user clicking on Edit button.
    @Test
    public void EditCustomer() throws IOException{
        //1. Move to Customer dropdown.
        ClickCustomer_Action.clickCustomer(dr);
        WaitforControl.waitforControlVisible(dr, ".//a[text()='Show All Customers']");
        //2. Click on Show all customer
        ClickShowAllCustomer_Action.clickShowAllCustomer(dr);
        //3. Select a lead.
        DetailCustomer_Action.clickACustomer(dr);
        //4. Click Edit button
        EditCustomer_Action.clickEdit(dr);

        //5. Edit information
        EditCustomer_Object ob1 = new EditCustomer_Object();
        ob1.setName("huyen123");
        ob1.setEmail("huyennguyen123@gmail.com");
        ob1.setAddress("da nang");
        ob1.setPhone("0978586557");
        EditCustomer_Action.enterCustomer(dr, ob1);

        //6. Clicks on Save button
        EditCustomer_Action.clickSave(dr);

        Excel_Object ex1 = new Excel_Object();
        if (dr.findElement(By.xpath(".//strong[text()='Information']")).isDisplayed() == true) {
            ex1.setTC_ID("17");
            ex1.setTC_Summary("Verify that User can edit for the lead when user clicking on Edit button.");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_055");
        } else {
            ex1.setTC_ID("17");
            ex1.setTC_Summary("Verify that User can edit for the lead when user clicking on Edit button.");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_055");
        }

        Result_Execls.saveResultExcel(ex1);
    }
}
