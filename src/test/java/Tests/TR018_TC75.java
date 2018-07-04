package Tests;

import Actions.Login_Action;
import Actions.Opportunity_Action;
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

public class TR018_TC75 {
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
    //Verify that duplicate information displays when user search by "Customer Name" at Search field
    @Test
    public void show_DuplicateInformation() throws IOException {
        Excel_Object ex1 = new Excel_Object();
        Opportunity_Action.clickOpportunities(dr);
        WaitforControl.waitforControlVisible(dr, "//span[text()='Opportunities']");
        Opportunity_Action.clickShowAllOpportunitys(dr);
        CreateCustomer1_Object cus = new CreateCustomer1_Object();
        cus.setName("Hà Võ");
        Opportunity_Action.enter_CustomerName(dr,cus);
        if (dr.findElement(By.xpath("//a[text()='Hà Võ @']")).isDisplayed() == true) {
            ex1.setTC_ID("83");
            ex1.setTC_Summary("Verify that duplicate information displays when user search by \"Customer Name\" at Search field");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_75");
        } else {
            ex1.setTC_ID("83");
            ex1.setTC_Summary("Verify that duplicate information displays when user search by \"Customer Name\" at Search field");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_75");
        }
        Result_Execls.saveResultExcel(ex1);
    }
}
