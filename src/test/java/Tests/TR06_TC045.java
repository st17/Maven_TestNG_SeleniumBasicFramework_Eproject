package Tests;

import Actions.ClickCustomer_Action;
import Actions.ClickShowAllCustomer_Action;
import Actions.ClickSort_Action;
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

public class TR06_TC045 {
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
    //Verify that User can sort the lead follow the enter date when user clicking on Sort button
    @Test
    public void Sort() throws IOException{
        //1. Move to Customer dropdown.
        ClickCustomer_Action.clickCustomer(dr);
        WaitforControl.waitforControlVisible(dr, ".//a[text()='Show All Customers']");
        //2. Click on Show all customer
        ClickShowAllCustomer_Action.clickShowAllCustomer(dr);
        //3. Click on Sort button.
        ClickSort_Action.clickSort(dr);

        Excel_Object ex = new Excel_Object();
        if (dr.findElement(By.xpath(".//a[@href='/CRMweb/faces/infoCustomer.xhtml?id=511']")).isDisplayed() == true) {
            ex.setTC_ID("20");
            ex.setTC_Summary("Verify that User can sort the lead follow the enter date when user clicking on Sort button");
            ex.setTC_Result("Failed");
            ex.setTC_Note("BugID_016");
        } else {
            ex.setTC_ID("20");
            ex.setTC_Summary("Verify that User can sort the lead follow the enter date when user clicking on Sort button");
            ex.setTC_Result("Passed");
            ex.setTC_Note("BugID_016");
        }

        Result_Execls.saveResultExcel(ex);
    }
    /*Select sel = new Select(dr.findElement(By.xpath("//*[@id=\"form:carTable_rppDD\"]")));
    int val = sel.getOptions().size();
        if (val != 20)
    {
        ex1.setTC_ID("84");
        ex1.setTC_Summary("Verify that up to 20 newest opportunity display the first page when user view opportunity");
        ex1.setTC_Result("F76");ailed");
        ex1.setTC_Note("TC_
    } else {
        ex1.setTC_ID("84");
        ex1.setTC_Summary("Verify that up to 20 newest opportunity display the first page when user view opportunity");
        ex1.setTC_Result("Passed");
        ex1.setTC_Note("TC_76");
    }*/

    /*String field = dr.findElement(By.xpath("//*[@id=\"j_idt108\"]/table/thead/tr")).getText();
        if (field != "Delete")
    {
        ex1.setTC_ID("86");
        ex1.setTC_Summary("Verify that \"Delete\" button displays when user views opportunity detail");
        ex1.setTC_Result("Failed");
        ex1.setTC_Note("TC_99");
    } else {
        ex1.setTC_ID("86");
        ex1.setTC_Summary("Verify that \"Delete\" button displays when user views opportunity detail");
        ex1.setTC_Result("Passed");
        ex1.setTC_Note("TC_99");
    }*/
}
