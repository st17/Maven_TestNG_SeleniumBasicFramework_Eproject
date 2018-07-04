package Tests;

import Actions.ClickCustomer_Action;
import Actions.ClickShowAllCustomer_Action;
import Actions.Login_Action;
import Actions.Pagination_Action;
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

public class TR05_TC043 {
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
    //Verify that User can move to page 2 when user clicking on "Next" button of pagination function.
    @Test
    public void Pagination() throws IOException{
        //1. Move to Customer dropdown.
        ClickCustomer_Action.clickCustomer(dr);
        WaitforControl.waitforControlVisible(dr, ".//a[text()='Show All Customers']");
        //2. Click on Show all customer
        ClickShowAllCustomer_Action.clickShowAllCustomer(dr);
        //3. Click on pagination function
        Pagination_Action.clickPaginationNext(dr);

        Excel_Object ex1 = new Excel_Object();
        if (dr.findElement(By.xpath(".//span[text()='(2 of 9)']")).isDisplayed() == true) {
            ex1.setTC_ID("15");
            ex1.setTC_Summary("Verify that User can move to page 2 when user clicking on \"Next\" button of pagination function.");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_043");
        } else {
            ex1.setTC_ID("15");
            ex1.setTC_Summary("Verify that User can move to page 2 when user clicking on \"Next\" button of pagination function.");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_043");
        }

        Result_Execls.saveResultExcel(ex1);
    }
}
