package Tests;

import Actions.Campaign_Action;
import Actions.Login_Action;
import Commons.Result_Execls;
import Commons.WaitforControl;
import Objects.CampaignType;
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

public class TC_105 {
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
    //Verify that PopUp contains content "Create success" displays when user enters all field correct
    @Test
    public void showPopup() throws IOException
    {
        Excel_Object ex1 = new Excel_Object();
        Campaign_Action.clickCampaign(dr);
        WaitforControl.waitforControlVisible(dr, "//span[text()='Campaigns']");
        Campaign_Action.selectItem4Campaign(dr);
        CampaignType ob1 = new CampaignType();
        ob1.setName("Marketing online");
        Campaign_Action.enterCampaignType(ob1,dr);
        Campaign_Action.clickSubmit(dr);
        if(dr.findElement(By.xpath("//strong[text()='Show All Campaigns Type']")).isDisplayed() == true)
        {
            ex1.setTC_ID("74");
            ex1.setTC_Summary("//Verify that PopUp contains content \"Create success\" displays when user enters all field correct");
            ex1.setTC_Result("Failed");
            ex1.setTC_Note("TC_105");
        }
        else
        {
            ex1.setTC_ID("74");
            ex1.setTC_Summary("//Verify that PopUp contains content \"Create success\" displays when user enters all field correct");
            ex1.setTC_Result("Passed");
            ex1.setTC_Note("TC_105");
        }
        Result_Execls.saveResultExcel(ex1);
    }
}
