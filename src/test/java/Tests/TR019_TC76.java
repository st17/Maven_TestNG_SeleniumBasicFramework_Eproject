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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TR019_TC76 {
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
    //Verify that up to 20 newest opportunity display the first page when user view opportunity
    @Test
    public void show_20Newest() throws IOException {
        Excel_Object ex1 = new Excel_Object();
        Opportunity_Action.clickOpportunities(dr);
        WaitforControl.waitforControlVisible(dr, "//span[text()='Opportunities']");
        Opportunity_Action.clickShowAllOpportunitys(dr);
        Select sel = new Select(dr.findElement(By.xpath("//*[@id=\"form:carTable_rppDD\"]")));
        int val = sel.getOptions().size();
        if (val != 20)
        {
            ex1.setTC_ID("84");
            ex1.setTC_Summary("Verify that up to 20 newest opportunity display the first page when user view opportunity");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_76");
        } else {
            ex1.setTC_ID("84");
            ex1.setTC_Summary("Verify that up to 20 newest opportunity display the first page when user view opportunity");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_76");
        }
        Result_Execls.saveResultExcel(ex1);
    }
}
